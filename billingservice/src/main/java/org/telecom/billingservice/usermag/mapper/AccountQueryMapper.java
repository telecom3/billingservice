package org.telecom.billingservice.usermag.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
		@Result(property="userReallName", column="user_reallName",javaType=String.class),
		@Result(property="userEmail", column="user_email",javaType=String.class),
		@Result(property="userID", column="user_ID",javaType=String.class),
		@Result(property="userAdress", column="user_adress",javaType=String.class),
		@Result(property="userQQ", column="user_qq",javaType=String.class),
		@Result(property="userTelphone", column="user_telphone",javaType=String.class),
		@Result(property="userState", column="user_state",javaType=int.class)
	})
	@Select(value = { "select id,user_name,user_pwd,user_gender,user_reallName,user_email,user_ID,user_adress,user_qq,user_telphone,user_state from t_user_info where id=#{id} " })
	UserInfoBean findUserInfoBeanById(@Param("id")Long  userId);
}
