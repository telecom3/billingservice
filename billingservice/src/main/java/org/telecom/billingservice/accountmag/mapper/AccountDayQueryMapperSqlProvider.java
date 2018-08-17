package org.telecom.billingservice.accountmag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;


/**
 * 日账务SQL语句处理类
 * @author liuyangliang
 *
 */
public class AccountDayQueryMapperSqlProvider {
	
	/**
	 * 查询数据集合SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String listAccountDayBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select id,user_name,os_name,service_ip,account_year,account_month,account_day,count_time  from t_account_day "+commonSQL(param));
			str.append(" limit "+param.get("index")+","+param.get("limit"));
		}
		
		return str.toString();
	}
	
	/**
	 * 查询数据条数SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String countAccountDayBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_account_day "+commonSQL(param));
			
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
		Object serviceIp = param.get("serviceIp");
		Object accountYear = param.get("accountYear");
		Object accountMonth = param.get("accountMonth");
		
		//判断是否为null拼接sql语句
		if(userName!=null && !StringUtils.isEmpty(userName.toString())) {
			str.append("and user_name ='"+userName+"' ");
		}
		if(serviceIp!=null && !StringUtils.isEmpty(serviceIp.toString())) {
			str.append("and service_ip ='"+serviceIp+"' ");
		}
		if(accountYear!=null && !StringUtils.isEmpty(accountYear.toString())) {
			str.append("and account_year = '"+accountYear+"' ");
		}
		if(accountMonth!=null && !StringUtils.isEmpty(accountMonth.toString())) {
			str.append("and account_month = '"+accountMonth+"' ");
		}
		return str.toString();
	}
}
