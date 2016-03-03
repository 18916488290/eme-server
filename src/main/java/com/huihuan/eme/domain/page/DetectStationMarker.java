package com.huihuan.eme.domain.page;

public class DetectStationMarker {
	
	private Long stationId;
	private String title;
	private String content;
	private ImageOffset imageOffset;
	private Point point; //位置
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
	 * @return the stationId
	 */
	public Long getStationId() {
		return stationId;
	}
	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}


}
