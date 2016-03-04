package com.huihuan.eme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huihuan.eme.domain.db.DetectAirReport;
import com.huihuan.eme.domain.page.AirReport;
import com.huihuan.eme.repository.AqiInfoRepository;
import com.huihuan.eme.repository.DetectAirReportRepository;
import com.huihuan.eme.repository.DetectContentDicRepository;
import com.huihuan.eme.repository.DetectStationRepository;
/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("detectAirReportService")
@Transactional(readOnly=false)
public class DetectAirReportServiceImpl implements DetectAirReportService {
	
	@Autowired private DetectAirReportRepository detectAirReportRepository;
	@Autowired private DetectContentDicRepository detectContentDicRepository;
	@Autowired private DetectStationRepository detectStationRepository;
	@Autowired private AqiInfoRepository airInfoRepository;
	
	@Override
	public String uploadDetectAirReport(AirReport airReport) {
	
		float aqi = max(airReport.getCoAqi(),airReport.getNo2Aqi(),airReport.getO3Aqi(),airReport.getPm10Aqi(),airReport.getPm25Aqi(),airReport.getSo2Aqi());
		DetectAirReport report = new DetectAirReport();
		report.setAqi(aqi);
		report.setCoAqi(airReport.getCoAqi());
		report.setIsDaily(airReport.getIsDaily());
		report.setNo2Aqi(airReport.getNo2Aqi());
		report.setO3Aqi(airReport.getO3Aqi());
		report.setPm10Aqi(airReport.getPm10Aqi());
		report.setPm25Aqi(airReport.getPm25Aqi());
		report.setSo2Aqi(airReport.getSo2Aqi());
		report.setDetectContentDic(detectContentDicRepository.findOne(1l));
		report.setDetectStation(detectStationRepository.findOne(airReport.getStationId()));
		report.setReportTime(airReport.getReportTime());
	
		report.setAqiInfo(airInfoRepository.getAqiInfoByAqiValue(aqi));
		
		detectAirReportRepository.save(report);
		
		return "成功上传空气质量报告";
	}
	
	
	private float max(float ...v1)
	{
		float max=0f;
		for(float v:v1)
		{
			max = (v>max)?v:max;
		}
		return max;
	}

}
