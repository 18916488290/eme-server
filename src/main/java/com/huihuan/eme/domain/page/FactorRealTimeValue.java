package com.huihuan.eme.domain.page;

import java.util.Date;

public class FactorRealTimeValue {

	    /**检测设备mn号**/
	    private String mn; 
	    /** 因子类型 0:air 1:water 3:vocs ...**/
	    private int factorType;
	    /** 污染物代码 */
		private String code;
		/** 污染物值 */
		private String value;
		/** 污染物状态*/
		private String flag;
		/** 污染物详细状态*/
		private String detail;
		/** 检测时间*/
		private Date detectTime;
		
		/***都是什么具体含义？**/
		private String today;
		private String total;
		private String surplus;
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
		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}
		/**
		 * @param code the code to set
		 */
		public void setCode(String code) {
			this.code = code;
		}
		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}
		/**
		 * @return the flag
		 */
		public String getFlag() {
			return flag;
		}
		/**
		 * @param flag the flag to set
		 */
		public void setFlag(String flag) {
			this.flag = flag;
		}
		/**
		 * @return the detail
		 */
		public String getDetail() {
			return detail;
		}
		/**
		 * @param detail the detail to set
		 */
		public void setDetail(String detail) {
			this.detail = detail;
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
		 * @return the today
		 */
		public String getToday() {
			return today;
		}
		/**
		 * @param today the today to set
		 */
		public void setToday(String today) {
			this.today = today;
		}
		/**
		 * @return the total
		 */
		public String getTotal() {
			return total;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(String total) {
			this.total = total;
		}
		/**
		 * @return the surplus
		 */
		public String getSurplus() {
			return surplus;
		}
		/**
		 * @param surplus the surplus to set
		 */
		public void setSurplus(String surplus) {
			this.surplus = surplus;
		}
		
}
