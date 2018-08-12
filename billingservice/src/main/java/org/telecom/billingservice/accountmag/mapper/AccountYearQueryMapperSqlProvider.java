package org.telecom.billingservice.accountmag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;

/**
 * 年账务SQL语句处理类
 * @author liuyangliang
 *
 */
public class AccountYearQueryMapperSqlProvider {

	/**
	 * 查询数据集合SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String listAccountYearBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select id,os_name,service_ip,account_year,count_time,fk_user_id  from t_account_year "+commonSQL(param));
			str.append(" limit "+param.get("index")+","+param.get("limit"));
		}
		return str.toString();
	}
	
	/**
	 * 查询数据条数SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String countAccountYearBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_account_year "+commonSQL(param));
			
		}
		return str.toString();
	}
	
	/**
	 * 分页查询动态sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String commonSQL(Map param) {
		StringBuilder str = new StringBuilder();
		str.append("where 1=1 ");
		Object userName = param.get("userName");
		Object osName = param.get("osName");
		
		//判断是否为null拼接sql语句
		if(userName!=null && !StringUtils.isEmpty(userName.toString())) {
			str.append("and user_name ='"+userName+"' ");
		}
		if(osName!=null && !StringUtils.isEmpty(osName.toString())) {
			str.append("and os_name ='"+osName+"' ");
		}
		return str.toString();
	}
}
