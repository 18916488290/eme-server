package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.RiskAversion;
import com.huihuan.eme.domain.db.Workmanship;
import com.huihuan.eme.domain.page.FileMeta;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.RiskAversionRepository;
import com.huihuan.eme.repository.RiskAversionTypeRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.repository.WorkmanshipRepository;
import com.huihuan.eme.service.EmergencyMaterialService;
import com.huihuan.eme.service.FileUploadServiceImpl;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
@Controller
public class RiskAversionController {

	@Autowired private RiskAversionRepository riskAversionRepository;
	@Autowired private RiskAversionTypeRepository riskAversionTypeRepository;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private FileUploadServiceImpl fileUploadServiceImpl;

	private static final Log logger = LogFactory.getLog(RiskAversionController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteRiskAversion")
	public String deleteEmergencyMaterial(@RequestParam Long riskAversionId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    riskAversionRepository.delete(riskAversionId);
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab5");
			return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/riskAversionForm",method=RequestMethod.GET)
	public String populateWorkmanshipForm(@RequestParam(required=false) Long riskAversionId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(riskAversionId!=null)
		{
			model.put("riskAversion",riskAversionRepository.findOne(riskAversionId));	
		}
		else
		{
			
			RiskAversion riskAversion = new RiskAversion();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			riskAversion.setCompany(company);
			model.put("riskAversion",riskAversion);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		model.put("riskAversionTypes", riskAversionTypeRepository.findAll());
		return "riskAversionForm";
	}
	
	@RequestMapping(value="/saveRiskAversion",method=RequestMethod.POST)
	public String saveWorkmanship(MultipartHttpServletRequest request, HttpServletResponse response,@ModelAttribute("riskAversion") RiskAversion riskAversion,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
		
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab5");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			RiskAversion dbRiskAversion;
			if(riskAversion.getId()==null) 
			{
				dbRiskAversion = new RiskAversion();
			}
			else
			{
				dbRiskAversion = riskAversionRepository.findOne(riskAversion.getId());
			}
			dbRiskAversion.setCompany(companyRepository.findOne(riskAversion.getCompany().getId()));
			dbRiskAversion.setRemark(riskAversion.getRemark());
			dbRiskAversion.setAuditor(riskAversion.getAuditor());
			dbRiskAversion.setAuditOrg(riskAversion.getAuditOrg());
			dbRiskAversion.setRiskAversionType(riskAversionTypeRepository.findOne(riskAversion.getRiskAversionType().getId()));
			if(riskAversion.getFileName()==null||riskAversion.getFileName().isEmpty())
			{
				if( request.getFileNames().hasNext())
				{
					FileMeta fileMeta =fileUploadServiceImpl.upload(request, response);
					dbRiskAversion.setFileName(fileMeta.getFileName());
				}
		
			}
			else
			{
				dbRiskAversion.setFileName(riskAversion.getFileName());
			}
			
			riskAversionRepository.save(dbRiskAversion);
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab5");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
