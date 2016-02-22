package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Date;
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
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.service.CompanyService;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
/**风险源管理**/
@Controller
public class RiskSourceController {
	
	@Autowired private CompanyService companyService;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private UsersRepository usersRepository;
	
	private static final Log logger = LogFactory.getLog(RiskSourceController.class);
	
	@RequestMapping("/riskSourceList")
	public String populateRiskSources(Map<String, Object> model) {
		
		model.put("notAuditSources", companyService.getCompaniesByRiskStatus(AuditSatusEnum.NotAudit));
		model.put("yesAuditSources", companyService.getCompaniesByRiskStatus(AuditSatusEnum.Yes));
		model.put("deniedAuditSources", companyService.getCompaniesByRiskStatus(AuditSatusEnum.No));
		
		return "riskSourceList";
	}
	
	
	@RequestMapping("/allRiskSourceList")
	public String populateAllRiskSources(Map<String, Object> model) {
		
		model.put("riskSources", companyService.getCompaniesByRiskStatus(AuditSatusEnum.NotAudit));
		
		return "allRiskSourceList";
	}
	
	
	@RequestMapping(value="/auditSourceTab",method=RequestMethod.GET)
	public String populateCompanyTab(@RequestParam(required=true) long companyId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("riskSource",companyRepository.findOne(companyId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditSourceTab";
	}
	
	
	
	@RequestMapping(value="/auditSource",method=RequestMethod.GET)
	public String populateCompany(@RequestParam(required=true) long companyId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("riskSource",companyRepository.findOne(companyId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditSource";
	}
	
	@RequestMapping(value="/riskSourceInfo",method=RequestMethod.GET)
	public String populateRiskSourceInfo(@RequestParam(required=true) long companyId, Map<String, Object> model) {
		model.put("riskSource",companyRepository.findOne(companyId));
		return "riskSourceInfo";
	}
	

	@RequestMapping(value="/auditSource",method=RequestMethod.POST)
	public String postRiskSource(@ModelAttribute("riskSource") Company riskSource,@RequestParam String action,Principal principal) {
		
		Company dbCompany = companyRepository.findOne(riskSource.getId());
		dbCompany.setRiskComment(riskSource.getRiskComment());
		if(action.equals("yes"))
		{
			dbCompany.setRiskStatus(AuditSatusEnum.Yes.getIndex());

		}
		else if(action.equals("no"))
			dbCompany.setRiskStatus(AuditSatusEnum.No.getIndex());
		else
		{
			return "redirect:/riskSourceList";
		}
		companyRepository.save(dbCompany);
		return "redirect:/riskSourceList";
	}
	
	
}
