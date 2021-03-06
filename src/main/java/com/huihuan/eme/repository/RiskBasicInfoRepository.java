package com.huihuan.eme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huihuan.eme.domain.db.RiskBasicInfo;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:04:09
 *
 */
public interface RiskBasicInfoRepository  extends JpaRepository<RiskBasicInfo, Long> {
	
	public List<RiskBasicInfo> getByStatus(long status);
	

}
