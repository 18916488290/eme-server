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
public class AirFactorValController {
	
	private static final Log logger = LogFactory.getLog(AirFactorValController.class);
	@Autowired private DetectService detectService;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private DetectStationRepository detectStationRepository;
	@Autowired private DetectAirReportService detectAirReportService;

	@Transactional(readOnly = false)
	@RequestMapping(value="/uploadFactorValue", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String uploadAirFactorValues(@RequestBody FactorValue factorValue)
	{
		logger.debug("stationId: " + factorValue.getStationId() +", factorId: " + factorValue.getFactorId() + ", MN: " + factorValue.getMn() +", value: " + factorValue.getVal() +", isDaily: " + factorValue.isDaily());
		return detectService.uploadFactorValues(factorValue);
	}
	
	@Transactional(readOnly = false)
	@RequestMapping(value="/uploadAirReport", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String uploadAirFactorValues(@RequestBody AirReport airReport)
	{
		return detectAirReportService.uploadDetectAirReport(airReport);
		//return detectService.uploadFactorValues(factorValue);
	}
	
	@Transactional(readOnly = false)
	@RequestMapping(value="/calc")
	public String calcAir()
	{
		detectService.calcAir();
		return "Done";
	}
	
	
	@RequestMapping(value="/lastTenDaysCategories")
	public String lastTenDaysCategories()
	{
        String s = "";
        
        Date d = new Date();
        for(int i=9; i>=0;i--)
        {
        	Date nd =new Date(d.getTime()-1000*60*60*24*i);
        	if(i==0)
        	    s = s+DateFormat.getDateInstance(DateFormat.MEDIUM).format(nd);
        	else
        	{
        		s = s+DateFormat.getDateInstance(DateFormat.MEDIUM).format(nd)+",";
        	}
        }
       
        return s;
	}
	

}
