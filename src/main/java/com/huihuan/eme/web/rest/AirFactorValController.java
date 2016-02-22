package com.huihuan.eme.web.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.huihuan.eme.domain.page.FactorValue;
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
	

	@Transactional(readOnly = false)
	@RequestMapping(value="/uploadFactorValue", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String uploadAirFactorValues(@RequestBody FactorValue factorValue)
	{
		logger.debug("stationId: " + factorValue.getStationId() +", factorId: " + factorValue.getFactorId() + ", MN: " + factorValue.getMn() +", value: " + factorValue.getVal() +", isDaily: " + factorValue.isDaily());
		return detectService.uploadFactorValues(factorValue);
	}
	
	@Transactional(readOnly = false)
	@RequestMapping(value="/calc")
	public String calcAir()
	{
		detectService.calcAir();
		return "Done";
	}
}
