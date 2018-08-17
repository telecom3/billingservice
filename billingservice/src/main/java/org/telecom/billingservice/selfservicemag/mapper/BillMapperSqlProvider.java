package org.telecom.billingservice.selfservicemag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;

public class BillMapperSqlProvider {
	/**
	 * 个人月账单分页条件查询sql语句
	 * @param param 参数
	 * @return sql语句
	 */
	public String listBillMonthBy2Params(Map<String,Object> param) {
		//得到参数       
		Map params = (Map) param.get("params");
		System.out.println(params);
		
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			str.append("select * from t_bill_month  "+ commonSQL(params));
			str.append(" limit "+params.get("index")+","+params.get("limit"));
		}
		System.out.println(str.toString());
		return str.toString();
	}
	
	/**
	 * 个人月账单分页条件查询统计总条数sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String countBillMonthByParams(Map<String,Object> param) {
		//得到参数
		Map params = (Map) param.get("params");
		System.out.println(params);
		
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_bill_month "+ commonSQL(params));
			
		}
		System.out.println(str.toString());
		return str.toString();
	}
	
	/**
	 * 分页查询动态sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String commonSQL(Map params) {
		
		StringBuilder str = new StringBuilder();
		str.append(" where 1=1 ");
		
		Object id = params.get("id");
	    Object businessMonth = params.get("businessMonth");
		//判断客户名是否为null拼接sql语句
		
		if(id!=null && !StringUtils.isEmpty(params.toString())) {
			str.append(" and fk_user_id ='"+id+"'");
		}
		if(businessMonth!=null && !StringUtils.isEmpty(params.toString())) {
			str.append(" and business_month ='"+businessMonth+"'");
		}
		
		return str.toString();
	}
}
