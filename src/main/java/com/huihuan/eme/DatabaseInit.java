package com.huihuan.eme;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huihuan.eme.domain.db.AdministrativeDic;
import com.huihuan.eme.domain.db.AirEnvType;
import com.huihuan.eme.domain.db.ConcernDegreeDic;
import com.huihuan.eme.domain.db.EnvFunc;
import com.huihuan.eme.domain.db.EquipmentState;
import com.huihuan.eme.domain.db.EquipmentType;
import com.huihuan.eme.domain.db.IndustrySectorDic;
import com.huihuan.eme.domain.db.LocationDic;
import com.huihuan.eme.domain.db.MaterialCategory;
import com.huihuan.eme.domain.db.MaterialType;
import com.huihuan.eme.domain.db.PhysicalState;
import com.huihuan.eme.domain.db.ProductStatus;
import com.huihuan.eme.domain.db.ProductionMode;
import com.huihuan.eme.domain.db.StorageMethod;
import com.huihuan.eme.domain.db.WaterEnvType;
import com.huihuan.eme.repository.AdministrativeDicRepository;
import com.huihuan.eme.repository.AirEnvTypeRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;
import com.huihuan.eme.repository.EnvFuncRepository;
import com.huihuan.eme.repository.EquipmentStateRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.GroupsRepository;
import com.huihuan.eme.repository.IndustrySectorDicRepository;
import com.huihuan.eme.repository.LocationDicRepository;
import com.huihuan.eme.repository.MaterialCategoryRepository;
import com.huihuan.eme.repository.MaterialTypeRepository;
import com.huihuan.eme.repository.PhysicalStateRepository;
import com.huihuan.eme.repository.ProductStatusRepository;
import com.huihuan.eme.repository.ProductionModeRepository;
import com.huihuan.eme.repository.StorageMethodRepository;
import com.huihuan.eme.repository.WaterEnvTypeRepository;
import com.huihuan.eme.service.AdministrativeDivisionServiceImpl;
import com.huihuan.eme.service.GroupsService;
import com.huihuan.eme.service.UserService;

@Service
@Transactional
public class DatabaseInit {
	private static final Log logger = LogFactory.getLog(DatabaseInit.class);
	@Autowired
	private GroupsService groupsService;
	@Autowired
	private UserService userService;
	@Autowired
	private GroupsRepository groupsRepository;

	@Autowired
	private AdministrativeDicRepository administrativeDicRepository;
	private String[] administratives = new String[] { "中央", "省", "市", "地区、县", "街道、乡镇", "居民村委会" };

	@Autowired
	private AdministrativeDivisionServiceImpl administrativeDivisionServiceImpl;

	@Autowired
	private AirEnvTypeRepository airEnvTypeRepository;
	private String[] airEnvTypes = new String[] { "自然保护区", "风景名胜区", "森林公园", "世界遗产地", "国家重点文物保护单位", "历史文化保护地", "农田种植",
			"珍稀动物栖息地", "特殊生态系统", "居民点", "自然村", "学校", "机关", "医院", "城镇", "县城", "居民聚集区", "其他" };

	@Autowired
	private ConcernDegreeDicRepository concernDegreeDicRepository;
	private String[] concernDegrees = new String[] { "国控", "省控", "县控" };
	
	@Autowired
	private IndustrySectorDicRepository industrySectorDicRepository;
	private String[] industrySectors = new String[] { "污水处理厂", "化工", "印染" , "造纸", "钢铁", "电力", "其它"};

	@Autowired
	private ProductStatusRepository productStatusRepository;
	private String[] productStatusList = new String[] { "生产", "停产"};
	
	@Autowired
	private PhysicalStateRepository physicalStateRepository;
	private String[] physicalStates = new String[] { "气态", "固态", "液态"};
	
	@Autowired
	private MaterialCategoryRepository materialCategoryRepository;
	private String[] materialCategories = new String[] { "爆炸品", "压缩气体和液化气体", "易燃液体", "易燃固体自燃物品和遇湿易燃物品", "氧化剂和有机过氧化物", "毒害品和感染性物品", "放射性物品", "腐蚀品"};
	
	
	@Autowired
	private StorageMethodRepository storageMethodRepository;
	private String[] storageMethods = new String[] { "隔离存储", "隔开存储", "分离存储", "露天存储"};
	
	
	@Autowired
	private EquipmentStateRepository equipmentStateRepository;
	private String[] equipmentStates = new String[] { "密闭式", "半密闭式", "敞开式"};
	
	
	
	@Autowired
	private ProductionModeRepository productionModeRepository;
	private String[] productionModes = new String[] { "连续性", "间歇性"};
	
	@Autowired
	private MaterialTypeRepository materialTypeRepository;
	private String[] materialTypes = new String[] { "主产品", "副产品", "原料"};
	
	@Autowired
	private WaterEnvTypeRepository waterEnvTypeRepository; 
	private String[] waterEnvTypes = new String[] { "饮用水源保护区", "自来水厂取水口", "水厂养殖区", "鱼虾产卵场", "天然渔场", "重要湿地", "基本农田保护区", "珍稀动植物栖息地", "特殊生态系统", "其它"};

	@Autowired
	private EnvFuncRepository envFuncRepository; 
	private String[] envFuncs = new String[] { "I类", "II类", "III类", "IV类", "V类"};


	@Autowired
	private LocationDicRepository locationDicRepository; 
	private String[] locationDics = new String[] { "北", "东北偏北", "东北", "东北偏北", "东", "东南偏东", "东南", "东南偏南", "南", "西南偏南", "西南", "西南偏西", "西", "西北偏西", "西北", "西北偏北"};
	

	@Autowired
	private EquipmentTypeRepository equipmentTypeRepository; 
	private String[] equipmentTypes = new String[] { "人员防护类", "现场取证类", "通信照明类", "监测器材类", "现场指挥类", "辅助器材类", "其它"};
	
	
	public void init(ConfigurableApplicationContext ctx) throws IOException
	{
		if(!groupsRepository.findAll().isEmpty())
		 	return;
		  groupsService.loadDefaultGroups();
		  userService.loadDefaultUsers();
		  loadAdministratives();
		  loadAdministrativeDivisions(ctx);
		  loadAirEnvTypes();
		  loadConcernDegrees();
		  loadIndustrySectors();
		  loadProductStatus();
		  loadPhysicalStatus();
		  loadMaterialCategories();
		  loadStorageMethods();
		  loadEquipmentStates();
		  loadProductionModes();
		  loadMaterialTypes();
		  loadWaterEnvTypes();
		  loadEnvFuncsTypes();
		  loadLocationDics();
		  loadEquipmentTypes();
	}

	private void loadAdministratives() {
		for (String administrative : administratives) {
			AdministrativeDic ad = new AdministrativeDic(administrative);
			administrativeDicRepository.save(ad);
		}
	}

	private void loadAdministrativeDivisions(ConfigurableApplicationContext ctx) throws IOException {
		Resource res = ctx.getResource("classpath:data/administrativeDivision.csv");
		administrativeDivisionServiceImpl.loadAdministrativeDivisionsFromCSV(res.getInputStream());
	}

	private void loadAirEnvTypes() {
		for (String airEnvType : airEnvTypes) {
			AirEnvType envType = new AirEnvType(airEnvType);
			airEnvTypeRepository.save(envType);
			logger.debug("导入气环境类型： " + envType.getAirEnvType());
		}
	}

	private void loadConcernDegrees() {
		for (String concernDegree : concernDegrees) {
			concernDegreeDicRepository.save(new ConcernDegreeDic(concernDegree));
		}
	}
	
	private void loadIndustrySectors() {
		for (String sector : industrySectors) {
			IndustrySectorDic is = new IndustrySectorDic(sector);
			industrySectorDicRepository.save(is);
		}
	}
	
	private void loadProductStatus() {
		for (String ps : productStatusList) {
			ProductStatus p = new ProductStatus();
			p.setProductStatus(ps);
			productStatusRepository.save(p);
		}
	}
	private void loadPhysicalStatus() {
		for (String ps : physicalStates) {
			PhysicalState p = new PhysicalState();
			p.setPhysicalState(ps);
			physicalStateRepository.save(p);
		}
	}
	private void loadMaterialCategories() {
		for (String mc : materialCategories) {
			MaterialCategory m = new MaterialCategory(mc);
			materialCategoryRepository.save(m);
		}
	}
	private void loadStorageMethods() {
		for (String s : storageMethods) {
			StorageMethod sm = new StorageMethod();
			sm.setStorageMethod(s);
			storageMethodRepository.save(sm);
		}
	}
	private void loadEquipmentStates() {
		for (String s :equipmentStates) {
			EquipmentState e= new EquipmentState();
			e.setEquipmentState(s);
			equipmentStateRepository.save(e);
		}
	}
	private void loadProductionModes() {
		for (String s :productionModes) {
			ProductionMode p= new ProductionMode(s);
			productionModeRepository.save(p);
		}
	}
	private void loadMaterialTypes() {
		for (String s :materialTypes) {
			MaterialType m= new MaterialType(s);
			materialTypeRepository.save(m);
		}
	}
	private void loadWaterEnvTypes() {
		for (String s :waterEnvTypes) {
			WaterEnvType w= new WaterEnvType();
			w.setWaterEnvType(s);
			waterEnvTypeRepository.save(w);
		}
	}
	private void loadEnvFuncsTypes() {
		for (String s :envFuncs) {
			EnvFunc e= new EnvFunc();
			e.setEnvFunc(s);
			envFuncRepository.save(e);
		}
	}
	private void loadLocationDics() {
		for (String s :locationDics) {
			LocationDic l = new LocationDic(s);
			locationDicRepository.save(l);
		}
	}
	
	private void loadEquipmentTypes() {
		for (String s :equipmentTypes) {
			EquipmentType e = new EquipmentType();
			e.setEquipmentType(s);
			equipmentTypeRepository.save(e);
		}
	}
}
