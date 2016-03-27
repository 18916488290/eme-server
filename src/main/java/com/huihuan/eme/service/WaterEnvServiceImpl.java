package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvreader.CsvReader;
import com.huihuan.eme.domain.db.AdministrativeDivision;
import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.EmergencyMaterial;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.db.WaterEnv;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.AdministrativeDicRepository;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;
import com.huihuan.eme.repository.EmergencyMaterialRepository;
import com.huihuan.eme.repository.EnvFuncRepository;
import com.huihuan.eme.repository.EpbRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.IndustrySectorDicRepository;
import com.huihuan.eme.repository.OperationMaintanceCompanyRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.repository.WaterEnvRepository;
import com.huihuan.eme.repository.WaterEnvTypeRepository;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("waterEnvService")
@Transactional(readOnly=false)
public class WaterEnvServiceImpl implements WaterEnvService {
	
	@Autowired private WaterEnvRepository waterEnvRepository;
	@Autowired private WaterEnvTypeRepository waterEnvTypeRepository; 
	@Autowired private EnvFuncRepository envFuncRepository;
	  

	@Override
	public void loadWaterEnvFromCsv(InputStream inputStream) throws IOException {
        CsvReader reader = new CsvReader(inputStream,',', Charset.forName("UTF-8"));
		
		while(reader.readRecord())
		{
			WaterEnv w = new WaterEnv();
			w.setWaterEnvName(reader.get(0).trim());
			w.setLng(reader.get(1).trim());
			w.setLat(reader.get(2).trim());
			w.setEmePerson(reader.get(3).trim());
			w.setEmeMobile(reader.get(4).trim());
			w.setWaterEnvType(waterEnvTypeRepository.findOne(Long.parseLong(reader.get(5).trim())));
			w.setEnvFunc(envFuncRepository.findOne(Long.parseLong(reader.get(6).trim())));
			
			waterEnvRepository.save(w);
		}
		
	}

	

}
