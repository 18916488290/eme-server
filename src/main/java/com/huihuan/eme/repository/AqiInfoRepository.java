/**
 * 
 */
package com.huihuan.eme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huihuan.eme.domain.db.AirEnv;
import com.huihuan.eme.domain.db.AirEnvType;
import com.huihuan.eme.domain.db.AqiInfo;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:04:09
 *
 */
public interface AqiInfoRepository  extends JpaRepository<AqiInfo, Long> {
	

}