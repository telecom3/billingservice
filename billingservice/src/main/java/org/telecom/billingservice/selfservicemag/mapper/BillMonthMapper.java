package org.telecom.billingservice.selfservicemag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.UserInfoBean;

public interface BillMonthMapper {
	/**
	 * 根据id查询个人信息
	 * @param userInfoId 用户Id
	 * @return 用户实体
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="userPwd", column="user_pwd",javaType=String.class),
		@Result(property="userGender", column="user_gender",javaType=Integer.class),
		@Result(property="userReallName", column="user_reall_name",javaType=String.class),
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
	/**
	 * 个人月账单分页统计方法
	 * @param params 查询条件
	 * @return 统计的条数
	 */
	@SelectProvider(type=BillMapperSqlProvider.class,method="countBillMonthByParams")
	int countBillMonthByParams(@Param("params")Map params);

	/**
	 * 个人月账单分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="payType", column="pay_type",javaType=int.class),
		@Result(property="payState", column="pay_state",javaType=int.class),
		@Result(property="osTime", column="os_time",javaType=long.class),
		@Result(property="osCost", column="os_cost",javaType=double.class),
		@Result(property="businessYear", column="business_year",javaType=String.class),
		@Result(property="businessMonth", column="business_month",javaType=String.class),
		@Result(property="userInfo", column="fk_user_id",one=@One(select="org.telecom.billingservice.usermag.mapper.AccountQueryMapper.findUserInfoBeanById"))
	})
	@SelectProvider(type=BillMapperSqlProvider.class,method="listBillMonthBy2Params")
	List<BillMonthBean> listBillMonthBeanBy2Params(@Param("params")Map<String,Object> params);
}
