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
public class AqiInfoController {
	
	@Autowired private DetectStationRepository detectStationRepository;
	
	private static final Log logger = LogFactory.getLog(AqiInfoController.class);

	@RequestMapping(value="/aqiInfo",method=RequestMethod.GET)
	public String populateAqiInfo(@RequestParam(required=true) long stationId, Map<String, Object> model) {
		model.put("station",detectStationRepository.findOne(stationId));
		logger.warn("监测站id：" +stationId);
		return "aqiInfo";
	}
	
	@RequestMapping(value="/aqiAnalysis",method=RequestMethod.GET)
	public String populateAqiAnalysis(@RequestParam(required=true) long stationId, Map<String, Object> model) {
		model.put("station",detectStationRepository.findOne(stationId));
		logger.warn("监测站id：" +stationId);
		return "aqiAnalysis";
	}

	
}
