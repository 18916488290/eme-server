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
import org.springframework.web.bind.annotation.RestController;

import com.huihuan.eme.domain.db.Company;
import com.huihuan.eme.domain.db.DetectStation;
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.page.DetectStationMarker;
import com.huihuan.eme.domain.page.FactorValue;
import com.huihuan.eme.domain.page.ImageOffset;
import com.huihuan.eme.domain.page.Point;
import com.huihuan.eme.domain.page.RiskSourceInfo;
import com.huihuan.eme.domain.page.RiskSourceMarker;
import com.huihuan.eme.repository.DetectStationRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.service.DetectService;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:58:43
 *
 */
@RestController
@RequestMapping("/api")
public class MapRestController {
	
	private static final Log logger = LogFactory.getLog(MapRestController.class);
	@Autowired private DetectService detectService;
	@Autowired private RiskBasicInfoRepository riskBasicInfoRepository;
	@Autowired private DetectStationRepository detectStationRepository;

	
	//获得地图中心点
	@Transactional(readOnly = true)
	@RequestMapping(value="/getCenter", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Point getCenter()
	{
		
		Point center = new Point();
		center.setLng(120.94959);
		center.setLat(31.90506);
		//logger.warn(" 获取地图中心点坐标： 经度： " +center.getLng() +", 纬度： " + center.getLat());
		return center;
	}
	
	
	@Transactional(readOnly = true)
	@RequestMapping(value="/getRiskSourcesMarkers", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<RiskSourceMarker> getRiskSourcesMarkers()
	{
		List<RiskSourceMarker> riskMarkers = new ArrayList<RiskSourceMarker>();
		
		List<RiskBasicInfo> riskInfos = riskBasicInfoRepository.findAll();
		for(RiskBasicInfo riskInfo:riskInfos)
		{
		
			RiskSourceMarker riskMarker =new RiskSourceMarker();
			riskMarker.setTitle("风险源");
			riskMarker.setContent("风险源");
			riskMarker.setImageOffset(new ImageOffset());
			Company company = riskInfo.getCompanies().iterator().next();
			riskMarker.setPoint(new Point(Double.parseDouble(company.getLng()),Double.parseDouble(company.getLat())));
			RiskSourceInfo info = new RiskSourceInfo();
			info.setCompanyId(company.getId());
			info.setCompanyName(company.getCompanyName());
			info.setDivsion(company.getAdministrativeDivision().getDivision());
			info.setEmePersion(riskInfo.getEmePerson());
			info.setEmeTel(riskInfo.getEmeMobile());
			info.setLvl(company.getLvl());
			info.setRiskAversion("有");
			riskMarker.setRiskSourceInfo(info);
			riskMarkers.add(riskMarker);
		}
	
		return riskMarkers;
	}
	
	
	@Transactional(readOnly = true)
	@RequestMapping(value="/getDetectStationMarkers", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<DetectStationMarker> getDetectStationMarkers()
	{
		List<DetectStationMarker> markers = new ArrayList<DetectStationMarker>();
		
		List<DetectStation> stations = detectStationRepository.findAll();
		for(DetectStation station:stations)
		{
		
			DetectStationMarker marker =new DetectStationMarker();
			marker.setStationId(station.getId());
			marker.setTitle(station.getDetectStationName());
			marker.setContent(station.getDetectStationName());
			marker.setImageOffset(new ImageOffset());
			marker.setPoint(new Point(Double.parseDouble(station.getLng()),Double.parseDouble(station.getLat())));
			markers.add(marker);
		}
	
		return markers;
	}
	
}
