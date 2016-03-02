package com.huihuan.eme.domain.page;

public class Point {
	

	private double lng; //经度
	private double lat; //纬度

	
	public Point(double lng, double lat) {
		super();
		this.lng = lng;
		this.lat = lat;
	}
	public Point() {
	
	}
	/**
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

}
