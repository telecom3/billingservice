package org.telecom.billingservice.logmag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;

/**
 * 登录日志SQL语句处理类
 * @author liuyangliang
 *
 */
public class LoginLogQueryMapperSqlProvider{
	/**
	 * 查询数据集合SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String listLoginInfoBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select id,login_name,login_exit_time,login_type,login_ip,login_exit  from t_login_info "+commonSQL(param));
			str.append(" limit "+param.get("index")+","+param.get("limit"));
		}
		
		return str.toString();
	}
	
	/**
	 * 查询数据条数SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String countLoginInfoBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_login_info "+commonSQL(param));
			
		}
		System.out.println("1111111111"+str.toString());
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
		
		Object loginName = param.get("loginName");
		Object loginType = param.get("loginType");
		Object loginExit = param.get("loginExit");
		Object startTime = param.get("startTime");
		Object endTime = param.get("endTime");
		
		//判断是否为null拼接sql语句
		if(loginName!=null && !StringUtils.isEmpty(loginName.toString())) {
			str.append("and login_name ='"+loginName+"' ");
		}
		if(loginType!=null && !StringUtils.isEmpty(loginType.toString())) {
			str.append("and login_type ='"+loginType+"' ");
		}
		if(loginExit!=null && !StringUtils.isEmpty(loginExit.toString())) {
			str.append("and login_exit = '"+loginExit+"' ");
		}
		if(startTime!=null && !StringUtils.isEmpty(startTime.toString())) {
			str.append("and login_exit_time > '"+startTime+"' ");
		}
		if(endTime!=null && !StringUtils.isEmpty(endTime.toString())) {
			str.append("and login_exit_time <= '"+endTime+"' ");
		}
		return str.toString();
	}
}
