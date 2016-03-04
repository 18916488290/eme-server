package com.huihuan.eme.domain.page;

import java.util.Date;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午10:03:15
 *
 */
public class AirReport {
	
	private long stationId;
    private Date reportTime;
    private Boolean isDaily;
    private Float aqi;
    private Float so2Aqi;
    private Float o3Aqi;
    private Float no2Aqi;
    private Float pm10Aqi;
    private Float pm25Aqi;
    private Float coAqi;
    private String aqiInfo;
	/**
	 * @return the stationId
	 */
	public long getStationId() {
		return stationId;
	}
	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(long stationId) {
		this.stationId = stationId;
	}
	/**
	 * @return the reportTime
	 */
	public Date getReportTime() {
		return reportTime;
	}
	/**
	 * @param reportTime the reportTime to set
	 */
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	/**
	 * @return the isDaily
	 */
	public Boolean getIsDaily() {
		return isDaily;
	}
	/**
	 * @param isDaily the isDaily to set
	 */
	public void setIsDaily(Boolean isDaily) {
		this.isDaily = isDaily;
	}
	/**
	 * @return the aqi
	 */
	public Float getAqi() {
		return aqi;
	}
	/**
	 * @param aqi the aqi to set
	 */
	public void setAqi(Float aqi) {
		this.aqi = aqi;
	}
	/**
	 * @return the so2Aqi
	 */
	public Float getSo2Aqi() {
		return so2Aqi;
	}
	/**
	 * @param so2Aqi the so2Aqi to set
	 */
	public void setSo2Aqi(Float so2Aqi) {
		this.so2Aqi = so2Aqi;
	}
	/**
	 * @return the o3Aqi
	 */
	public Float getO3Aqi() {
		return o3Aqi;
	}
	/**
	 * @param o3Aqi the o3Aqi to set
	 */
	public void setO3Aqi(Float o3Aqi) {
		this.o3Aqi = o3Aqi;
	}
	/**
	 * @return the no2Aqi
	 */
	public Float getNo2Aqi() {
		return no2Aqi;
	}
	/**
	 * @param no2Aqi the no2Aqi to set
	 */
	public void setNo2Aqi(Float no2Aqi) {
		this.no2Aqi = no2Aqi;
	}
	/**
	 * @return the pm10Aqi
	 */
	public Float getPm10Aqi() {
		return pm10Aqi;
	}
	/**
	 * @param pm10Aqi the pm10Aqi to set
	 */
	public void setPm10Aqi(Float pm10Aqi) {
		this.pm10Aqi = pm10Aqi;
	}
	/**
	 * @return the pm25Aqi
	 */
	public Float getPm25Aqi() {
		return pm25Aqi;
	}
	/**
	 * @param pm25Aqi the pm25Aqi to set
	 */
	public void setPm25Aqi(Float pm25Aqi) {
		this.pm25Aqi = pm25Aqi;
	}
	/**
	 * @return the coAqi
	 */
	public Float getCoAqi() {
		return coAqi;
	}
	/**
	 * @param coAqi the coAqi to set
	 */
	public void setCoAqi(Float coAqi) {
		this.coAqi = coAqi;
	}
	/**
	 * @return the aqiInfo
	 */
	public String getAqiInfo() {
		return aqiInfo;
	}
	/**
	 * @param aqiInfo the aqiInfo to set
	 */
	public void setAqiInfo(String aqiInfo) {
		this.aqiInfo = aqiInfo;
	}
	
	


}
