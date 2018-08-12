package org.telecom.billingservice.util;
/**
 * 字符串工具类
 * @author liuyangliang
 *
 */
public class StringUtils {

	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str)||str.length()==0) {
			return true;
		}
		else {
			return false;
		}
	
	}
}
