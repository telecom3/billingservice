package org.telecom.billingservice.administratormag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;


public class AdministratorSqlProvider {
	/**
	 * 分页查询动态sql语句
	 * @param params
	 * @return
	 */
	public String commonSQL(@SuppressWarnings("rawtypes") Map params) {
		StringBuilder str = new StringBuilder();
		str.append("where 1=1 ");
		//判断单车品牌是否为null拼接sql语句
		if(params.get("userName")!=null&&!StringUtils.isEmpty(params.get("userName").toString())) {
			str.append("and user_name like concat('"+params.get("userName")+"','%') ");
		}		
		return str.toString();
	}
	/**
	 * 分页查询统计总条数
	 * @param param
	 * @return
	 */
	public String countAdministratorByParams(Map<String,Object> param) {
		//得到参数
				Map params = (Map) param.get("params");
				
				StringBuilder str = new StringBuilder();
				if(params!=null) {
					//调用动态语句拼接sql语句
					str.append("select count(*) from t_user_info "+commonSQL(params));
				}
				return str.toString();

	}
	/**
	 * 分页动态查询sql语句
	 * @param param
	 * @return
	 */
	public String listAdministratorByParams(Map<String,Object> param) {
		//得到参数
				@SuppressWarnings("rawtypes")
				Map params = (Map) param.get("params");
				StringBuilder str = new StringBuilder();
				if(params!=null) {
					//调用动态语句拼接sql语句
					str.append("select id,user_name,user_email,user_pwd,user_reall_name,user_telphone,fk_role_id from t_user_info "+commonSQL(params)+" limit "+params.get("index")+","+params.get("limit"));
				}
				return str.toString();
	}
}
