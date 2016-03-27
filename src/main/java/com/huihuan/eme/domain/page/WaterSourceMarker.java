package com.huihuan.eme.domain.page;

import java.util.Date;

public class WaterSourceMarker {
	
	private String title;
	private String content;
	private ImageOffset imageOffset;
	private Point point; //位置
	private String waterName;
	private Date creationTime;
	private Long id;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the imageOffset
	 */
	public ImageOffset getImageOffset() {
		return imageOffset;
	}
	/**
	 * @param imageOffset the imageOffset to set
	 */
	public void setImageOffset(ImageOffset imageOffset) {
		this.imageOffset = imageOffset;
	}
	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}
	
	/**
	 * @return the waterName
	 */
	public String getWaterName() {
		return waterName;
	}
	/**
	 * @param waterName the waterName to set
	 */
	public void setWaterName(String waterName) {
		this.waterName = waterName;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	

}
