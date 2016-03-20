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
public class EmergencyMaterialController {
	
	@Autowired private EmergencyMaterialService emergencyMaterialService;
	@Autowired private EmergencyMaterialRepository emergencyMaterialRepository;
	@Autowired private UsersRepository usersRepository;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private EquipmentTypeRepository equipmentTypeRepository;

	private static final Log logger = LogFactory.getLog(EmergencyMaterialController.class);
	
	@RequestMapping(value="/emergencyMaterialList")
	public String populateMaterials(Map<String, Object> model) {
		model.put("notAuditMaterials", emergencyMaterialService.getMaterialsByStatus(AuditSatusEnum.NotAudit));
		model.put("yesAuditMaterials", emergencyMaterialService.getMaterialsByStatus(AuditSatusEnum.Yes));
		model.put("deniedAuditMaterials", emergencyMaterialService.getMaterialsByStatus(AuditSatusEnum.No));	
		return "emergencyMaterialList";
	}
	
	
	@RequestMapping(value="/allEmergencyMaterialList")
	public String populateAllMaterials(Map<String, Object> model) {
		model.put("allEmergencyMaterialList", emergencyMaterialRepository.findAll());
		return "allEmergencyMaterialList";
	}
	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteEmergencyMaterial")
	public String deleteEmergencyMaterial(@RequestParam Long materialId, RedirectAttributes attr) {
		    emergencyMaterialRepository.delete(materialId);
			attr.addFlashAttribute("errorMsg", "该物资成功被删除了！");
			return "redirect:/allEmergencyMaterialList";
	
	}
	
	@RequestMapping(value="/auditMaterial",method=RequestMethod.GET)
	public String populateMaterialForAudit(@RequestParam(required=true) long materialId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("emergencyMaterial",emergencyMaterialRepository.findOne(materialId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditMaterial";
	}
	
	
	
	@RequestMapping(value="/emergencyMaterialForm",method=RequestMethod.GET)
	public String populateMaterialForm(@RequestParam(required=false) Long materialId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(materialId!=null)
		{
			model.put("emergencyMaterial",emergencyMaterialRepository.findOne(materialId));	
		}
		else
		{
			
			EmergencyMaterial material = new EmergencyMaterial();
			model.put("emergencyMaterial",material);
		}
		model.put("view", view);
		model.put("companies", companyRepository.findAll());
		model.put("equipmentTypes", equipmentTypeRepository.findAll());
		return "emergencyMaterialForm";
	}
	
	@RequestMapping(value="/saveMaterial",method=RequestMethod.POST)
	public String saveMaterial(@ModelAttribute("emergencyMaterial") EmergencyMaterial emergencyMaterial,@RequestParam String action,Principal principal) {
		logger.debug("emergencyMaterial:" + emergencyMaterial.getId() +", comment: " + emergencyMaterial.getComment() +", action: " + action);
		if(action.equals("no"))
		{
			return "redirect:/allEmergencyMaterialList";
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
		}
		return "redirect:/allEmergencyMaterialList";
	}
	
	
	@RequestMapping(value="/auditMaterial",method=RequestMethod.POST)
	public String postMaterialForAudit(@ModelAttribute("emergencyMaterial") EmergencyMaterial emergencyMaterial,@RequestParam String action,Principal principal) {
		logger.debug("emergencyMaterial:" + emergencyMaterial.getId() +", comment: " + emergencyMaterial.getComment() +", action: " + action);
		EmergencyMaterial dbMaterial = emergencyMaterialRepository.findOne(emergencyMaterial.getId());
		dbMaterial.setComment(emergencyMaterial.getComment());
		dbMaterial.setAuditDate(new Date());
		dbMaterial.setUsersByAuditor(usersRepository.findOne(principal.getName()));
		if(action.equals("yes"))
		{
			dbMaterial.setStatus(AuditSatusEnum.Yes.getIndex());
		}
		else if(action.equals("no"))
			dbMaterial.setStatus(AuditSatusEnum.No.getIndex());
		else
		{
			return "redirect:/emergencyMaterialList";
		}
		emergencyMaterialRepository.save(dbMaterial);
		return "redirect:/emergencyMaterialList";
	}
	
	
	
}
