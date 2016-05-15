package com.huihuan.eme.domain.page;

import java.util.Date;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 */
public class FactorStatisticsValue {

	private String mn; 
	private int factorType;
	private int intervalType;
	private String code;
	private String min;
	private String max;
	private String avg;
	private String cou;
	private String upValue;
	private String lowValue;
	private String zsMin;
	private String zsMax;
	private String zsAvg;
	private String zsCou;
	private Date detectTime;

	/**
	 * @return  返回检测设备mn号
	 */
	public String getMn() {
		return mn;
	}


	public void setMn(String mn) {
		this.mn = mn;
	}

	/**
	 * @return 返回因子类型 0:air 1:water 3:vocs ...*
	 */
	public int getFactorType() {
		return factorType;
	}

	public void setFactorType(int factorType) {
		this.factorType = factorType;
	}
	/**
	 * @return 返回检测间隔类型 0:day 1:hour 2:minutes
	 */
	public int getIntervalType() {
		return intervalType;
	}

	/**
	 * @param intervalType the intervalType to set
	 */
	public void setIntervalType(int intervalType) {
		this.intervalType = intervalType;
	}

	/**
	 * @return  返回检测因子代码
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return  返回检测因子指定时间内最小值
	 */
	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	/**
	 * @return  返回检测因子指定时间内最大值
	 */
	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}
	/**
	 * @return  返回检测因子指定时间内平均值
	 */
	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	/**
	 * @return  返回检测因子指定时间内累计值
	 */
	public String getCou() {
		return cou;
	}

	public void setCou(String cou) {
		this.cou = cou;
	}

	/**
	 * @return  返回检测因子报警上限
	 */
	public String getUpValue() {
		return upValue;
	}

	public void setUpValue(String upValue) {
		this.upValue = upValue;
	}

	/**
	 * @return  返回检测因子报警下限
	 */
	public String getLowValue() {
		return lowValue;
	}

	public void setLowValue(String lowValue) {
		this.lowValue = lowValue;
	}

	/**
	 * @return  返回检测因子折算最小值
	 */
	public String getZsMin() {
		return zsMin;
	}

	public void setZsMin(String zsMin) {
		this.zsMin = zsMin;
	}

	/**
	 * @return  返回检测因子折算最大值
	 */
	public String getZsMax() {
		return zsMax;
	}

	public void setZsMax(String zsMax) {
		this.zsMax = zsMax;
	}
	/**
	 * @return  返回检测因子折算平均值
	 */
	public String getZsAvg() {
		return zsAvg;
	}

	public void setZsAvg(String zsAvg) {
		this.zsAvg = zsAvg;
	}

	/**
	 * @return  返回检测因子折算累计值
	 */
	public String getZsCou() {
		return zsCou;
	}

	public void setZsCou(String zsCou) {
		this.zsCou = zsCou;
	}
	
	/**
	 * @return 返回检测时间
	 */
	public Date getDetectTime() {
		return detectTime;
	}


	public void setDetectTime(Date detectTime) {
		this.detectTime = detectTime;
	}

}
