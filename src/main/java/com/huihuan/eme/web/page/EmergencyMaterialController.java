package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.EmergencyMaterial;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EmergencyMaterialRepository;
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
	
	
	@RequestMapping(value="/auditMaterial",method=RequestMethod.GET)
	public String populateCompany(@RequestParam(required=true) long materialId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("emergencyMaterial",emergencyMaterialRepository.findOne(materialId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditMaterial";
	}
	
	@RequestMapping(value="/auditMaterial",method=RequestMethod.POST)
	public String postCompany(@ModelAttribute("emergencyMaterial") EmergencyMaterial emergencyMaterial,@RequestParam String action,Principal principal) {
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
