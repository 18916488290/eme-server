/**
 * 
 */
package com.huihuan.eme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huihuan.eme.domain.db.AqiInfo;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:04:09
 *
 */
public interface AqiInfoRepository  extends JpaRepository<AqiInfo, Long> {
	
	@Query("select a from AqiInfo a where a.ilow<=?1 and a.ihigh>=?1")
	public AqiInfo getAqiInfoByAqiValue(float aqi);
	

}
