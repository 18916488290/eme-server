/**
 * 
 */
package com.huihuan.eme.web.page;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.service.CompanyService;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
/**环保局审核企业**/
@Controller
public class CompanyAuditController {
	
	@Autowired private CompanyService companyService;
	@Autowired private CompanyRepository companyRepository;
	
	private static final Log logger = LogFactory.getLog(CompanyAuditController.class);
	
	@RequestMapping("/companyList")
	public String populateCompanies(Map<String, Object> model) {
		
		model.put("notAuditCompanies", companyService.getCompaniesByStatus(AuditSatusEnum.NotAudit));
		
		return "companyList";
	}
	@RequestMapping("/auditCompany")
	public String populateCompany(@RequestParam(required=true) long companyId, Map<String, Object> model) {
		model.put("company",companyRepository.findOne(companyId));
		return "auditCompany";
	}
	
	
	
	
}
