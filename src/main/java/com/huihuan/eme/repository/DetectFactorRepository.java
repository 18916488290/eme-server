package com.huihuan.eme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huihuan.eme.domain.db.DetectCategory;
import com.huihuan.eme.domain.db.DetectFactor;



/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:04:09
 *
 */
public interface DetectFactorRepository  extends JpaRepository<DetectFactor, Long> {
	
	public List<DetectFactor> getByDetectCategory(DetectCategory detectCategory);

	@Query("select d from DetectFactor d where d.detectContentDic.id=?1 and d.factorCode=?2")
	public DetectFactor getByDetectContentIdAndFactorCode(Long contentId,String factorCode);
	

}
