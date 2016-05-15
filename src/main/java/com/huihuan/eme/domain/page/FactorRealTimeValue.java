package com.huihuan.eme.domain.page;

import java.util.Date;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 */

public class FactorRealTimeValue {

	    private String mn; 
	    private int factorType;
		private String code;
		private String value;
		private String flag;
		private String detail;
		private Date detectTime;
		private String today;
		private String total;
		private String surplus;
	
		
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
		 * @return  返回检测因子代码
		 */
		public String getCode() {
			return code;
		}
	
		public void setCode(String code) {
			this.code = code;
		}
		/**
		 * @return 返回检测因子检测值
		 */
		public String getValue() {
			return value;
		}
	
		public void setValue(String value) {
			this.value = value;
		}
		/**
		 * @return 返回污染物状态 
		 * 水：   P电源故障，F：排放源停运，C：校验，M维护，T超测上限，D故障，S设定值，N正常
		 * 空气： 0校准数据，1:气象参数，2异常数据，3正常数据
		 */
		public String getFlag() {
			return flag;
		}
		
		public void setFlag(String flag) {
			this.flag = flag;
		}
		/**
		 * @return 返回污染物详细状态，自定义状态
		 */
		public String getDetail() {
			return detail;
		}
	
		public void setDetail(String detail) {
			this.detail = detail;
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
		/**
		 * @return 今日流量
		 */
		public String getToday() {
			return today;
		}
		
		public void setToday(String today) {
			this.today = today;
		}
		/**
		 * @return 流量总量
		 */
		public String getTotal() {
			return total;
		}
	
		public void setTotal(String total) {
			this.total = total;
		}
		/**
		 * @return 剩余金额
		 */
		public String getSurplus() {
			return surplus;
		}
		
		public void setSurplus(String surplus) {
			this.surplus = surplus;
		}
		
}
