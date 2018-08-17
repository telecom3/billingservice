package org.telecom.billingservice.usermag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;

/**
 * 业务账号查询接口映射SQL拼接
 * @author wzc
 *
 */
public class BusinessMapperSqlProvider {
	/**
	 * 分页条件查询sql语句
	 * @param param 参数
	 * @return sql语句
	 */
	public String listBusinessInfoBeanByParams(Map<String,Object> param) {
		//得到参数
		Map<String, Object> params = (Map<String, Object>) param.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select b.id,business_os,u.user_ID,business_os_pwd,IP_adress,business_state,fk_account_id,fk_tariff_id,b.create_time,b.update_time,b.version from t_business_info b left join t_user_info u on u.id=b.fk_account_id  "+commonSQL(params)+" limit "+params.get("index")+","+params.get("rows"));
		}
		return str.toString();
	}
	
	/**
	 * 分页条件查询统计总条数sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String countBusinessInfoBeanByParams(Map<String,Object> param) {
		//得到参数
		Map<String, Object> params = (Map<String, Object>) param.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_business_info b left join t_user_info u on u.id=b.fk_account_id "+commonSQL(params));
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
		
		if(params.get("businessOs")!=null&&!StringUtils.isEmpty(params.get("businessOs")+"")) {
			str.append("and business_os like concat('"+params.get("businessOs")+"','%') ");
		}
		
		if(params.get("businessState")!=null&&!StringUtils.isEmpty(params.get("businessState")+"")) {
			str.append("and business_state ='"+params.get("businessState")+"' ");
		}
		if(params.get("ipAdress")!=null&&!StringUtils.isEmpty(params.get("ipAdress")+"")) {
			str.append("and IP_adress ='"+params.get("ipAdress")+"' ");
		}
		if(params.get("userID")!=null&&!StringUtils.isEmpty(params.get("userID")+"")) {
			str.append("and user_ID ='"+params.get("userID")+"' ");
		}
		return str.toString();
	}
}
