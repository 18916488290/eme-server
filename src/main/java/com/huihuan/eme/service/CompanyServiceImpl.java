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
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.AdministrativeDicRepository;
import com.huihuan.eme.repository.AdministrativeDivisionRepository;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.ConcernDegreeDicRepository;
import com.huihuan.eme.repository.EpbRepository;
import com.huihuan.eme.repository.IndustrySectorDicRepository;
import com.huihuan.eme.repository.OperationMaintanceCompanyRepository;
import com.huihuan.eme.repository.UsersRepository;

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
	public void loadCompany(String username, String realName, String companyName, String address, float lng,
			float lat) {
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
			loadCompany(reader.get(5).trim(), reader.get(4).trim(), reader.get(0).trim(), reader.get(1).trim(), Float.parseFloat(reader.get(2).trim()),
					Float.parseFloat(reader.get(3).trim()));
		}
		
	}

	

}
