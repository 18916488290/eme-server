package com.huihuan.eme.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.huihuan.eme.domain.db.Epb;
import com.huihuan.eme.domain.db.WarehouseRisk;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午2:14:53
 *
 */
@Repository
public interface WarehouseRiskRepository extends JpaRepository<WarehouseRisk, Long> {
	
}