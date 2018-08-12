package org.telecom.billingservice.authoritymag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;




/**
 * 角色映射 SQL拼接类
 * @author wzc
 *
 */
public class RoleMapperSqlProvider {
	
	/**
	 * 分页条件查询sql语句
	 * @param param 参数
	 * @return sql语句
	 */
	public String listRoleByParams(Map<String,Object> param) {
		//得到参数
		Map params = (Map) param.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select id,role_name,role_type,role_describe from t_role_info "+commonSQL(params)+" limit "+params.get("index")+","+params.get("rows"));
		}
		
		return str.toString();
	}
	
	/**
	 * 分页条件查询统计总条数sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String countRoleByParams(Map<String,Object> param) {
		//得到参数
		Map params = (Map) param.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_role_info "+commonSQL(params));
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
		if(params.get("roleName")!=null||!StringUtils.isEmpty(params.get("roleName")+"")) {
			str.append("and role_name like concat('"+params.get("roleName")+"','%') ");
		}
		return str.toString();
	}
	
}
