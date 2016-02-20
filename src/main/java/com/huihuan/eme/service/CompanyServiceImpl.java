package com.huihuan.eme.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void loadTestCompany() {
		Users u = new Users();
		u.setMobile("18916488290");
		u.setUsername("18916488290");
		u.setPassword("18916488290");
		u.setEnabled(false);
		u.setRealName("任宏涛");
		u.setEpb(epbRepository.findOne(1l));
		userService.register(u, true);
		
		
		Company company = new Company();
		company.setCompanyName("大智慧有限责任公司");
		company.setAddress("华发路368");
		company.setCreationDate(new Date());
		company.setLat(3.0f);
		company.setLng(4.0f);
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

}
