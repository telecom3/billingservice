package org.telecom.billingservice.selfservicemag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
/**
 * 用户自服务数据库映射类
 * @author 李博
 *
 */
public interface SelfserviceMapper {
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
		@Result(property="userReallName", column="user_reallName",javaType=String.class),
		@Result(property="userEmail", column="user_email",javaType=String.class),
		@Result(property="userID", column="user_ID",javaType=String.class),
		@Result(property="userAdress", column="user_adress",javaType=String.class),
		@Result(property="userQQ", column="user_qq",javaType=String.class),
		@Result(property="userTelphone", column="user_telphone",javaType=String.class),
		@Result(property="userState", column="user_state",javaType=Integer.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class)
	})
	@Select("select * from t_user_info where id=#{id}")
    UserInfoBean findUserInfoBeanById(@Param("id")Long userInfoId);
	/**
	 * 月账单分页统计方法
	 * @param params 查询条件
	 * @return 统计的条数
	 */
	@SelectProvider(type=SelfserviceMapperSqlProvider.class,method="countBusinessDayByParams")
	int countBusinessDayByParams(@Param("params")Map params);
	/**
	 * 日账单分页统计方法
	 * @param params 查询条件
	 * @return 统计的条数
	 */
	@SelectProvider(type=SelfserviceMapperSqlProvider.class,method="countBusinessMonthByParams")
	int countBusinessMonthByParams(@Param("params")Map params);
	/**
	 * 个人月账单分页统计方法
	 * @param params 查询条件
	 * @return 统计的条数
	 */
	@SelectProvider(type=SelfserviceMapperSqlProvider.class,method="countBillMonthBeanByParams")
	int countBillMonthByParams(@Param("params")Map params);

	/**
	 * 个人月账单分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="payType", column="pay_type",javaType=Integer.class),
		@Result(property="payState", column="pay_state",javaType=Integer.class),
		@Result(property="osTime", column="os_time",javaType=Long.class),
		@Result(property="osCost", column="os_cost",javaType=Double.class),
		@Result(property="businessYear", column="business_year",javaType=String.class),
		@Result(property="businessMonth", column="business_month",javaType=String.class),
	})
	@SelectProvider(type=SelfserviceMapperSqlProvider.class,method="listBillMonthBeanBy2Params")
	List<BillMonthBean> listBillMonthBeanBy2Params(@Param("params")PagerBean page,Map<String,Object> params);
	/**
	 * 账务账号下所有业务账号当月发生的费用明细信息分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="businessName", column="business_name",javaType=String.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="osTime", column="os_time",javaType=Long.class),
		@Result(property="osCost", column="os_cost",javaType=Double.class),
		@Result(property="businessMonth", column="business_month",javaType=String.class),
		@Result(property="businessYear", column="business_year",javaType=String.class),
		@Result(property="tariffName", column="tariff_name",javaType=String.class),
	})
	@SelectProvider(type=SelfserviceMapperSqlProvider.class,method="listBusinessMonthBeanBy2Params")
	List<BusinessMonthBean> listBusinessMonthBeanBy2Params(@Param("params")PagerBean page,Map<String,Object> params);
	/**
	 * 账务账号下单个业务账号每日发生的费用明细信息分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="osName", column="os_name",javaType=String.class),
		@Result(property="osCost", column="os_cost",javaType=Double.class),
		@Result(property="businessDay", column="business_day",javaType=String.class),
		@Result(property="businessMonrth", column="business_monrth",javaType=String.class),
		@Result(property="businessYear", column="business_year",javaType=String.class),
		@Result(property="tariffName", column="tariff_name",javaType=String.class),
	})
	@SelectProvider(type=SelfserviceMapperSqlProvider.class,method="listBusinessDayBeanBy2Params")
	List<BusinessDayBean> listBusinessDayBeanBy2Params(@Param("param")PagerBean page,Map<String,Object> params);


	}


