package org.telecom.billingservice.converter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.telecom.billingservice.util.DateUtils;
/**
 * 日期类型属性编辑器(局部类型转换器)
 * @author liuyangliang
 *
 */
public class UtilDatePropertyEditor extends PropertyEditorSupport {

	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * text 表示来自于页面的数据
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Date date = null;
		try {
			if (StringUtils.hasLength(text)) {
				int lenth = text.length();
				switch (lenth) {
				// yyyy-MM-dd
				case 10:
					date = DateUtils.str2Date(new SimpleDateFormat("yyyy-MM-dd"), text);
					break;
				// yyyy-MM-dd hh:mm:ss
				default:
					date = DateUtils.str2Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), text);
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UtilDatePropertyEditor-------setAsText()", e);
		}
		

		this.setValue(date);
	}
}
