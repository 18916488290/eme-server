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
/**环保局审核企业**/
@Controller
public class CompanyAuditController {
	
	@Autowired private CompanyService companyService;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private UsersRepository usersRepository;
	
	private static final Log logger = LogFactory.getLog(CompanyAuditController.class);
	
	@RequestMapping("/companyList")
	public String populateCompanies(Map<String, Object> model) {
		
		model.put("notAuditCompanies", companyService.getCompaniesByStatus(AuditSatusEnum.NotAudit));
		model.put("yesAuditCompanies", companyService.getCompaniesByStatus(AuditSatusEnum.Yes));
		model.put("deniedAuditCompanies", companyService.getCompaniesByStatus(AuditSatusEnum.No));
		
		return "companyList";
	}
	@RequestMapping(value="/auditCompany",method=RequestMethod.GET)
	public String populateCompany(@RequestParam(required=true) long companyId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("company",companyRepository.findOne(companyId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditCompany";
	}
	
	@RequestMapping(value="/auditCompany",method=RequestMethod.POST)
	public String postCompany(@ModelAttribute("company") Company company,@RequestParam String action,Principal principal) {
		logger.debug("company:" + company.getId() +", comment: " + company.getComment() +", action: " + action);
		Company dbCompany = companyRepository.findOne(company.getId());
		dbCompany.setComment(company.getComment());
		dbCompany.setAuditDate(new Date());
		dbCompany.setUsersByAuditor(usersRepository.findOne(principal.getName()));
		if(action.equals("yes"))
		{
			dbCompany.setStatus(AuditSatusEnum.Yes.getIndex());
			Users u = dbCompany.getUsersByCreator();
			u.setEnabled(true);
			usersRepository.save(u);
		}
		else if(action.equals("no"))
			dbCompany.setStatus(AuditSatusEnum.No.getIndex());
		else
		{
			return "redirect:/companyList";
		}
		companyRepository.save(dbCompany);
		return "redirect:/companyList";
	}
	
	
	
}
