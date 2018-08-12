package org.telecom.billingservice.publicservicemag.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.telecom.billingservice.bean.UserInfoBean;

import antlr.collections.List;
/**
 * 公共服务数据库映射类
 * @author 李博
 *
 */
public interface PublicUserInfoMapper {
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="userPwd", column="user_pwd",javaType=String.class),
		@Result(property="userGender", column="user_gender",javaType=Integer.class),
		@Result(property="userReallName", column="user_reallName",javaType=String.class),
		@Result(property="userEmail", column="user_email",javaType=String.class),
		@Result(property="userID", column="user_ID",javaType=String.class),
		@Result(property="userAdress", column="user_adress",javaType=String.class),
		@Result(property="userQQ", column="user_qq",javaType=String.class),
		@Result(property="userTelphone", column="user_telphone",javaType=String.class),
		@Result(property="userState", column="user_state",javaType=Integer.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),
		
	})
	@Select("select * from t_user_info where id=#{id}")
	UserInfoBean findUserInfoBeanById(@Param("id")Long userInfoId);
	@Select("select * from t_user_info where user_name=#{u.userName} and user_pwd=#{u.userPwd}")
	UserInfoBean  login(@Param("u")UserInfoBean userInfo);
}
