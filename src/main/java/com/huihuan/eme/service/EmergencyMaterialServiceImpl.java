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
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.AdministrativeDicRepository;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;
import com.huihuan.eme.repository.EmergencyMaterialRepository;
import com.huihuan.eme.repository.EpbRepository;
import com.huihuan.eme.repository.EquipmentTypeRepository;
import com.huihuan.eme.repository.IndustrySectorDicRepository;
import com.huihuan.eme.repository.OperationMaintanceCompanyRepository;
import com.huihuan.eme.repository.UsersRepository;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("emergencyMaterialService")
@Transactional(readOnly=false)
public class EmergencyMaterialServiceImpl implements EmergencyMaterialService {
	
	@Autowired private CompanyRepository companyRepository;
	@Autowired private EquipmentTypeRepository equipmentTypeRepository; 
	@Autowired private EmergencyMaterialRepository emergencyMaterialRepository;
	  



	@Override
	public void loadEmergencyMaterials(InputStream inputStream) throws IOException {
		CsvReader reader = new CsvReader(inputStream,',', Charset.forName("UTF-8"));
		
		while(reader.readRecord())
		{
			Company c = companyRepository.getByCompanyName(reader.get(0).trim());
			if(c!=null)
			{
				EmergencyMaterial e = new EmergencyMaterial(reader.get(1).trim());
				e.setCompany(c);
				e.setCreationDate(new Date());
				e.setLat(c.getLat());
				e.setLng(c.getLng());
				e.setFunc(reader.get(4).trim());
				e.setAddress( reader.get(3).trim());
				e.setEquipmentType(equipmentTypeRepository.findOne(1l));
				e.setQuantity(reader.get(2).trim());
			    e.setUsersByCreator(c.getUsersByCreator());
			    e.setMobile(c.getUsersByCreator().getMobile());
			    e.setStatus(AuditSatusEnum.NotAudit.getIndex());
				emergencyMaterialRepository.save(e);
				
			}
		
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmergencyMaterial> getMaterialsByStatus(AuditSatusEnum auditSatusEnum) {
		 return emergencyMaterialRepository.getByStatus(auditSatusEnum.getIndex());
	}

	

}
