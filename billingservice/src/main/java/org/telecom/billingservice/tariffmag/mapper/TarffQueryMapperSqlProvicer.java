package org.telecom.billingservice.tariffmag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;
public class TarffQueryMapperSqlProvicer {
	
	public String listAccountMonthBeanBy2Params(Map<String, Object> params){
		//得到参数
				Map param = (Map) params.get("params");
				StringBuilder str = new StringBuilder();
				if(params!=null) {
					//调用动态语句拼接sql语句
					str.append("select id,tariff_state,tariff_name,tariff_type,base_time,base_cost,unit_cost,cost_describle,strat_time,create_time,update_time,version  from t_tariff_info "+commonSQL(param));
					str.append(" limit "+param.get("index")+","+param.get("limit"));
				}
				return str.toString();
		
	}
	
	
	/**
	 * 查询数据条数SQL语句
	 * @param params 参数
	 * @return SQL语句
	 */
	public String countAccountMonthBeanBy2Params(Map<String,Object> params) {
		//得到参数
		Map param = (Map) params.get("params");
		
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_tariff_info "+commonSQL(param));
			
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
		Object userName = param.get("tariffState");
		Object osName = param.get("tariffName");
		Object accountYear = param.get("tariffType");
		
		//判断是否为null拼接sql语句
		if(userName!=null && !StringUtils.isEmpty(userName.toString())) {
			str.append("and tariff_state like '"+userName+"' ");
		}
		if(osName!=null && !StringUtils.isEmpty(osName.toString())) {
			str.append("and tariff_name like '"+osName+"' ");
		}
		if(accountYear!=null && !StringUtils.isEmpty(accountYear.toString())) {
			str.append("and tariff_type like '"+accountYear+"' ");
		}
		return str.toString();

}
}
