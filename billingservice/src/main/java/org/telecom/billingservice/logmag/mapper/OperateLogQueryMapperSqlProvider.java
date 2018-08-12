package org.telecom.billingservice.logmag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;

/**
 * 操作日志Sql语句处理类
 * @author liuyangliang
 *
 */
public class OperateLogQueryMapperSqlProvider {
	/**
	 * 查询数据集合SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String listOperateInfoBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select id,operator,operator_time,operator_mode,operator_type,fk_data_id  from t_operate_info "+commonSQL(param));
			str.append(" limit "+param.get("index")+","+param.get("limit"));
		}
		
		return str.toString();
	}
	
	/**
	 * 查询数据条数SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String countOperateInfoBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_operate_info "+commonSQL(param));
			
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
		
		Object operator = param.get("operator");
		Object operatorMode = param.get("operatorMode");
		Object operatorType = param.get("operatorType");
		Object startTime = param.get("startTime");
		Object endTime = param.get("endTime");
		
		//判断是否为null拼接sql语句
		if(operator!=null && !StringUtils.isEmpty(operator.toString())) {
			str.append("and operator ='"+operator+"' ");
		}
		if(operatorMode!=null && !StringUtils.isEmpty(operatorMode.toString())) {
			str.append("and operator_mode ='"+operatorMode+"' ");
		}
		if(operatorType!=null && !StringUtils.isEmpty(operatorType.toString())) {
			str.append("and operator_type = '"+operatorType+"' ");
		}
		if(startTime!=null && !StringUtils.isEmpty(startTime.toString())) {
			str.append("and operator_time >= '"+startTime+"' ");
		}
		if(endTime!=null && !StringUtils.isEmpty(endTime.toString())) {
			str.append("and operator_time <= '"+endTime+"' ");
		}
		return str.toString();
	}
}
