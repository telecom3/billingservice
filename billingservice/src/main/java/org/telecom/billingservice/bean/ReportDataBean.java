package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 报表数据类
 * @author PC-msi yh
 *
 */
public class ReportDataBean implements Serializable {
	
	        /**
	 * 
	 */
	private static final long serialVersionUID = 5851971682810110193L;
			/**
	         * 字符
	         */
			private List<String> categories;
		   /**
		    * 数据
		    */
			private List<Integer> data;
			public List<String> getCategories() {
				return categories;
			}
			public void setCategories(List<String> categories) {
				this.categories = categories;
			}
			public List<Integer> getData() {
				return data;
			}
			public void setData(List<Integer> data) {
				this.data = data;
			}
			@Override
			public String toString() {
				return "ReportDataBean [categories=" + categories + ", data=" + data + "]";
			}
			
			
			

}
