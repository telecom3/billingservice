package org.telecom.billingservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式转换工具类
 * 
 * @author liuyangliang
 *
 */
public class DateUtils {
	/**
	 * 将字符串转换成日期
	 * 
	 * @param format
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date str2Date(SimpleDateFormat format, String str) throws ParseException {
		return format.parse(str);
	}

}
