package com.huihuan.eme.domain.page;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午10:03:15
 *
 */
public class FactorValue {
	
	private long stationId;
	private long factorId;
	private float val;
	private boolean isDaily;
	private String mn;
	
	
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
	 * @return the factorId
	 */
	public long getFactorId() {
		return factorId;
	}
	/**
	 * @param factorId the factorId to set
	 */
	public void setFactorId(long factorId) {
		this.factorId = factorId;
	}
	/**
	 * @return the val
	 */
	public float getVal() {
		return val;
	}
	/**
	 * @param val the val to set
	 */
	public void setVal(float val) {
		this.val = val;
	}
	/**
	 * @return the isDaily
	 */
	public boolean isDaily() {
		return isDaily;
	}
	/**
	 * @param isDaily the isDaily to set
	 */
	public void setDaily(boolean isDaily) {
		this.isDaily = isDaily;
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


}
