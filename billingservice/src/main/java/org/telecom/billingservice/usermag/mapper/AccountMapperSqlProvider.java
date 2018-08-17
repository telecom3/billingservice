package org.telecom.billingservice.usermag.mapper;

import java.util.Map;

import org.telecom.billingservice.util.StringUtils;

/**
 * 用户sql拼接类
 * @author wzc
 *
 */
public class AccountMapperSqlProvider {
	/**
	 * 分页条件查询sql语句
	 * @param param 参数
	 * @return sql语句
	 */
	public String listUserInfoByParams(Map<String,Object> param) {
		//得到参数
		Map<String, Object> params = (Map<String, Object>) param.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select id,user_name,create_time,update_time,user_pwd,user_gender,user_reall_name,user_email,user_ID,user_adress,user_qq,user_telphone,user_state,fk_role_id from t_user_info "+commonSQL(params)+" limit "+params.get("index")+","+params.get("rows"));
		}
		return str.toString();
	}
	
	/**
	 * 分页条件查询统计总条数sql语句
	 * @param params 参数
	 * @return sql语句
	 */
	public String countUserInfoByParams(Map<String,Object> param) {
		//得到参数
		Map<String, Object> params = (Map<String, Object>) param.get("params");
		StringBuilder str = new StringBuilder();
		if(params!=null) {
			//调用动态语句拼接sql语句
			str.append("select count(*) from t_user_info "+commonSQL(params));
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
		
		if(params.get("userName")!=null&&!StringUtils.isEmpty(params.get("userName")+"")) {
			str.append("and user_name like concat('"+params.get("userName")+"','%') ");
		}
		
		if(params.get("userReallName")!=null&&!StringUtils.isEmpty(params.get("userReallName")+"")) {
			str.append("and user_reall_name like concat('"+params.get("userReallName")+"','%') ");
		}
		if(params.get("userID")!=null&&!StringUtils.isEmpty(params.get("userID")+"")) {
			str.append("and user_ID ='"+params.get("userID")+"' ");
		}
		if(params.get("userState")!=null&&!StringUtils.isEmpty(params.get("userState")+"")) {
			str.append("and user_state ='"+params.get("userState")+"' ");
		}
		return str.toString();
	}
}
