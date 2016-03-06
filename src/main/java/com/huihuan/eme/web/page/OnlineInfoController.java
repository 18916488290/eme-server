package com.huihuan.eme.web.page;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.repository.CompanyRepository;
import com.huihuan.eme.repository.DetectStationRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.service.CompanyService;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */

@Controller
public class OnlineInfoController {
	
	@Autowired private CompanyRepository companyRepository;
	
	private static final Log logger = LogFactory.getLog(OnlineInfoController.class);

	@RequestMapping(value="/onlineInfo",method=RequestMethod.GET)
	public String populateOnlineInfo(@RequestParam(required=true) long companyId, Map<String, Object> model) {
		model.put("company",companyRepository.findOne(companyId));
		return "onlineInfo";
	}

	@RequestMapping(value="/airInfo",method=RequestMethod.GET)
	public String populateAirInfo(@RequestParam(required=true) long companyId, Map<String, Object> model) {
		model.put("company",companyRepository.findOne(companyId));
		return "airInfo";
	}

	@RequestMapping(value="/metalInfo",method=RequestMethod.GET)
	public String populateMetalInfo(@RequestParam(required=true) long companyId, Map<String, Object> model) {
		model.put("company",companyRepository.findOne(companyId));
		return "metalInfo";
	}
	
}
