package com.huihuan.eme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huihuan.eme.domain.db.DetectContentDic;
import com.huihuan.eme.domain.db.DetectStationContent;
import com.huihuan.eme.domain.db.DetectStationContentId;
import com.huihuan.eme.domain.db.EmergencyReponsePlanType;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:04:09
 *
 */
public interface DetectStationContentRepository  extends JpaRepository<DetectStationContent, DetectStationContentId> {
	

}
