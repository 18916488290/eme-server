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
import com.huihuan.eme.domain.db.RiskAversion;
import com.huihuan.eme.domain.db.WarehouseRisk;
import com.huihuan.eme.domain.db.Workmanship;
import com.huihuan.eme.domain.page.FileMeta;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.RiskAversionRepository;
import com.huihuan.eme.repository.RiskAversionTypeRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.StorageMethodRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.repository.WarehouseRiskRepository;
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
public class WarehouseRiskController {

	@Autowired private WarehouseRiskRepository warehouseRiskRepository;
	@Autowired private StorageMethodRepository storageMethodRepository;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private FileUploadServiceImpl fileUploadServiceImpl;

	private static final Log logger = LogFactory.getLog(WarehouseRiskController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteWarehouseRisk")
	public String deleteWarehouseRisk(@RequestParam Long warehouseRiskId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    warehouseRiskRepository.delete(warehouseRiskId);
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab9");
			return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/warehouseRiskForm",method=RequestMethod.GET)
	public String populateWarehouseRiskForm(@RequestParam(required=false) Long warehouseRiskId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(warehouseRiskId!=null)
		{
			model.put("warehouseRisk",warehouseRiskRepository.findOne(warehouseRiskId));	
		}
		else
		{
			
			WarehouseRisk warehouseRisk = new WarehouseRisk();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			warehouseRisk.setCompany(company);
			model.put("warehouseRisk",warehouseRisk);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		model.put("storageMethods", storageMethodRepository.findAll());
		return "warehouseRiskForm";
	}
	
	@RequestMapping(value="/saveWarehouseRisk",method=RequestMethod.POST)
	public String saveWorkmanship(MultipartHttpServletRequest request, HttpServletResponse response,@ModelAttribute("warehouseRisk") WarehouseRisk warehouseRisk,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
		
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab9");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			WarehouseRisk dbWarehouseRisk;
			if(warehouseRisk.getId()==null) 
			{
				dbWarehouseRisk = new WarehouseRisk();
			}
			else
			{
				dbWarehouseRisk = warehouseRiskRepository.findOne(warehouseRisk.getId());
			}
			dbWarehouseRisk.setCompany(companyRepository.findOne(warehouseRisk.getCompany().getId()));
			dbWarehouseRisk.setArea(warehouseRisk.getArea());
			dbWarehouseRisk.setLastModified(new Date());
			dbWarehouseRisk.setLat(warehouseRisk.getLat());
			dbWarehouseRisk.setLng(warehouseRisk.getLng());
			dbWarehouseRisk.setMaterialName(warehouseRisk.getMaterialName());
			dbWarehouseRisk.setWarehouseName(warehouseRisk.getWarehouseName());
			dbWarehouseRisk.setMaterialVolume(warehouseRisk.getMaterialVolume());
			dbWarehouseRisk.setVolume(warehouseRisk.getVolume());
			dbWarehouseRisk.setStorageMethod(storageMethodRepository.findOne(warehouseRisk.getStorageMethod().getId()));
			dbWarehouseRisk.setVolume(warehouseRisk.getVolume());
			
			
			if(warehouseRisk.getFileName()==null||warehouseRisk.getFileName().isEmpty())
			{
				if( request.getFileNames().hasNext())
				{
					FileMeta fileMeta =fileUploadServiceImpl.upload(request, response);
					dbWarehouseRisk.setFileName(fileMeta.getFileName());
				}
		
			}
			else
			{
				dbWarehouseRisk.setFileName(warehouseRisk.getFileName());
			}
			
			warehouseRiskRepository.save(dbWarehouseRisk);
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab9");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
