package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Date;
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
import com.huihuan.eme.domain.db.IndustrySectorDic;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.AdministrativeDicRepository;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;
import com.huihuan.eme.repository.IndustrySectorDicRepository;
import com.huihuan.eme.repository.OperationMaintanceCompanyRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.service.CompanyService;
import com.huihuan.eme.service.UserService;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
/**环保局审核企业**/
@Controller
public class CompanyController {
	
	@Autowired private CompanyService companyService;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private UsersRepository usersRepository;
	@Autowired private UserService userService;
	@Autowired private IndustrySectorDicRepository industrySectorDicRepository;
	@Autowired private ConcernDegreeDicRepository concernDegreeDicRepository;
	@Autowired private AdministrativeDicRepository administrativeDicRepository;
	@Autowired private OperationMaintanceCompanyRepository operationMaintanceCompanyRepository;
	@Autowired private AdministrativeDivisionRepository administrativeDivisionRepository;
	
	private static final Log logger = LogFactory.getLog(CompanyController.class);
	
	
	@RequestMapping("/companyForm")
	public String populateCompanyForm(@RequestParam(required=false) Long companyId, Map<String, Object> model) {
		
		if(companyId!=null)
		{
			model.put("view", "modify");
			model.put("company",companyRepository.findOne(companyId));
		}
		else
		{
			model.put("view", "new");
			Company company = new Company();
			model.put("company",company);
		}
		model.put("industries", industrySectorDicRepository.findAll());
		model.put("administratives", administrativeDicRepository.findAll());
		model.put("concernDegrees", concernDegreeDicRepository.findAll());
		model.put("oms", operationMaintanceCompanyRepository.findAll());
		model.put("administrativeDivisions", administrativeDivisionRepository.findAll());

		return "companyForm";
	}
	
	
	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteCompany")
	public String deleteCompany(@RequestParam Long companyId, RedirectAttributes attr) {
		Company dbCompany = companyRepository.findOne(companyId);
		if(dbCompany.getRiskBasicInfos().isEmpty())
		{
			companyRepository.delete(companyId);
			return "redirect:/allCompanyList";
		}
		else
		{
			attr.addFlashAttribute("errorMsg", "该企业已经申报了风险源，不能删除此企业");
			return "redirect:/allCompanyList";
		}
	
	}
	
	
	@Transactional(readOnly=false)
	@RequestMapping(value="/saveCompany",method=RequestMethod.POST)
	public String saveCompany(@ModelAttribute("company") Company company,@RequestParam(required=false, value="action") String action, Principal principal) {
		logger.debug("company:" + company.getId() );

		if(action!=null&&action.equals("no"))
		{
			return "redirect:/allCompanyList";
		}
	
		company.setAuditDate(new Date());
		company.setUsersByAuditor(usersRepository.findOne(principal.getName()));
		
		if(company.getId() ==null)
		{
			
			Users u = new Users();
			u.setMobile(company.getUsersByCreator().getMobile());
			u.setUsername(company.getUsersByCreator().getMobile());
			u.setPassword(company.getUsersByCreator().getMobile());
			u.setEnabled(true);
			u.setRealName(company.getUsersByCreator().getRealName());
			//u.setEpb(epbRepository.findOne(1l));
			userService.register(u, true);
			company.setUsersByCreator(u);
			company.setCreationDate(new Date());
			company.setStatus(AuditSatusEnum.Yes.getIndex());
			companyRepository.save(company);
		}
		else
		{
			Company dbCompany = companyRepository.findOne(company.getId());
			//logger.warn("mobile: " + company.getUsersByCreator().getMobile() +", realname: " + company.getUsersByCreator().getRealName());
			Users u = 	usersRepository.findByUsername(company.getUsersByCreator().getMobile());
			u.setRealName(company.getUsersByCreator().getRealName());
			usersRepository.save(u);
			dbCompany.setUsersByCreator(u);
			dbCompany.setCompanyName(company.getCompanyName());
			dbCompany.setAdministrativeDivision(administrativeDivisionRepository.findOne(company.getAdministrativeDivision().getId()));
			dbCompany.setAddress(company.getAddress());
			dbCompany.setLat(company.getLat());
			dbCompany.setLng(company.getLng());
			dbCompany.setAdministrativeDic(administrativeDicRepository.findOne(company.getAdministrativeDic().getId()));
			dbCompany.setConcernDegreeDic(concernDegreeDicRepository.findOne(company.getConcernDegreeDic().getId()));
			dbCompany.setIndustrySectorDic(industrySectorDicRepository.findOne(company.getIndustrySectorDic().getId()));
			dbCompany.setOperationMaintanceCompany(operationMaintanceCompanyRepository.findOne(company.getOperationMaintanceCompany().getId()));
			companyRepository.save(dbCompany);
		}
		
		return "redirect:/allCompanyList";
	}
	
	
	@RequestMapping("/allCompanyList")
	public String populateAllCompanies(Map<String, Object> model) {
		model.put("yesAuditCompanies", companyService.getCompaniesByStatus(AuditSatusEnum.Yes));
		return "allCompanyList";
	}
	
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
			model.put("view", view);
		}
		return "auditCompany";
	}
	
	@RequestMapping(value="/auditCompany",method=RequestMethod.POST)
	public String auditCompany(@ModelAttribute("company") Company company,@RequestParam String action,Principal principal) {
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
		{
			dbCompany.setStatus(AuditSatusEnum.No.getIndex());
		}
		else if(action.equals("auditView"))
		{
			return "redirect:/companyList";
		}
		else
		{
			return "redirect:/allCompanyList";
		}
		companyRepository.save(dbCompany);
		return "redirect:/companyList";
	}
	
	
	
}
