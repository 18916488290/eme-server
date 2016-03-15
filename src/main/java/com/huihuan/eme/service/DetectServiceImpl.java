package com.huihuan.eme.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huihuan.eme.domain.db.DataCollectionDevice;
import com.huihuan.eme.domain.db.Detect;
import com.huihuan.eme.domain.db.DetectFactor;
import com.huihuan.eme.domain.db.DetectHistory;
import com.huihuan.eme.domain.db.DetectId;
import com.huihuan.eme.domain.db.DetectStation;
import com.huihuan.eme.domain.db.GroupMembers;
import com.huihuan.eme.domain.db.Groups;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.FactorValue;
import com.huihuan.eme.repository.DataCollectionDeviceRepository;
import com.huihuan.eme.repository.DetectAirRepository;
import com.huihuan.eme.repository.DetectCategoryRepository;
import com.huihuan.eme.repository.DetectContentDicRepository;
import com.huihuan.eme.repository.DetectFactorRepository;
import com.huihuan.eme.repository.DetectHistoryRepository;
import com.huihuan.eme.repository.DetectRepository;
import com.huihuan.eme.repository.DetectStationRepository;
import com.huihuan.eme.repository.GroupMembersRepository;
import com.huihuan.eme.repository.GroupsRepository;
import com.huihuan.eme.repository.UsersRepository;
import com.huihuan.eme.web.rest.AirFactorValController;
/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("detectService")
@Transactional(readOnly=false)
public class DetectServiceImpl implements DetectService {
	
	@Autowired private DetectStationRepository detectStationRepository; 
	@Autowired private DetectRepository detectRepository; 
	@Autowired private DetectHistoryRepository detectHistoryRepository; 
	@Autowired private DetectAirRepository detectAirRepository; 
	@Autowired private DataCollectionDeviceRepository dataCollectionDeviceRepository; 
	@Autowired private DetectFactorRepository detectFactorRepository; 
	@Autowired private DetectCategoryRepository detectCategoryRepository;
	
	@Autowired private DetectContentDicRepository detectContentDicRepository;
	
	private static final Log logger = LogFactory.getLog(DetectServiceImpl.class);

	@Override
	public String uploadFactorValues(FactorValue factorValue) {
		DetectStation station =detectStationRepository.findOne(factorValue.getStationId());
		DataCollectionDevice device = dataCollectionDeviceRepository.findOne(factorValue.getMn());
		DetectFactor detectFactor =detectFactorRepository.findOne(factorValue.getFactorId());
		
		DetectHistory dh = new DetectHistory();
		dh.setDetectTime(new Date());
		dh.setDetectStation(station);
		dh.setDataCollectionDevice(device);
		dh.setDetectFactor(detectFactor);
		dh.setVal(factorValue.getVal());
		detectHistoryRepository.save(dh);
		
		
		DetectId id = new DetectId();
		id.setIdDetectFactor(factorValue.getFactorId());
		id.setIdDetectStation(factorValue.getStationId());
		id.setMn(factorValue.getMn());
		Detect dbDetect = detectRepository.findOne(id);
		if(dbDetect==null)
		{
			dbDetect= new Detect();
			dbDetect.setId(id);
		}

		dbDetect.setDataCollectionDevice(device);
		dbDetect.setDetectTime(new Date());
		dbDetect.setVal(factorValue.getVal());
		detectRepository.save(dbDetect);
		
		return "检测时间： "+dh.getDetectTime() +", 检测站点： " + station.getDetectStationName() +", 检测因子: " +detectFactor.getFactorName() +", MN: " +factorValue.getMn() +", 检测值： "+ factorValue.getVal();
	}

	@Override
	public void calcAir() {
		
		List<DetectFactor> airFactors = detectFactorRepository.getByDetectCategory(detectCategoryRepository.findOne(4l));
		for(DetectFactor factor: airFactors)
		{
			logger.debug("factor: " + factor.getFactorName());
		}
	}



}
