package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Date;
import java.util.List;
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

import com.huihuan.eme.domain.db.ChemicalMaterial;
import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.CompanyWaterEnv;
import com.huihuan.eme.domain.db.CompanyWaterEnvId;
import com.huihuan.eme.domain.db.EmergencyMaterial;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.ChemicalMaterialRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.CompanyWaterEnvRepository;
import com.huihuan.eme.repository.EmergencyMaterialRepository;
import com.huihuan.eme.repository.EnvFuncRepository;
import com.huihuan.eme.repository.EquipmentStateRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.MaterialCategoryRepository;
import com.huihuan.eme.repository.MaterialTypeRepository;
import com.huihuan.eme.repository.PhysicalStateRepository;
import com.huihuan.eme.repository.ProductionModeRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.StorageModeRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.repository.WaterEnvTypeRepository;
import com.huihuan.eme.service.CompanyService;
import com.huihuan.eme.service.EmergencyMaterialService;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */

@Controller
public class WaterEnvController {
	
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private CompanyWaterEnvRepository companyWaterEnvRepository;
	
	@Autowired private EnvFuncRepository envFuncRepository;
	@Autowired private WaterEnvTypeRepository waterEnvTypeRepository;
	

	private static final Log logger = LogFactory.getLog(WaterEnvController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteWaterEnv")
	public String deleteEmergencyMaterial(@RequestParam Long waterEnvId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    
		 CompanyWaterEnvId id = new CompanyWaterEnvId();
		 id.setIdCompany(riskBasicInfoRepository.findOne(riskSourceId).getCompany().getId());
		 id.setIdWaterEnv(waterEnvId);
		 companyWaterEnvRepository.delete(id);
	     attr.addAttribute("riskSourceId", riskSourceId);
		 attr.addAttribute("tab","box_tab7");
		 return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/waterEnvForm",method=RequestMethod.GET)
	public String populateMaterialForm(@RequestParam(required=false) Long waterEnvId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(waterEnvId!=null)
		{
			 CompanyWaterEnvId id = new CompanyWaterEnvId();
			 id.setIdCompany(riskBasicInfoRepository.findOne(riskSourceId).getCompany().getId());
			 id.setIdWaterEnv(waterEnvId);
			 model.put("companyWaterEnv",companyWaterEnvRepository.findOne(id));	
		}
		else
		{
			
			CompanyWaterEnv companyWaterEnv = new CompanyWaterEnv();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			companyWaterEnv.setCompany(company);
			model.put("companyWaterEnv",companyWaterEnv);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		model.put("envFuncs", envFuncRepository.findAll());
		model.put("waterEnvTypes", waterEnvTypeRepository.findAll());
		
		return "waterEnvForm";
	}
	
	@RequestMapping(value="/saveCompanyWaterEnv",method=RequestMethod.POST)
	public String saveMaterial(@ModelAttribute("companyWaterEnv") CompanyWaterEnv companyWaterEnv,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
	
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab7");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			CompanyWaterEnv dbCompanyWaterEnv;
			if(companyWaterEnv.getId()==null) //新建
			{
				dbCompanyWaterEnv =  new CompanyWaterEnv();
				CompanyWaterEnvId id = new CompanyWaterEnvId();
				//id.setIdCompany(idCompany);
			}
			else
			{
				 CompanyWaterEnvId id = new CompanyWaterEnvId();
				 id.setIdCompany(riskBasicInfoRepository.findOne(riskSourceId).getCompany().getId());
				 id.setIdWaterEnv(companyWaterEnv.getId().getIdWaterEnv());
				 dbCompanyWaterEnv = companyWaterEnvRepository.findOne(id);
			}
			dbCompanyWaterEnv.setCompany(companyRepository.findOne(companyWaterEnv.getCompany().getId()));
			
			companyWaterEnvRepository.save(dbCompanyWaterEnv);
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab7");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
