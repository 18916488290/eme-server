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

import com.huihuan.eme.domain.db.DetectFactor;
import com.huihuan.eme.domain.db.DetectStation;
import com.huihuan.eme.domain.db.GroupMembers;
import com.huihuan.eme.domain.db.Groups;
import com.huihuan.eme.domain.db.Users;
import com.huihuan.eme.domain.page.FactorValue;
import com.huihuan.eme.repository.DataCollectionDeviceRepository;
import com.huihuan.eme.repository.DetectAirRepository;
import com.huihuan.eme.repository.DetectCategoryRepository;
import com.huihuan.eme.repository.DetectContentDicRepository;
import com.huihuan.eme.repository.DetectFactorCurrentValuesRepository;
import com.huihuan.eme.repository.DetectFactorRepository;
import com.huihuan.eme.repository.DetectFactorValuesRepository;
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
	@Autowired private DetectFactorValuesRepository detectFactorValuesRepository; 
	@Autowired private DetectFactorCurrentValuesRepository detectFactorCurrentValuesRepository; 
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
		
	
		return "";
	//	return "检测时间： "+dh.getDetectTime() +", 检测站点： " + station.getDetectStationName() +", 检测因子: " +detectFactor.getFactorName() +", MN: " +factorValue.getMn() +", 检测值： "+ factorValue.getVal();
	}




}
