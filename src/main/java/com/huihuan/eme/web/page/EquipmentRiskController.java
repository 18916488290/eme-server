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
import com.huihuan.eme.domain.db.EquipmentRisk;
import com.huihuan.eme.domain.db.RiskAversion;
import com.huihuan.eme.domain.db.WarehouseRisk;
import com.huihuan.eme.domain.db.Workmanship;
import com.huihuan.eme.domain.page.FileMeta;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EquipmentRiskRepository;
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
public class EquipmentRiskController {

	@Autowired private EquipmentRiskRepository equipmentRiskRepository;
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;

	private static final Log logger = LogFactory.getLog(EquipmentRiskController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteEquipmentRisk")
	public String deleteWarehouseRisk(@RequestParam Long equipmentRiskId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    equipmentRiskRepository.delete(equipmentRiskId);
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab10");
			return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/equipmentRiskForm",method=RequestMethod.GET)
	public String populateWarehouseRiskForm(@RequestParam(required=false) Long equipmentRiskId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(equipmentRiskId!=null)
		{
			model.put("equipmentRisk",equipmentRiskRepository.findOne(equipmentRiskId));	
		}
		else
		{
			
			EquipmentRisk equipmentRisk = new EquipmentRisk();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			equipmentRisk.setCompany(company);
			model.put("equipmentRisk",equipmentRisk);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		return "equipmentRiskForm";
	}
	
	@RequestMapping(value="/saveEquipmentRisk",method=RequestMethod.POST)
	public String saveWorkmanship(@ModelAttribute("equipmentRisk") EquipmentRisk equipmentRisk,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
		
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab10");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			EquipmentRisk dbEquipmentRisk;
			if(equipmentRisk.getId()==null) 
			{
				dbEquipmentRisk = new EquipmentRisk();
			}
			else
			{
				dbEquipmentRisk = equipmentRiskRepository.findOne(equipmentRisk.getId());
			}
			dbEquipmentRisk.setCompany(companyRepository.findOne(equipmentRisk.getCompany().getId()));
			dbEquipmentRisk.setBrand(equipmentRisk.getBrand());
			dbEquipmentRisk.setEquipmentModel(equipmentRisk.getEquipmentModel());
			dbEquipmentRisk.setEquipmentName(equipmentRisk.getEquipmentName());
			dbEquipmentRisk.setInstallAddress(equipmentRisk.getInstallAddress());
			dbEquipmentRisk.setInstallDate(new Date());
			dbEquipmentRisk.setLat(equipmentRisk.getLat());
			dbEquipmentRisk.setLng(equipmentRisk.getLng());
			dbEquipmentRisk.setLifetime(equipmentRisk.getLifetime());
			dbEquipmentRisk.setRiskDes(equipmentRisk.getRiskDes());
			
			equipmentRiskRepository.save(dbEquipmentRisk);
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab10");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
