package org.telecom.billingservice.usermag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.authoritymag.mapper.RoleMapperSqlProvider;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 映射层账务账号查询接口
 * @author wzc
 *
 */
public interface AccountQueryMapper {
	/**
	 * 根据用户得id查找用户
	 * @param userId  账务账号id
	 * @return  账务账号实体
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="userPwd", column="user_pwd",javaType=String.class),
		@Result(property="userGender", column="user_gender",javaType=int.class),
		@Result(property="userReallName", column="user_reall_name",javaType=String.class),
		@Result(property="userEmail", column="user_email",javaType=String.class),
		@Result(property="userID", column="user_ID",javaType=String.class),
		@Result(property="userAdress", column="user_adress",javaType=String.class),
		@Result(property="userQQ", column="user_qq",javaType=String.class),
		@Result(property="userTelphone", column="user_telphone",javaType=String.class),
		@Result(property="userState", column="user_state",javaType=int.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),
		@Result(property="version", column="version",javaType=int.class),
		@Result(property="roleInfo", column="fk_role_id",one=@One(select="org.telecom.billingservice.authoritymag.mapper.RoleMapper.findRoleInfoBeanById"))

	})
	@Select(value = { "select id,user_name,create_time,update_time,user_pwd,user_gender,user_reall_name,user_email,user_ID,user_adress,user_qq,user_telphone,user_state,fk_role_id,version from t_user_info where id=#{id} " })
	UserInfoBean findUserInfoBeanById(@Param("id")Long  userId);
	
	/**
	 * 按多条件统计条数
	 * @param params 查询条件
	 * @return 数据条数
	 */
	@SelectProvider(method = "countUserInfoByParams", type = AccountMapperSqlProvider.class)
	int countUserInfoByParams(@Param("params")Map<String,Object> params);
	/**
	 * 多条件查询用户集合
	 * @param params 查询条件
	 * @return 用户集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="userPwd", column="user_pwd",javaType=String.class),
		@Result(property="userGender", column="user_gender",javaType=int.class),
		@Result(property="userReallName", column="user_reall_name",javaType=String.class),
		@Result(property="userEmail", column="user_email",javaType=String.class),
		@Result(property="userID", column="user_ID",javaType=String.class),
		@Result(property="userAdress", column="user_adress",javaType=String.class),
		@Result(property="userQQ", column="user_qq",javaType=String.class),
		@Result(property="userTelphone", column="user_telphone",javaType=String.class),
		@Result(property="userState", column="user_state",javaType=int.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),
		@Result(property="version", column="version",javaType=int.class),
		@Result(property="roleInfo", column="fk_role_id",one=@One(select="org.telecom.billingservice.authoritymag.mapper.RoleMapper.findRoleInfoBeanById"))
	})
	@SelectProvider(method = "listUserInfoByParams", type = AccountMapperSqlProvider.class)
	List<UserInfoBean> listUserInfoByParams(@Param("params")Map<String,Object> params);
}
