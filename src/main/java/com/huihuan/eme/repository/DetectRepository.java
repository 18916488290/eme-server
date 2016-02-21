package com.huihuan.eme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huihuan.eme.domain.db.Detect;
import com.huihuan.eme.domain.db.DetectCategory;
import com.huihuan.eme.domain.db.DetectHistory;
import com.huihuan.eme.domain.db.DetectId;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:04:09
 *
 */
public interface DetectRepository  extends JpaRepository<Detect, DetectId> {
	

}
