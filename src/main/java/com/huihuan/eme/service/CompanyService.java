package com.huihuan.eme.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.huihuan.eme.domain.db.Company;
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
	 
	 public void loadTestCompany();
	 public List<Company> getCompaniesByStatus(AuditSatusEnum AuditSatusEnum);

}
