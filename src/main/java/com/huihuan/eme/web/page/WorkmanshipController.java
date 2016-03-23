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
import com.huihuan.eme.domain.db.Workmanship;
import com.huihuan.eme.domain.page.FileMeta;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
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
public class WorkmanshipController {

	@Autowired private WorkmanshipRepository workmanshipRepository;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private FileUploadServiceImpl fileUploadServiceImpl;

	private static final Log logger = LogFactory.getLog(WorkmanshipController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteWorkmanship")
	public String deleteEmergencyMaterial(@RequestParam Long workmanshipId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    workmanshipRepository.delete(workmanshipId);
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab4");
			return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/workmanshipForm",method=RequestMethod.GET)
	public String populateWorkmanshipForm(@RequestParam(required=false) Long workmanshipId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(workmanshipId!=null)
		{
			model.put("workmanship",workmanshipRepository.findOne(workmanshipId));	
		}
		else
		{
			
			Workmanship workmanship = new Workmanship();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			workmanship.setCompany(company);
			model.put("workmanship",workmanship);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		return "workmanshipForm";
	}
	
	@RequestMapping(value="/saveWorkmanship",method=RequestMethod.POST)
	public String saveWorkmanship(MultipartHttpServletRequest request, HttpServletResponse response,@ModelAttribute("workmanship") Workmanship workmanship,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
		
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab4");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			Workmanship dbWorkmanship;
			if(workmanship.getId()==null) //新建工艺
			{
				dbWorkmanship = new Workmanship();
			}
			else
			{
				dbWorkmanship = workmanshipRepository.findOne(workmanship.getId());
			}
			dbWorkmanship.setCompany(companyRepository.findOne(workmanship.getCompany().getId()));
			dbWorkmanship.setTitle(workmanship.getTitle());
			dbWorkmanship.setDescription(workmanship.getDescription());
			logger.warn("file name: " + workmanship.getFileName());
			if(workmanship.getFileName()==null||workmanship.getFileName().isEmpty())
			{
				if( request.getFileNames().hasNext())
				{
					FileMeta fileMeta =fileUploadServiceImpl.upload(request, response);
					dbWorkmanship.setFileName(fileMeta.getFileName());
				}
			}
			else
			{
				dbWorkmanship.setFileName(workmanship.getFileName());
			}
			
			workmanshipRepository.save(dbWorkmanship);
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab4");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
