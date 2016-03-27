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
import com.huihuan.eme.domain.db.PullantSource;
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
import com.huihuan.eme.repository.PullantSourceRepository;
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
@Service("pullantSourceService")
@Transactional(readOnly=true)
public class PullantSourceServiceImpl implements PullantSourceService {
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private PullantSourceRepository pullantSourceRepository;

	@Override
	@Transactional(readOnly=false)
	public void loadPullantSources(InputStream inputStream) throws IOException {
		CsvReader reader = new CsvReader(inputStream,',', Charset.forName("UTF-8"));
		while(reader.readRecord())
		{
			PullantSource ps = new PullantSource();
			ps.setCreationTime(new Date());
			ps.setCompany(companyRepository.getByCompanyName(reader.get(0).trim()));
			ps.setPullantName(reader.get(1).trim());
			ps.setLng(reader.get(2).trim());
			ps.setLat(reader.get(3).trim());
			pullantSourceRepository.save(ps);
		}
		
	}


	



}
