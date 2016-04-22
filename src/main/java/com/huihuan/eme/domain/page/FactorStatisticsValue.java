package com.huihuan.eme.domain.page;

import java.util.Date;

public class FactorStatisticsValue {
	
	/**检测设备mn号**/
	private String mn; 
	
	/** 因子类型 0:air 1:water 3:vocs ...**/
	private int factorType;
	
	/**检测间隔类型 0:day 1:hour 2:minutes**/
	private int intervalType;

	/** 污染物代码**/
	private String code;
	
	/** 污染物指定时间内最小值*/
	private String min;
	
	/** 污染物指定时间内大值*/
	private String max;
	
	/** 污染物指定时间内平均值*/
	private String avg;
	
	/** 污染物指定时间内累计值*/
	private String cou;
	
	/** 污染物指定时间内折算最小值*/
	private String zsMin;
	
	/** 污染物指定时间内折算最大值*/
	private String zsMax;
	
	/** 污染物指定时间内折算平均值*/
	private String zsAvg;
	
	/** 污染物指定时间内折算累计值*/
	private String zsCou;
	
	/** 污染物报警上限值*/
	private String upValue;
	
	/** 污染物报警下限值*/
	private String lowValue;
	
	/** 检测时间 **/
	private Date detectTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getCou() {
		return cou;
	}

	public void setCou(String cou) {
		this.cou = cou;
	}

	public String getUpValue() {
		return upValue;
	}

	public void setUpValue(String upValue) {
		this.upValue = upValue;
	}

	public String getLowValue() {
		return lowValue;
	}

	public void setLowValue(String lowValue) {
		this.lowValue = lowValue;
	}

	public String getZsMin() {
		return zsMin;
	}

	public void setZsMin(String zsMin) {
		this.zsMin = zsMin;
	}

	public String getZsMax() {
		return zsMax;
	}

	public void setZsMax(String zsMax) {
		this.zsMax = zsMax;
	}

	public String getZsAvg() {
		return zsAvg;
	}

	public void setZsAvg(String zsAvg) {
		this.zsAvg = zsAvg;
	}

	public String getZsCou() {
		return zsCou;
	}

	public void setZsCou(String zsCou) {
		this.zsCou = zsCou;
	}

	/**
	 * @return the mn
	 */
	public String getMn() {
		return mn;
	}

	/**
	 * @param mn the mn to set
	 */
	public void setMn(String mn) {
		this.mn = mn;
	}

	/**
	 * @return the detectTime
	 */
	public Date getDetectTime() {
		return detectTime;
	}

	/**
	 * @param detectTime the detectTime to set
	 */
	public void setDetectTime(Date detectTime) {
		this.detectTime = detectTime;
	}

	/**
	 * @return the intervalType
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
	 * @return the factorType
	 */
	public int getFactorType() {
		return factorType;
	}

	/**
	 * @param factorType the factorType to set
	 */
	public void setFactorType(int factorType) {
		this.factorType = factorType;
	}
}
