package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvreader.CsvReader;
import com.huihuan.eme.domain.db.AdministrativeDivision;
import com.huihuan.eme.domain.db.AirEnv;
import com.huihuan.eme.domain.db.ChemicalMaterial;
import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.CompanyAirEnv;
import com.huihuan.eme.domain.db.CompanyAirEnvId;
import com.huihuan.eme.domain.db.CompanyWaterEnv;
import com.huihuan.eme.domain.db.CompanyWaterEnvId;
import com.huihuan.eme.domain.db.EmergencyResponsePlan;
import com.huihuan.eme.domain.db.EnvProtPerson;
import com.huihuan.eme.domain.db.EquipmentRisk;
import com.huihuan.eme.domain.db.HousePlan;
import com.huihuan.eme.domain.db.LocationDic;
import com.huihuan.eme.domain.db.ProductStatus;
import com.huihuan.eme.domain.db.RiskAversion;
import com.huihuan.eme.domain.db.RiskAversionOptions;
import com.huihuan.eme.domain.db.RiskAversionOptionsDic;
import com.huihuan.eme.domain.db.RiskAversionOptionsId;
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.db.WarehouseRisk;
import com.huihuan.eme.domain.db.WaterEnv;
import com.huihuan.eme.domain.db.Workmanship;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.AdministrativeDicRepository;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.AirEnvRepository;
import com.huihuan.eme.repository.AirEnvTypeRepository;
import com.huihuan.eme.repository.ChemicalMaterialRepository;
import com.huihuan.eme.repository.CompanyAirEnvRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.CompanyWaterEnvRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;
import com.huihuan.eme.repository.EmergencyResponsePlanRepository;
import com.huihuan.eme.repository.EmergencyResponsePlanTypeRepository;
import com.huihuan.eme.repository.EnvFuncRepository;
import com.huihuan.eme.repository.EnvProtPersonRepository;
import com.huihuan.eme.repository.EpbRepository;
import com.huihuan.eme.repository.EquipmentRiskRepository;
import com.huihuan.eme.repository.EquipmentStateRepository;
import com.huihuan.eme.repository.HousePlanRepository;
import com.huihuan.eme.repository.IndustrialParkRepository;
import com.huihuan.eme.repository.IndustrySectorDicRepository;
import com.huihuan.eme.repository.LocationDicRepository;
import com.huihuan.eme.repository.MaterialCategoryRepository;
import com.huihuan.eme.repository.MaterialTypeRepository;
import com.huihuan.eme.repository.OperationMaintanceCompanyRepository;
import com.huihuan.eme.repository.PhysicalStateRepository;
import com.huihuan.eme.repository.ProductStatusRepository;
import com.huihuan.eme.repository.ProductionModeRepository;
import com.huihuan.eme.repository.RiskAversionOptionsDicRepository;
import com.huihuan.eme.repository.RiskAversionOptionsRepository;
import com.huihuan.eme.repository.RiskAversionRepository;
import com.huihuan.eme.repository.RiskAversionTypeRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.StorageMethodRepository;
import com.huihuan.eme.repository.StorageModeRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.repository.WarehouseRiskRepository;
import com.huihuan.eme.repository.WaterEnvRepository;
import com.huihuan.eme.repository.WaterEnvTypeRepository;
import com.huihuan.eme.repository.WorkmanshipRepository;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("companyService")
@Transactional(readOnly=true)
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private UserService userService;
	@Autowired private IndustrySectorDicRepository industrySectorDicRepository;
	@Autowired private ConcernDegreeDicRepository concernDegreeDicRepository;
	@Autowired private AdministrativeDicRepository administrativeDicRepository;
	@Autowired private OperationMaintanceCompanyRepository operationMaintanceCompanyRepository;
	@Autowired private AdministrativeDivisionRepository administrativeDivisionRepository;
	@Autowired private EpbRepository epbRepository;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private IndustrialParkRepository industrialParkRepository;
	@Autowired private ProductStatusRepository productStatusRepository;
	@Autowired private HousePlanRepository housePlanRepository;
	@Autowired private ChemicalMaterialRepository chemicalMaterialRepository;
	@Autowired private PhysicalStateRepository physicalStateRepository;
	@Autowired private MaterialCategoryRepository materialCategoryRepository;
	@Autowired private StorageModeRepository storageModeRepository;
	@Autowired private EquipmentStateRepository equipmentStateRepository;
	@Autowired private MaterialTypeRepository materialTypeRepository;
	@Autowired private ProductionModeRepository productionModeRepository;
	@Autowired private WorkmanshipRepository workmanshipRepository;
	@Autowired private RiskAversionRepository riskAversionRepository;
	@Autowired private RiskAversionTypeRepository riskAversionTypeRepository;
	@Autowired private RiskAversionOptionsRepository riskAversionOptionsRepository;
	@Autowired private RiskAversionOptionsDicRepository riskAversionOptionsDicRepository;
	@Autowired private WaterEnvRepository waterEnvRepository;
	@Autowired private WaterEnvTypeRepository waterEnvTypeRepository;
	@Autowired private AirEnvRepository airEnvRepository;
	@Autowired private AirEnvTypeRepository airEnvTypeRepository;
	@Autowired private EnvFuncRepository envFuncRepository;
	@Autowired private LocationDicRepository locationDicRepository;
	@Autowired private CompanyWaterEnvRepository companyWaterEnvRepository;
	@Autowired private CompanyAirEnvRepository companyAirEnvRepository;
	@Autowired private EmergencyResponsePlanTypeRepository emergencyResponsePlanTypeRepository;
	@Autowired private EmergencyResponsePlanRepository emergencyResponsePlanRepository;
	@Autowired private WarehouseRiskRepository warehouseRiskRepository;
	@Autowired private StorageMethodRepository storageMethodRepository;
	@Autowired private EquipmentRiskRepository equipmentRiskRepository;
	@Autowired private EnvProtPersonRepository envProtPersonRepository;
	
	@Override
	public Collection<String> getItemsByCategory(Company cat) {
		  Collection<String> items = new ArrayList<String>();
          return items;
	}

	@Override
	@Transactional(readOnly=false)
	public void registCompany(Company company) {
		companyRepository.save(company);
		
	}

	@Override
	@Transactional(readOnly=false)
	public void loadCompany(String username, String realName, String companyName, String address, String lng,
			String lat) {
		Users u = new Users();
		u.setMobile(username);
		u.setUsername(username);
		u.setPassword(username);
		u.setEnabled(false);
		u.setRealName(realName);
		u.setEpb(epbRepository.findOne(1l));
		userService.register(u, true);
		
		
		Company company = new Company();
		company.setCompanyName(companyName);
		company.setAddress(address);
		company.setCreationDate(new Date());
		company.setLat(lat);
		company.setLng(lng);
		company.setUsersByCreator(u);
		company.setStatus(AuditSatusEnum.NotAudit.getIndex());
		company.setAdministrativeDic(administrativeDicRepository.findOne(1l));
		company.setAdministrativeDivision(administrativeDivisionRepository.findOne(1l));
		company.setConcernDegreeDic(concernDegreeDicRepository.findOne(1l));
		company.setIndustrySectorDic(industrySectorDicRepository.findOne(1l));
		company.setOperationMaintanceCompany(operationMaintanceCompanyRepository.findOne(2l));
	
		companyRepository.save(company);
		
		
	}

	@Override
	public List<Company> getCompaniesByStatus(AuditSatusEnum auditSatusEnum) {
	
		return companyRepository.getByStatus(auditSatusEnum.getIndex());
	}

	
	
	@Override
	@Transactional(readOnly=false)
	public void loadCompanies(InputStream inputStream) throws IOException {
		CsvReader reader = new CsvReader(inputStream,',', Charset.forName("UTF-8"));
		while(reader.readRecord())
		{
			loadCompany(reader.get(5).trim(), reader.get(4).trim(), reader.get(0).trim(), reader.get(1).trim(), reader.get(2).trim(),
					reader.get(3).trim());
		}
		
	}


	@Override
	@Transactional(readOnly=false)
	public void addRiskInfoForTestingData(ConfigurableApplicationContext ctx) throws IOException {
		Company c = companyRepository.findOne(1l);
	
		/*
		/*begin风险源基础信息*/
		RiskBasicInfo r = new RiskBasicInfo();
        r.setCreationDate(new Date());
        c.setRegistrationCode("2040334-6");
        c.setLicenseCode("430019330007821");
        c.setCorporation("张文泉");
        c.setCorporationFax("0243-46129001");
        r.setArea(1028.8f);
        
        r.setIndustrialPark(industrialParkRepository.findOne(2l));
        r.setProductStatus(productStatusRepository.findOne(1l));
        r.setEmePerson("李军");
        r.setEmeMobile("13934692234");
        r.setStatus(AuditSatusEnum.Yes.getIndex());
        r.setLvl("较大环境风险源");
       
        r.setCompany(c);
        r.setLat(c.getLat());
        r.setLng(c.getLng());
        r.setRiskName(c.getCompanyName());
        companyRepository.save(c);
        riskBasicInfoRepository.save(r);

   
		
		/*添加单位明面图*/
		HousePlan housePlan =  new HousePlan("house1.png");
		housePlanRepository.save(housePlan);
		c.setHousePlan(housePlan);
		companyRepository.save(c);
		
		
		/*添加产品，原料*/
		Resource cRes = ctx.getResource("classpath:data/chemicalMaterials.csv");
		CsvReader creader = new CsvReader(cRes.getInputStream(),',', Charset.forName("UTF-8"));
		while(creader.readRecord())
		{
			ChemicalMaterial cm = new ChemicalMaterial();
			cm.setCompany(c);
			cm.setMaterialName(creader.get(1).trim());
			cm.setChemicalName(creader.get(2).trim());
			cm.setCas(creader.get(3).trim());
			cm.setAnnualOutput(Float.parseFloat(creader.get(4).trim()));
			cm.setQuantity(Float.parseFloat(creader.get(5).trim()));
			cm.setIsHazardous(true);
			cm.setPhysicalState(physicalStateRepository.findOne(2l));
			cm.setMaterialCategory(materialCategoryRepository.findOne(6l));
			cm.setEquipmentState(equipmentStateRepository.findOne(2l));
			cm.setMaterialType(materialTypeRepository.findOne(1l));
		    cm.setStorageMode(storageModeRepository.findOne(2l));
		    cm.setProductionMode(productionModeRepository.findOne(1l));
		    cm.setPurpose(creader.get(6).trim());
			chemicalMaterialRepository.save(cm);

		}
		
		
		
		/**生产工艺***/
		
		Workmanship w = new Workmanship("石墨生产工艺");
		w.setCompany(c);
		w.setFileName("workmanship1.png");
		w.setDescription("采用最先进的德国生产线，将环境污染降至最低。");
		workmanshipRepository.save(w);
		
		
	   /*风险防控措施*/
		for(int i=0;i<2;i++)
		{
			RiskAversion ra = new RiskAversion();
			ra.setCompany(c);
			ra.setAuditor("李冰");
			ra.setAuditOrg("南通市环保局");
			if(i==0)
				ra.setRemark("防洪水措施");
			else
				ra.setRemark("防震措施");
			ra.setRiskAversionType(riskAversionTypeRepository.findOne(3l));
			ra.setFileName("emePlan1.pdf");
			riskAversionRepository.save(ra);
			for(RiskAversionOptionsDic dic: riskAversionOptionsDicRepository.findAll())
			{
			
				RiskAversionOptions o = new RiskAversionOptions();
				RiskAversionOptionsId id = new RiskAversionOptionsId(r.getId(), dic.getId());
				o.setId(id);
				o.setRiskAversion(ra);
				o.setRiskAversionOptionsDic(dic);
				o.setChecked(true);
				riskAversionOptionsRepository.save(o);
			}
			
		}
	
		
		/*水气环境字典*/
		Resource aRes = ctx.getResource("classpath:data/airEnv.csv");
		CsvReader reader = new CsvReader(aRes.getInputStream(),',', Charset.forName("UTF-8"));
		while(reader.readRecord())
		{
			AirEnv a = new AirEnv();
			a.setAirEnvName(reader.get(0).trim());
			a.setLng(reader.get(1).trim());
			a.setLat(reader.get(2).trim());
			a.setEmePerson(reader.get(3).trim());
			a.setEmeMobile(reader.get(4).trim());
			a.setAirEnvType(airEnvTypeRepository.findOne(2l));
			a.setEnvFunc(envFuncRepository.findOne(2l));
			airEnvRepository.save(a);
		}
		
		/*水环境字典*/
		Resource wRes = ctx.getResource("classpath:data/waterEnv.csv");
		CsvReader wreader = new CsvReader(wRes.getInputStream(),',', Charset.forName("UTF-8"));
		while(wreader.readRecord())
		{
			WaterEnv a = new WaterEnv();
			a.setWaterEnvName(wreader.get(0).trim());
			a.setLng(wreader.get(1).trim());
			a.setLat(wreader.get(2).trim());
			a.setEmePerson(wreader.get(3).trim());
			a.setEmeMobile(wreader.get(4).trim());
			a.setWaterEnvType(waterEnvTypeRepository.findOne(2l));
			a.setEnvFunc(envFuncRepository.findOne(2l));
			waterEnvRepository.save(a);
		}
		
		
		/*水环境*/
		CompanyAirEnv companyAirEnv = new CompanyAirEnv();
		CompanyAirEnvId aId = new CompanyAirEnvId(1l, c.getId());
		companyAirEnv.setId(aId);
		companyAirEnv.setDistance(5l);
		companyAirEnv.setLocationDic(locationDicRepository.findOne(3l));
		companyAirEnvRepository.save(companyAirEnv);
		
		/*气环境*/
		CompanyWaterEnv companyWaterEnv = new CompanyWaterEnv();
		CompanyWaterEnvId wId = new CompanyWaterEnvId(1l, c.getId());
		companyWaterEnv.setId(wId);
		companyWaterEnv.setDistance(12l);
		companyWaterEnv.setLocation("上游");
		companyWaterEnvRepository.save(companyWaterEnv);
		
		
		/*应急预案*/
		EmergencyResponsePlan er = new EmergencyResponsePlan();
		er.setCompany(c);
		er.setCreationDate(new Date());
		er.setEmergencyReponsePlanType(emergencyResponsePlanTypeRepository.findOne(1l));
		er.setEpb(epbRepository.findOne(1l));
		er.setFileName("emePlan1.pdf");
		er.setTitle("环境风险事故应急预案");
		er.setRegistCode("NTYJ－00879");
		emergencyResponsePlanRepository.save(er);
		
		
		/*仓库风险*/
		WarehouseRisk wr= new WarehouseRisk();
		wr.setCompany(c);
		wr.setArea(78.9f);
		wr.setLastModified(new Date());
		wr.setLng(c.getLng());
		wr.setLat(c.getLat());
		wr.setMaterialName("棉被");
		wr.setMaterialVolume(100f);
		wr.setStorageMethod(storageMethodRepository.findOne(1l));
		wr.setVolume(1000f);
		wr.setWarehouseName("北一仓");
		warehouseRiskRepository.save(wr);
		
		
		/*设备风险*/
		
		EquipmentRisk erisk = new EquipmentRisk();
		erisk.setCompany(c);
		erisk.setBrand("欧姆龙");
		erisk.setEquipmentModel("X2");
		erisk.setEquipmentName("抽水泵");
		erisk.setInstallAddress("工厂排污口");
		erisk.setInstallDate(new Date());
		erisk.setLat(c.getLat());
		erisk.setLng(c.getLng());
		erisk.setLifetime("10年");
		equipmentRiskRepository.save(erisk);
		
		
		/*环保人员*/
		Resource pRes = ctx.getResource("classpath:data/envProtPerson.csv");
		CsvReader preader = new CsvReader(pRes.getInputStream(),',', Charset.forName("UTF-8"));
		while(preader.readRecord())
		{
			
			EnvProtPerson p = new EnvProtPerson();
			p.setCompany(c);
			p.setRealName(preader.get(1).trim());
			p.setGender(preader.get(2).trim());
			p.setTitle(preader.get(3).trim());
			p.setBirth(preader.get(4).trim());
			p.setMobile(preader.get(5).trim());
			p.setTel(preader.get(6).trim());
			p.setMajor(preader.get(7).trim());
			p.setPosition(preader.get(8).trim());
			
			envProtPersonRepository.save(p);
		}
		
	}



}
