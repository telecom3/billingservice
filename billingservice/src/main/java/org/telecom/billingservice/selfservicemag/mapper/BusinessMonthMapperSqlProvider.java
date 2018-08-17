package org.telecom.billingservice.selfservicemag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;

public class BusinessMonthMapperSqlProvider {
	/**
	 * 个人月账单分页条件查询sql语句
	 * @param param 参数
	 * @return sql语句
	 */
	public String listBusinessMonthBeanBy2Params(Map<String,Object> param) {
		//得到参数
		Map params = (Map) param.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select * from t_business_month "+commonSQL(params));
			str.append(" limit "+params.get("index")+","+params.get("limit"));
		}
		return str.toString();
	}
	
	/**
	 * 个人月账单分页条件查询统计总条数sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String countBusinessMonthByParams(Map<String,Object> param) {
		//得到参数
		Map params = (Map) param.get("params");
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_business_month "+commonSQL(params));
			
		}
		
		return str.toString();
	}
	/**
	 * 分页查询动态sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String commonSQL(Map params) {
		StringBuilder str = new StringBuilder();
		str.append("where 1=1 ");
		
		//判断客户名是否为null拼接sql语句
		if(StringUtils.isEmpty(params.toString())) {
			str.append("and business_monrth like concat('"+params.get("businessMonrth")+"','%') ");
		}
		
		return str.toString();
	}
}
