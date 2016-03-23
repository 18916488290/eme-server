package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Date;
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
import com.huihuan.eme.domain.db.EmergencyResponsePlan;
import com.huihuan.eme.domain.db.RiskAversion;
import com.huihuan.eme.domain.db.EmergencyReponsePlanType;
import com.huihuan.eme.domain.page.FileMeta;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EmergencyResponsePlanRepository;
import com.huihuan.eme.repository.EmergencyResponsePlanTypeRepository;
import com.huihuan.eme.repository.EpbRepository;
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
public class EmergencyResponsePlanController {

	@Autowired private EmergencyResponsePlanRepository emergencyResponsePlanRepository;
	@Autowired private EmergencyResponsePlanTypeRepository emergencyResponsePlanTypeRepository;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private EpbRepository epbRepository;
	@Autowired private FileUploadServiceImpl fileUploadServiceImpl;

	private static final Log logger = LogFactory.getLog(EmergencyResponsePlanController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteEmergencyResponsePlan")
	public String deleteEmergencyMaterial(@RequestParam Long emergencyResponsePlanId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    emergencyResponsePlanRepository.delete(emergencyResponsePlanId);
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab8");
			return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/emergencyResponsePlanForm",method=RequestMethod.GET)
	public String populateEmergencyResponsePlanForm(@RequestParam(required=false) Long emergencyResponsePlanId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(emergencyResponsePlanId!=null)
		{
			model.put("emergencyResponsePlan",emergencyResponsePlanRepository.findOne(emergencyResponsePlanId));	
		}
		else
		{
			
			EmergencyResponsePlan emergencyResponsePlan = new EmergencyResponsePlan();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			emergencyResponsePlan.setCompany(company);
			model.put("emergencyResponsePlan",emergencyResponsePlan);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		model.put("emergencyResponsePlanTypes", emergencyResponsePlanTypeRepository.findAll());
		model.put("epbs", epbRepository.findAll());
		return "emergencyResponsePlanForm";
	}
	
	@RequestMapping(value="/saveEmergencyResponsePlan",method=RequestMethod.POST)
	public String saveEmergencyResponsePlan(MultipartHttpServletRequest request, HttpServletResponse response,@ModelAttribute("emergencyResponsePlan") EmergencyResponsePlan emergencyResponsePlan,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
		
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab8");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			EmergencyResponsePlan dbEmergencyResponsePlan;
			if(emergencyResponsePlan.getId()==null) 
			{
				dbEmergencyResponsePlan = new EmergencyResponsePlan();
			}
			else
			{
				dbEmergencyResponsePlan =emergencyResponsePlanRepository.findOne(emergencyResponsePlan.getId());
			}
			dbEmergencyResponsePlan.setCompany(companyRepository.findOne(emergencyResponsePlan.getCompany().getId()));
			dbEmergencyResponsePlan.setEmergencyReponsePlanType(emergencyResponsePlanTypeRepository.findOne(emergencyResponsePlan.getEmergencyReponsePlanType().getId()));
		//	dbEmergencyResponsePlan.setCreationDate(emergencyResponsePlan.getCreationDate());
			dbEmergencyResponsePlan.setCreationDate(new Date());
			dbEmergencyResponsePlan.setEpb(epbRepository.findOne(emergencyResponsePlan.getEpb().getId()));
			dbEmergencyResponsePlan.setRegistCode(emergencyResponsePlan.getRegistCode());
			dbEmergencyResponsePlan.setTitle(emergencyResponsePlan.getTitle());
			if(emergencyResponsePlan.getFileName()==null||emergencyResponsePlan.getFileName().isEmpty())
			{
				if( request.getFileNames().hasNext())
				{
					FileMeta fileMeta =fileUploadServiceImpl.upload(request, response);
					dbEmergencyResponsePlan.setFileName(fileMeta.getFileName());
				}
		
			}
			else
			{
				dbEmergencyResponsePlan.setFileName(emergencyResponsePlan.getFileName());
			}
			
			emergencyResponsePlanRepository.save(dbEmergencyResponsePlan);
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab8");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
