package com.huihuan.eme.domain.page;

import java.util.ArrayList;
import java.util.List;

public class DataPacket {
	

	private String mn;
	private String st;
	private String cn;
	private String uploadTime;

	private List<FactorRealTimeValue> factorRealTimeValues= new ArrayList<FactorRealTimeValue>(0);
	private List<FactorStatisticsValue> factorStatisticsValues= new ArrayList<FactorStatisticsValue>(0);
	
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
	 * @return 返回上传时间
	 */
	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * @return 返回实时检测数据
	 */
	public List<FactorRealTimeValue> getFactorRealTimeValues() {
		return factorRealTimeValues;
	}


	public void setFactorRealTimeValues(List<FactorRealTimeValue> factorRealTimeValues) {
		this.factorRealTimeValues = factorRealTimeValues;
	}

	/**
	 * @return 返回实时统计数据
	 */
	public List<FactorStatisticsValue> getFactorStatisticsValues() {
		return factorStatisticsValues;
	}


	public void setFactorStatisticsValues(List<FactorStatisticsValue> factorStatisticsValues) {
		this.factorStatisticsValues = factorStatisticsValues;
	}

	/**
	 * @return 返回系统类别，参照国标
	 */
	public String getSt() {
		return st;
	}


	public void setSt(String st) {
		this.st = st;
	}

	/**
	 * @return 返回协议类型
	 */
	public String getCn() {
		return cn;
	}


	public void setCn(String cn) {
		this.cn = cn;
	}

	
}
