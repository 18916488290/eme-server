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
import com.huihuan.eme.domain.db.PullantSource;
import com.huihuan.eme.domain.db.RiskBasicInfo;
import com.huihuan.eme.domain.db.WaterSource;
import com.huihuan.eme.domain.page.AuditSatusEnum;
import com.huihuan.eme.domain.page.DetectStationMarker;
import com.huihuan.eme.domain.page.FactorValue;
import com.huihuan.eme.domain.page.ImageOffset;
import com.huihuan.eme.domain.page.Point;
import com.huihuan.eme.domain.page.PullantSourceInfo;
import com.huihuan.eme.domain.page.PullantSourceMarker;
import com.huihuan.eme.domain.page.RiskSourceInfo;
import com.huihuan.eme.domain.page.RiskSourceMarker;
import com.huihuan.eme.domain.page.WaterSourceMarker;
import com.huihuan.eme.repository.DetectStationRepository;
import com.huihuan.eme.repository.PullantSourceRepository;
import com.huihuan.eme.repository.RiskBasicInfoRepository;
import com.huihuan.eme.repository.WaterSourceRepository;
import com.huihuan.eme.service.CompanyService;
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
	@Autowired private CompanyService companyService;
	@Autowired private PullantSourceRepository pullantSourceRepository;
	@Autowired private WaterSourceRepository  waterSourceRepository;
	
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
	
			riskMarker.setPoint(new Point(Double.parseDouble(riskInfo.getLng()),Double.parseDouble(riskInfo.getLat())));
			RiskSourceInfo info = new RiskSourceInfo();
			info.setId(riskInfo.getId());
			info.setCompanyId(riskInfo.getCompany().getId());
			info.setCompanyName(riskInfo.getCompany().getCompanyName());
			info.setDivsion(riskInfo.getCompany().getAdministrativeDivision().getDivision());
			info.setEmePersion(riskInfo.getEmePerson());
			info.setEmeTel(riskInfo.getEmeMobile());
			info.setLvl(riskInfo.getLvl());
			info.setRiskAversion("有");
			
			riskMarker.setRiskSourceInfo(info);
			riskMarkers.add(riskMarker);
		}
	
		return riskMarkers;
	}
	
	
	@Transactional(readOnly = true)
	@RequestMapping(value="/getPullantSourcesMarkers", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<PullantSourceMarker> getPullantSourcesMarkers()
	{
		List<PullantSourceMarker> pullantMarkers = new ArrayList<PullantSourceMarker>();
		
		List<PullantSource> pullantSources = pullantSourceRepository.findAll();
		for(PullantSource ps:pullantSources)
		{
		
			PullantSourceMarker marker =new PullantSourceMarker();
			marker.setTitle("污染源");
			marker.setContent("污染源");
			marker.setImageOffset(new ImageOffset());
	
			marker.setPoint(new Point(Double.parseDouble(ps.getLng()),Double.parseDouble(ps.getLat())));
			PullantSourceInfo info = new PullantSourceInfo();
			info.setId(ps.getId());
			info.setCompanyId(ps.getCompany().getId());
			info.setCompanyName(ps.getCompany().getCompanyName());
			info.setDivsion(ps.getCompany().getAdministrativeDivision().getDivision());
			info.setType("COD");
			marker.setPullantSourceInfo(info);
			pullantMarkers.add(marker);
		}
	
		return pullantMarkers;
	}
	
	

	@Transactional(readOnly = true)
	@RequestMapping(value="/getWaterSourcesMarkers", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<WaterSourceMarker> getWaterSourcesMarkers()
	{
		List<WaterSourceMarker> waterMarkers = new ArrayList<WaterSourceMarker>();
		
		List<WaterSource> waterSources = waterSourceRepository.findAll();
		for(WaterSource ws:waterSources)
		{
		
			WaterSourceMarker marker =new WaterSourceMarker();
			marker.setTitle("饮用水源地");
			marker.setContent("饮用水源地");
			marker.setImageOffset(new ImageOffset());
	
			marker.setPoint(new Point(Double.parseDouble(ws.getLng()),Double.parseDouble(ws.getLat())));
			marker.setId(ws.getId());
			marker.setWaterName(ws.getWaterName());
			marker.setCreationTime(ws.getCreationTime());
			waterMarkers.add(marker);
		}
	
		return waterMarkers;
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
	
	
	@Transactional(readOnly = true)
	@RequestMapping(value="/getCompanyMarkers", method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<RiskSourceMarker> getCompanyMarkers()
	{
		List<RiskSourceMarker> markers = new ArrayList<RiskSourceMarker>();
		
		List<Company> companies = companyService.getCompaniesByStatus(AuditSatusEnum.Yes);
		for(Company company:companies)
		{
		
			RiskSourceMarker riskMarker =new RiskSourceMarker();
			riskMarker.setTitle("在线监测源");
			riskMarker.setContent("在线监测源");
			riskMarker.setImageOffset(new ImageOffset());
			riskMarker.setPoint(new Point(Double.parseDouble(company.getLng()),Double.parseDouble(company.getLat())));
			RiskSourceInfo info = new RiskSourceInfo();
			info.setCompanyId(company.getId());
			info.setCompanyName(company.getCompanyName());
			info.setDivsion(company.getAdministrativeDivision().getDivision());
			
			riskMarker.setRiskSourceInfo(info);
			markers.add(riskMarker);
		}
	
		return markers;
	}
	
	
}
