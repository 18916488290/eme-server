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
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.domain.page.RiskSourceInfo;
import com.huihuan.eme.repository.CompanyRepository;
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
	public String populateCompanyTab(@RequestParam(required=true) long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		model.put("riskSource",riskBasicInfoRepository.findOne(riskSourceId));
		if(view!=null)
		{
			model.put("view", "yes");
		}
		return "auditSourceTab";
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
