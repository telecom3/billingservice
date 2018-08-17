package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 报表数据类
 * @author PC-msi yh
 *
 */
public class ReportDataBean2 implements Serializable {
	
	        /**
	 * 
	 */
	private static final long serialVersionUID = 5851971682810110193L;
			/**
	         * 字符
	         */
			private Integer value;
		   /**
		    * 数据
		    */
			private String name ;
		public Integer getValue() {
			return value;
		}
		public void setValue(int i) {
			this.value = i;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "ReportDataBean2 [value=" + value + ", name=" + name + "]";
		}

}
