package com.huihuan.eme.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huihuan.eme.domain.db.AirEnv;
import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.DetectStation;
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.db.WaterEnv;
import com.huihuan.eme.domain.page.AirReport;
import com.huihuan.eme.domain.page.DetectStationMarker;
import com.huihuan.eme.domain.page.FactorValue;
import com.huihuan.eme.domain.page.ImageOffset;
import com.huihuan.eme.domain.page.Point;
import com.huihuan.eme.domain.page.RiskSourceInfo;
import com.huihuan.eme.domain.page.RiskSourceMarker;
import com.huihuan.eme.domain.page.WSWaterEnv;
import com.huihuan.eme.repository.AirEnvRepository;
import com.huihuan.eme.repository.DetectStationRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.WaterEnvRepository;
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
public class AirEnvRestController {
	
	private static final Log logger = LogFactory.getLog(AirEnvRestController.class);

	@Autowired private AirEnvRepository airEnvRepository;
	

	
	@Transactional(readOnly = true)
	@RequestMapping(value="/getAirEnv", method=RequestMethod.GET)
	public WSWaterEnv getAirEnv(@RequestParam("airEnvId") Long airEnvId)
	{
		
		AirEnv airEnv = airEnvRepository.findOne(airEnvId);
		WSWaterEnv we = new WSWaterEnv();
		we.setEmeMobile(airEnv.getEmeMobile());
		we.setEmePerson(airEnv.getEmePerson());
		we.setEnvFunc(airEnv.getEnvFunc().getEnvFunc());
		we.setEnvFuncId(airEnv.getEnvFunc().getId());
		we.setId(airEnv.getId());
		we.setLat(airEnv.getLat());
		we.setLng(airEnv.getLng());
		we.setWaterEnvName(airEnv.getAirEnvName());
		we.setWaterEnvType(airEnv.getAirEnvType().getAirEnvType());
		we.setWaterEnvTypeId(airEnv.getAirEnvType().getId());
		return we;
	}
	
	
	

}
