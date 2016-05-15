package com.huihuan.eme.web.rest;


import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.huihuan.eme.domain.db.DataCollectionDevice;
import com.huihuan.eme.domain.db.DetectFactor;
import com.huihuan.eme.domain.db.DetectFactorCurrentValues;
import com.huihuan.eme.domain.db.DetectFactorValues;
import com.huihuan.eme.domain.page.DataPacket;
import com.huihuan.eme.domain.page.FactorRealTimeValue;
import com.huihuan.eme.domain.page.FactorStatisticsValue;
import com.huihuan.eme.repository.DataCollectionDeviceRepository;
import com.huihuan.eme.repository.DetectFactorCurrentValuesRepository;
import com.huihuan.eme.repository.DetectFactorRepository;
import com.huihuan.eme.repository.DetectFactorValuesRepository;
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
	
	@Autowired private DetectFactorRepository detectFactorRepository;
	@Autowired private DetectFactorValuesRepository detectFactorValuesRepository;
	@Autowired private DetectFactorCurrentValuesRepository detectFactorCurrentValuesRepository;
	@Autowired private DataCollectionDeviceRepository dataCollectionDeviceRepository;

	@Transactional(readOnly = false)
	@RequestMapping(value="/factorvalues/uploadFactorValue", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String uploadFactorValue(@RequestBody DataPacket dataPacket)
	{
	    String msg ="OK";
		for(FactorStatisticsValue fs: dataPacket.getFactorStatisticsValues())
		{
			String cn = dataPacket.getCn();
			fs.setIntervalType(Integer.parseInt(cn));
			fs.setMn(dataPacket.getMn());
			uploadFactorStaticsValue(fs);
		}
		
		for(FactorRealTimeValue rs: dataPacket.getFactorRealTimeValues())
		{
		
			rs.setMn(dataPacket.getMn());
			uploadFactorRealTimeValue(rs);
		}
		
		
	     return msg;
	}
	

	
	private String uploadFactorStaticsValue(FactorStatisticsValue factorStatisticsValue)
	{
		  String msg ="OK";
		  DetectFactor detectFactor = detectFactorRepository.getByDetectContentIdAndFactorCode(2l, factorStatisticsValue.getCode());
			if(detectFactor==null)
			{
				msg = "数据库中没有此类检测因子！ 检测因子代码: " +factorStatisticsValue.getCode();
				logger.error(msg);
				return msg;
			}
			
			DataCollectionDevice dataCollectionDevice =dataCollectionDeviceRepository.findOne(factorStatisticsValue.getMn());
			if(dataCollectionDevice==null)
			{
				msg = "数据库中没有此数采仪， MN号： " + factorStatisticsValue.getMn();
				logger.error(msg);
				return msg;
			}

			DetectFactorValues v = new DetectFactorValues();
			v.setAvgVal(Float.parseFloat(factorStatisticsValue.getAvg()));
			v.setCouVal(Float.parseFloat(factorStatisticsValue.getCou()));
			v.setDataCollectionDevice(dataCollectionDevice);
			v.setDetectTime(factorStatisticsValue.getDetectTime());
			v.setLowVal(Float.parseFloat(factorStatisticsValue.getLowValue()));
			v.setMaxVal(Float.parseFloat(factorStatisticsValue.getMax()));
			v.setMinVal(Float.parseFloat(factorStatisticsValue.getMin()));
			v.setType(Long.valueOf(factorStatisticsValue.getIntervalType()));
			v.setUploadTime(new Date());
			v.setUpVal(Float.parseFloat(factorStatisticsValue.getUpValue()));
			v.setZsAvgVal(Float.parseFloat(factorStatisticsValue.getZsAvg()));
			v.setZsCouVal(Float.parseFloat(factorStatisticsValue.getZsCou()));
			v.setZsMaxVal(Float.parseFloat(factorStatisticsValue.getZsMax()));
			v.setZsMinVal(Float.parseFloat(factorStatisticsValue.getZsMin()));
			v.setDetectFactor(detectFactor);

			v = detectFactorValuesRepository.save(v);
			//msg ="MN:" + factorStatisticsValue.getMn() + ", factor: " +v.getDetectFactor().getFactorName() +", avg val: " + v.getAvgVal();
			logger.debug(msg);
			return msg;
	}
	
	
	
	private String uploadFactorRealTimeValue( FactorRealTimeValue factorRealTimeValue)
	{
		String msg ="OK";
		
	    DetectFactor detectFactor = detectFactorRepository.getByDetectContentIdAndFactorCode(2l, factorRealTimeValue.getCode());
		if(detectFactor==null)
		{
			msg = "数据库中没有此类检测因子！ 检测因子代码: " +factorRealTimeValue.getCode();
			logger.error(msg);
			return msg;
		}
		
		DataCollectionDevice dataCollectionDevice =dataCollectionDeviceRepository.findOne(factorRealTimeValue.getMn());
		if(dataCollectionDevice==null)
		{
			msg = "数据库中没有此数采仪， MN号： " + factorRealTimeValue.getMn();
			logger.error(msg);
			return msg;
		}

		DetectFactorCurrentValues v = new DetectFactorCurrentValues();

		v.setDataCollectionDevice(dataCollectionDevice);
	    v.setDetectFactor(detectFactor);
		v.setDetectTime(factorRealTimeValue.getDetectTime());
		v.setUploadTime(new Date());
		v.setVal(Float.parseFloat(factorRealTimeValue.getValue()));
		v.setOpt1(factorRealTimeValue.getDetail());
		v.setOpt2(factorRealTimeValue.getFlag());
		v.setOpt3(factorRealTimeValue.getSurplus());
		v.setOpt4(factorRealTimeValue.getToday());
		v.setOpt5(factorRealTimeValue.getTotal());
		
	
		v = detectFactorCurrentValuesRepository.save(v);
		//msg ="MN:" + factorRealTimeValue.getMn() + ", factor: " +v.getDetectFactor().getFactorName();
		logger.debug(msg);
		return msg;
	}
	
	
	

}
