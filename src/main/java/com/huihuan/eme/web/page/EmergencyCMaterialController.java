package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.EmergencyMaterial;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EmergencyMaterialRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.service.CompanyService;
import com.huihuan.eme.service.EmergencyMaterialService;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
/** 应急物资申报，审核，管理**/
@Controller
public class EmergencyCMaterialController {
	
	@Autowired private EmergencyMaterialService emergencyMaterialService;
	@Autowired private EmergencyMaterialRepository emergencyMaterialRepository;
	@Autowired private UsersRepository usersRepository;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private EquipmentTypeRepository equipmentTypeRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;

	private static final Log logger = LogFactory.getLog(EmergencyCMaterialController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteCEmergencyMaterial")
	public String deleteEmergencyMaterial(@RequestParam Long materialId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    emergencyMaterialRepository.delete(materialId);
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab6");
			return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/emergencyCMaterialForm",method=RequestMethod.GET)
	public String populateMaterialForm(@RequestParam(required=false) Long materialId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(materialId!=null)
		{
			model.put("emergencyMaterial",emergencyMaterialRepository.findOne(materialId));	
		}
		else
		{
			
			EmergencyMaterial material = new EmergencyMaterial();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			material.setCompany(company);
			model.put("emergencyMaterial",material);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		model.put("equipmentTypes", equipmentTypeRepository.findAll());
		return "emergencyCMaterialForm";
	}
	
	@RequestMapping(value="/saveCMaterial",method=RequestMethod.POST)
	public String saveMaterial(@ModelAttribute("emergencyMaterial") EmergencyMaterial emergencyMaterial,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
		logger.debug("emergencyMaterial:" + emergencyMaterial.getId() +", comment: " + emergencyMaterial.getComment() +", action: " + action);
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab6");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			EmergencyMaterial dbMaterial;
			if(emergencyMaterial.getId()==null) //新建物料
			{
				dbMaterial = new EmergencyMaterial();
			}
			else
			{
				 dbMaterial = emergencyMaterialRepository.findOne(emergencyMaterial.getId());
			}
			dbMaterial.setCompany(companyRepository.findOne(emergencyMaterial.getCompany().getId()));
			dbMaterial.setMaterialName(emergencyMaterial.getMaterialName());
			dbMaterial.setMaterialCode(emergencyMaterial.getMaterialCode());
			dbMaterial.setCreationDate(new Date());
			dbMaterial.setUsersByCreator(usersRepository.findOne(principal.getName()));
		    dbMaterial.setAuditDate(new Date());
		    dbMaterial.setUsersByAuditor(usersRepository.findOne(principal.getName()));
	        dbMaterial.setStatus(AuditSatusEnum.Yes.getIndex());
	        dbMaterial.setLat(emergencyMaterial.getLat());
	        dbMaterial.setLng(emergencyMaterial.getLng());
	        dbMaterial.setAddress(emergencyMaterial.getAddress());
	        dbMaterial.setFunc(emergencyMaterial.getFunc());
	        dbMaterial.setPurpose(emergencyMaterial.getPurpose());
	        dbMaterial.setOccasion(emergencyMaterial.getOccasion());
	        dbMaterial.setEquipmentType(equipmentTypeRepository.findOne(emergencyMaterial.getEquipmentType().getId()));
	        dbMaterial.setMobile(emergencyMaterial.getMobile());
	        dbMaterial.setQuantity(emergencyMaterial.getQuantity());
		    emergencyMaterialRepository.save(dbMaterial);
		    
		    //add material to baidu LBS
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab6");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
