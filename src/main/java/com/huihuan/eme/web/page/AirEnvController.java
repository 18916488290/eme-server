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

import com.huihuan.eme.domain.db.AirEnv;
import com.huihuan.eme.domain.db.ChemicalMaterial;
import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.CompanyAirEnv;
import com.huihuan.eme.domain.db.CompanyAirEnvId;
import com.huihuan.eme.domain.db.CompanyWaterEnv;
import com.huihuan.eme.domain.db.CompanyWaterEnvId;
import com.huihuan.eme.domain.db.EmergencyMaterial;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.db.WaterEnv;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.AirEnvRepository;
import com.huihuan.eme.repository.AirEnvTypeRepository;
import com.huihuan.eme.repository.ChemicalMaterialRepository;
import com.huihuan.eme.repository.CompanyAirEnvRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.CompanyWaterEnvRepository;
import com.huihuan.eme.repository.EmergencyMaterialRepository;
import com.huihuan.eme.repository.EnvFuncRepository;
import com.huihuan.eme.repository.EquipmentStateRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.LocationDicRepository;
import com.huihuan.eme.repository.MaterialCategoryRepository;
import com.huihuan.eme.repository.MaterialTypeRepository;
import com.huihuan.eme.repository.PhysicalStateRepository;
import com.huihuan.eme.repository.ProductionModeRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.StorageModeRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.repository.WaterEnvRepository;
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
public class AirEnvController {
	
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private CompanyAirEnvRepository companyAirEnvRepository;
	
	@Autowired private EnvFuncRepository envFuncRepository;
	@Autowired private AirEnvTypeRepository airEnvTypeRepository;
	@Autowired private AirEnvRepository airEnvRepository;
	@Autowired private LocationDicRepository locationDicRepository;

	private static final Log logger = LogFactory.getLog(AirEnvController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteAirEnv")
	public String deleteEmergencyMaterial(@RequestParam Long airEnvId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    
		 CompanyAirEnvId id = new CompanyAirEnvId();
		 id.setIdCompany(riskBasicInfoRepository.findOne(riskSourceId).getCompany().getId());
		 id.setIdAirEnv(airEnvId);
		 companyAirEnvRepository.delete(id);
	     attr.addAttribute("riskSourceId", riskSourceId);
		 attr.addAttribute("tab","box_tab7");
		 return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/airEnvForm",method=RequestMethod.GET)
	public String populateMaterialForm(@RequestParam(required=false) Long airEnvId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(airEnvId!=null)
		{
			 CompanyAirEnvId id = new CompanyAirEnvId();
			 id.setIdCompany(riskBasicInfoRepository.findOne(riskSourceId).getCompany().getId());
			 id.setIdAirEnv(airEnvId);
			 model.put("companyAirEnv",companyAirEnvRepository.findOne(id));	
		}
		else
		{
			
			CompanyAirEnv companyAirEnv = new CompanyAirEnv();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			companyAirEnv.setCompany(company);
			model.put("companyAirEnv",companyAirEnv);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		model.put("envFuncs", envFuncRepository.findAll());
		model.put("airEnvs", airEnvRepository.findAll());
		model.put("airEnvTypes", airEnvTypeRepository.findAll());
		
		model.put("locationDics", locationDicRepository.findAll());
		
		
		return "airEnvForm";
	}
	
	@RequestMapping(value="/saveCompanyAirEnv",method=RequestMethod.POST)
	public String saveMaterial(@ModelAttribute("companyAirEnv") CompanyAirEnv companyAirEnv,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
	
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab7");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			CompanyAirEnv dbCompanyAirEnv;
			if(companyAirEnv.getAirEnv()!=null&&!companyAirEnv.getAirEnv().getId().equals(-1l))
			{
				 AirEnv we = airEnvRepository.findOne(companyAirEnv.getAirEnv().getId());
				 CompanyAirEnvId id = new CompanyAirEnvId();
				 id.setIdCompany(riskBasicInfoRepository.findOne(riskSourceId).getCompany().getId());
				 id.setIdAirEnv(companyAirEnv.getAirEnv().getId());
				 dbCompanyAirEnv = companyAirEnvRepository.findOne(id);
				 if(dbCompanyAirEnv==null)
				 {
					 dbCompanyAirEnv = new CompanyAirEnv();
					 dbCompanyAirEnv.setId(id);
					 
				 }
				 dbCompanyAirEnv.setCompany(companyRepository.findOne(companyAirEnv.getCompany().getId()));
				 dbCompanyAirEnv.setDistance(companyAirEnv.getDistance());
				 dbCompanyAirEnv.setAirEnv(we);
				 dbCompanyAirEnv.setDistance(companyAirEnv.getDistance());
				 dbCompanyAirEnv.setLocationDic(locationDicRepository.findOne(companyAirEnv.getLocationDic().getId()));
			     companyAirEnvRepository.save(dbCompanyAirEnv);

			}
			
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab7");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
	
	
	
	
}
