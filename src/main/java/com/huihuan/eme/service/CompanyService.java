package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.access.annotation.Secured;

import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.page.AuditSatusEnum;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:10:42
 *
 */
public interface CompanyService {
	
	 @Secured("ROLE_USER")
	 Collection<String> getItemsByCategory(Company cat);
	 
	 public void registCompany(Company company);
	 public void loadCompanies(InputStream inputStream) throws IOException;
	 public void loadCompany(String username,String realName, String companyName,String address,String lng,String lat);
	 public List<Company> getCompaniesByStatus(AuditSatusEnum AuditSatusEnum);
	 public List<Company> getCompaniesByRiskStatus(AuditSatusEnum AuditSatusEnum);
	 public void addRiskBasicInfo(Long companyId, RiskBasicInfo riskBasicInfo );
	 public void addRiskInfoForTestingData(ConfigurableApplicationContext ctx) throws IOException;


}
