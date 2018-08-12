package org.telecom.billingservice.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import org.telecom.billingservice.util.DateUtils;
/**
 * 定义全局类型转换器
 * @author liuyangliang
 *
 */
public class UtilDateContextConverter implements Converter<String, Date> {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public Date convert(String text) {
		// TODO Auto-generated method stub
		Date date = null;
		try {
			if (StringUtils.hasLength(text)) {
				int lenth = text.length();
				switch (lenth) {
				// yyyy年MM月dd日
				case 11:
					date = DateUtils.str2Date(new SimpleDateFormat("yyyy年MM月dd日"), text);
					break;
				// yyyy年MM月dd日 hh:mm:ss
				default:
					date = DateUtils.str2Date(new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss"), text);
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("UtilDatePropertyEditor-------setAsText()", e);
		}
		return date;
	}
}
