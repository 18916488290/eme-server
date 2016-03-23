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
import com.huihuan.eme.domain.db.EmergencyMaterial;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.ChemicalMaterialRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.EmergencyMaterialRepository;
import com.huihuan.eme.repository.EquipmentStateRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.MaterialCategoryRepository;
import com.huihuan.eme.repository.MaterialTypeRepository;
import com.huihuan.eme.repository.PhysicalStateRepository;
import com.huihuan.eme.repository.ProductionModeRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.StorageModeRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.service.CompanyService;
import com.huihuan.eme.service.EmergencyMaterialService;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */

@Controller
public class ChemicalMaterialController {
	
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private ChemicalMaterialRepository chemicalMaterialRepository;
	
	@Autowired private EquipmentStateRepository equipmentStateRepository;
	@Autowired private MaterialCategoryRepository materialCategoryRepository;
	@Autowired private MaterialTypeRepository materialTypeRepository;
	@Autowired private PhysicalStateRepository physicalStateRepository;
	@Autowired private ProductionModeRepository productionModeRepository;
	@Autowired private StorageModeRepository storageModeRepository;

	private static final Log logger = LogFactory.getLog(ChemicalMaterialController.class);
	

	
	@Transactional(readOnly=false)
	@RequestMapping("/deleteChemicalMaterial")
	public String deleteEmergencyMaterial(@RequestParam Long materialId,@RequestParam(required=true) Long riskSourceId, RedirectAttributes attr) {
		    chemicalMaterialRepository.delete(materialId);
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab3");
			return "redirect:/auditSourceTab";
	
	}
	
	
	
	@RequestMapping(value="/chemicalMaterialForm",method=RequestMethod.GET)
	public String populateMaterialForm(@RequestParam(required=false) Long materialId,@RequestParam(required=true) Long riskSourceId,@RequestParam(required=false) String view,  Map<String, Object> model) {
		
		if(materialId!=null)
		{
			model.put("chemicalMaterial",chemicalMaterialRepository.findOne(materialId));	
		}
		else
		{
			
			ChemicalMaterial material = new ChemicalMaterial();
			Company company = riskBasicInfoRepository.findOne(riskSourceId).getCompany();
			material.setCompany(company);
			model.put("chemicalMaterial",material);
		}
		model.put("view", view);
		model.put("riskSourceId", riskSourceId);
		model.put("equipmentStates", equipmentStateRepository.findAll());
		model.put("materialCategories", materialCategoryRepository.findAll());
		model.put("materialTypes", materialTypeRepository.findAll());
		model.put("physicalStates", physicalStateRepository.findAll());
		model.put("productionModes", productionModeRepository.findAll());
		model.put("storageModes", storageModeRepository.findAll());

		return "chemicalMaterialForm";
	}
	
	@RequestMapping(value="/saveChemicalMaterial",method=RequestMethod.POST)
	public String saveMaterial(@ModelAttribute("chemicalMaterial") ChemicalMaterial chemicalMaterial,@RequestParam(required=true) Long riskSourceId,@RequestParam String action,Principal principal, RedirectAttributes attr) {
	
		if(action.equals("no"))
		{
			attr.addAttribute("riskSourceId", riskSourceId);
			attr.addAttribute("tab","box_tab3");
			return "redirect:/auditSourceTab";
		}
		if(action.equals("yes"))
		{
			ChemicalMaterial dbMaterial;
			if(chemicalMaterial.getId()==null) //新建物料
			{
				dbMaterial =  new ChemicalMaterial();
			}
			else
			{
				 dbMaterial = chemicalMaterialRepository.findOne(chemicalMaterial.getId());
			}
			dbMaterial.setCompany(companyRepository.findOne(chemicalMaterial.getCompany().getId()));
			dbMaterial.setMaterialName(chemicalMaterial.getMaterialName());
			dbMaterial.setChemicalName(chemicalMaterial.getChemicalName());
			dbMaterial.setCas(chemicalMaterial.getCas());
			dbMaterial.setPurpose(chemicalMaterial.getPurpose());
			dbMaterial.setQuantity(chemicalMaterial.getQuantity());
			dbMaterial.setAnnualOutput(chemicalMaterial.getAnnualOutput());
			dbMaterial.setEquipmentState(equipmentStateRepository.findOne(chemicalMaterial.getEquipmentState().getId()));
			dbMaterial.setIsHazardous(chemicalMaterial.getIsHazardous());
			dbMaterial.setMaterialCategory(materialCategoryRepository.findOne(chemicalMaterial.getMaterialCategory().getId()));
			dbMaterial.setMaterialType(materialTypeRepository.findOne(chemicalMaterial.getMaterialType().getId()));
			dbMaterial.setPhysicalState(physicalStateRepository.findOne(chemicalMaterial.getPhysicalState().getId()));
			dbMaterial.setProductionMode(productionModeRepository.findOne(chemicalMaterial.getProductionMode().getId()));
	        dbMaterial.setStorageMode(storageModeRepository.findOne(chemicalMaterial.getStorageMode().getId()));
	     
	        chemicalMaterialRepository.save(dbMaterial);
		}
		attr.addAttribute("riskSourceId", riskSourceId);
		attr.addAttribute("tab","box_tab3");
		return "redirect:/auditSourceTab";
	}
	
	
	
	
}
