package com.huihuan.eme.service;

import com.huihuan.eme.domain.page.FactorValue;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
public interface DetectService {

	public String uploadFactorValues(FactorValue factorValue);
	
	public void calcAir();
}
