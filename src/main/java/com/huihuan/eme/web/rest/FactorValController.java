package com.huihuan.eme.web.rest;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.DetectStation;
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.page.AirReport;
import com.huihuan.eme.domain.page.DetectStationMarker;
import com.huihuan.eme.domain.page.FactorStatisticsValue;
import com.huihuan.eme.domain.page.FactorValue;
import com.huihuan.eme.domain.page.ImageOffset;
import com.huihuan.eme.domain.page.Point;
import com.huihuan.eme.domain.page.RiskSourceInfo;
import com.huihuan.eme.domain.page.RiskSourceMarker;
import com.huihuan.eme.repository.DetectStationRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.service.DetectAirReportService;
import com.huihuan.eme.service.DetectService;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:58:43
 *
 */
@RestController
@RequestMapping("/api")
public class FactorValController {
	
	private static final Log logger = LogFactory.getLog(FactorValController.class);
	@Autowired private DetectService detectService;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private DetectStationRepository detectStationRepository;
	@Autowired private DetectAirReportService detectAirReportService;

	@Transactional(readOnly = false)
	@RequestMapping(value="/uploadFactorStaticsValue", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String uploadFactorStaticsValue(@RequestBody FactorStatisticsValue factorStatisticsValue)
	{
		logger.debug("mn: " + factorStatisticsValue.getMn() +", factor code: " + factorStatisticsValue.getCode() + ", MN: avg val: " +factorStatisticsValue.getAvg() );
		return "OK";
	}
	

	

	

}
