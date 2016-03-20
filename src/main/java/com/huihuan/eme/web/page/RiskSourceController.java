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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.domain.page.RiskSourceInfo;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.IndustrialParkRepository;
import com.huihuan.eme.repository.ProductStatusRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.service.CompanyService;
import com.huihuan.eme.service.RiskSourceService;

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
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private RiskSourceService riskSourceService;
	@Autowired private IndustrialParkRepository industrialParkRepository;
	@Autowired private ProductStatusRepository productStatusRepository;
	
	private static final Log logger = LogFactory.getLog(RiskSourceController.class);
	
	@RequestMapping("/riskSourceList")
	public String populateRiskSources(Map<String, Object> model) {
		
		model.put("notAuditSources", riskSourceService.getRiskSourcesByStatus(AuditSatusEnum.NotAudit));
		model.put("yesAuditSources", riskSourceService.getRiskSourcesByStatus(AuditSatusEnum.Yes));
		model.put("deniedAuditSources", riskSourceService.getRiskSourcesByStatus(AuditSatusEnum.No));
		
		return "riskSourceList";
	}
	
	
	@RequestMapping("/allRiskSourceList")
	public String populateAllRiskSources(Map<String, Object> model) {
		
		model.put("riskSources", riskBasicInfoRepository.findAll());
		
		return "allRiskSourceList";
	}
	
	
	@RequestMapping(value="/auditSourceTab",method=RequestMethod.GET)
	public String populateSourceTab(@RequestParam(required=true) long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("riskSource",riskBasicInfoRepository.findOne(riskSourceId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditSourceTab";
	}
	
	
	
	
	@RequestMapping(value="/riskSourceBasicInfoForm",method=RequestMethod.GET)
	public String populateRiskSourceForm(@RequestParam(required=false) Long riskSourceId, Map<String, Object> model) {
		List<Company> companies = companyRepository.getCompaniesWithNoRiskSource();
		if(riskSourceId==null)
		{
			model.put("riskSourceBasicInfo",new RiskBasicInfo());
		}
		
		else
		{
			RiskBasicInfo riskBasicInfo =riskBasicInfoRepository.findOne(riskSourceId);
			companies.add(0, riskBasicInfo.getCompany());
			model.put("riskSourceBasicInfo",riskBasicInfo);
		}
		model.put("companies", companies);
		model.put("industrialParks", industrialParkRepository.findAll());
		model.put("productStatuses",productStatusRepository.findAll());
		return "riskSourceBasicInfoForm";
	}
	
	
	
	@RequestMapping(value="/auditSource",method=RequestMethod.GET)
	public String populateCompany(@RequestParam(required=true) long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("riskSource",riskBasicInfoRepository.findOne(riskSourceId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditSource";
	}
	
	@RequestMapping(value="/riskSourceInfo",method=RequestMethod.GET)
	public String populateRiskSourceInfo(@RequestParam(required=true) long riskSourceId, Map<String, Object> model) {
		model.put("riskSource",riskBasicInfoRepository.findOne(riskSourceId));
		return "riskSourceInfo";
	}
	

	
	@RequestMapping(value="/saveRiskSourceBasicInfo",method=RequestMethod.POST)
	public String saveRiskSourceBasicInfo(@ModelAttribute("riskSourceBasicInfo") RiskBasicInfo riskSourceBasicInfo,@RequestParam String action,Principal principal,RedirectAttributes attr) {
		
		
		if(action.equals("no"))
		{
			return "redirect:/allRiskSourceList";

		}
		else 
			
		{
			if(riskSourceBasicInfo.getId()==null)
			{
				
				riskSourceBasicInfo.setCreationDate(new Date());
				riskSourceBasicInfo.setIndustrialPark(industrialParkRepository.findOne(riskSourceBasicInfo.getIndustrialPark().getId()));
				riskSourceBasicInfo.setProductStatus(productStatusRepository.findOne(riskSourceBasicInfo.getProductStatus().getId()));
				Company company = companyRepository.findOne(riskSourceBasicInfo.getCompany().getId());
				company.setCorporation(riskSourceBasicInfo.getCompany().getCorporation());
				company.setCorporationFax(riskSourceBasicInfo.getCompany().getCorporationFax());
				company.setLicenseCode(riskSourceBasicInfo.getCompany().getLicenseCode());
				company.setRegistrationCode(riskSourceBasicInfo.getCompany().getRegistrationCode());
	            companyRepository.save(company);
				riskSourceBasicInfo.setCompany(company);
				riskSourceBasicInfo.setRiskName(company.getCompanyName());
				riskSourceBasicInfo.setStatus(AuditSatusEnum.Yes.getIndex());
				riskBasicInfoRepository.save(riskSourceBasicInfo);
				
			}
			else
			{
				RiskBasicInfo dbriskBasicInfo= riskBasicInfoRepository.findOne(riskSourceBasicInfo.getId());
				//dbriskBasicInfo.setCreationDate(new Date());
				dbriskBasicInfo.setIndustrialPark(industrialParkRepository.findOne(riskSourceBasicInfo.getIndustrialPark().getId()));
				dbriskBasicInfo.setProductStatus(productStatusRepository.findOne(riskSourceBasicInfo.getProductStatus().getId()));
				Company company = companyRepository.findOne(riskSourceBasicInfo.getCompany().getId());
				company.setCorporation(riskSourceBasicInfo.getCompany().getCorporation());
				company.setCorporationFax(riskSourceBasicInfo.getCompany().getCorporationFax());
				company.setLicenseCode(riskSourceBasicInfo.getCompany().getLicenseCode());
				company.setRegistrationCode(riskSourceBasicInfo.getCompany().getRegistrationCode());
	            companyRepository.save(company);
	            dbriskBasicInfo.setCompany(company);
	            dbriskBasicInfo.setArea(riskSourceBasicInfo.getArea());
	            dbriskBasicInfo.setLat(riskSourceBasicInfo.getLat());
	            dbriskBasicInfo.setLng(riskSourceBasicInfo.getLng());
	            dbriskBasicInfo.setLvl("重大风险源");
	            dbriskBasicInfo.setEmeMobile(riskSourceBasicInfo.getEmeMobile());
	            dbriskBasicInfo.setEmePerson(riskSourceBasicInfo.getEmePerson());
	            dbriskBasicInfo.setRiskName(company.getCompanyName());
				riskBasicInfoRepository.save(dbriskBasicInfo);
				
			}
			Long riskSourceId = riskSourceBasicInfo.getId();
			attr.addAttribute("riskSourceId", riskSourceId);
			return "redirect:/auditSourceTab";

		}

	}
	
	
	@RequestMapping(value="/auditSource",method=RequestMethod.POST)
	public String postRiskSource(@ModelAttribute("riskSource") RiskBasicInfo riskBasicInfo,@RequestParam String action,Principal principal) {
		
		RiskBasicInfo dbriskBasicInfo= riskBasicInfoRepository.findOne(riskBasicInfo.getId());
		dbriskBasicInfo.setComment(riskBasicInfo.getComment());
		if(action.equals("yes"))
		{
			dbriskBasicInfo.setStatus(AuditSatusEnum.Yes.getIndex());

		}
		else if(action.equals("no"))
			dbriskBasicInfo.setStatus(AuditSatusEnum.No.getIndex());
		else
		{
			return "redirect:/riskSourceList";
		}
		riskBasicInfoRepository.save(dbriskBasicInfo);
		return "redirect:/riskSourceList";
	}
	
	
}
