package com.huihuan.eme.domain.page;

public class PullantSourceInfo {
	
	private long id;
	private long companyId;
	private String companyName; //企业名称
	private String divsion;  //行政区域
	private String type; //污染源类型

	/**
	 * @return the companyId
	 */
	public long getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the divsion
	 */
	public String getDivsion() {
		return divsion;
	}
	/**
	 * @param divsion the divsion to set
	 */
	public void setDivsion(String divsion) {
		this.divsion = divsion;
	}


	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	

}
