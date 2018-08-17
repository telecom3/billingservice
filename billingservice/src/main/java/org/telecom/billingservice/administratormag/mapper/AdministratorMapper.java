package org.telecom.billingservice.administratormag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.UserInfoBean;

public interface AdministratorMapper {
	
	/**
	 * 分页统计条数
	 * @param params 统计条件
	 * @return 统计的条数
	 */
	@SelectProvider(method = "countAdministratorByParams", type = AdministratorSqlProvider.class)
	int countAdministratorByParams(@Param("params") Map params);
	/**
	 * 分页查询
	 * @param params 查询的条件
	 * @return 返回的数据
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="userPwd", column="user_pwd",javaType=String.class),
		@Result(property="userGender", column="user_gender",javaType=int.class),
		@Result(property="userReallName", column="user_reall_name",javaType=String.class),
		@Result(property="userEmail", column="user_email",javaType=String.class),
		@Result(property="userAdress", column="user_adress",javaType=String.class),
		@Result(property="userQQ", column="user_qq",javaType=String.class),
		@Result(property="userTelphone", column="user_telphone",javaType=String.class),
		@Result(property="userState", column="user_state",javaType=int.class),
		@Result(property="version", column="version",javaType=int.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),
		@Result(property="roleInfo", column="fk_role_id",one=@One(select="org.telecom.billingservice.authoritymag.mapper.RoleMapper.findRoleInfoBeanById"))

		
	})
	@SelectProvider(method = "listAdministratorByParams", type = AdministratorSqlProvider.class)
	List<UserInfoBean> listAdministratorByParams( @Param("params") Map params);
	
	/**
	 * 通过id 查询管理员对象
	 * @param id  管理员id
	 * @return 管理员对象
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="userPwd", column="user_pwd",javaType=String.class),
		@Result(property="userGender", column="user_gender",javaType=int.class),
		@Result(property="userReallName", column="user_reall_name",javaType=String.class),
		@Result(property="userEmail", column="user_email",javaType=String.class),
		@Result(property="userAdress", column="user_adress",javaType=String.class),
		@Result(property="userQQ", column="user_qq",javaType=String.class),
		@Result(property="userTelphone", column="user_telphone",javaType=String.class),
		@Result(property="userState", column="user_state",javaType=int.class),
		@Result(property="version", column="version",javaType=int.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),
		@Result(property="roleInfo", column="fk_role_id",one=@One(select="org.telecom.billingservice.authoritymag.mapper.RoleMapper.findRoleInfoBeanById"))
	})
	@Select("select id ,user_pwd,user_name,user_gender,user_reall_name,user_email,user_adress,user_qq,user_telphone,user_state,create_time,update_time,version,fk_role_id from t_user_info where id=#{id}  ")
	UserInfoBean findUserInfoBeanById(@Param("id")Long id);
}
