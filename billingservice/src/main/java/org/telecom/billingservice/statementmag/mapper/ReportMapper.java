package org.telecom.billingservice.statementmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.junit.runners.Parameterized.Parameter;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.UserInfoBean;

public interface ReportMapper {
	
	   
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="businessName",column="business_name",javaType=String.class),
		@Result(property="userName",column="user_name",javaType=String.class),
		@Result(property="osTime",column="os_time",javaType=Long.class),
		@Result(property="osCost",column="os_cost",javaType=Double.class),
		@Result(property="businessMonrth",column="business_Monrth",javaType=String.class),
		@Result(property="businessYear",column="business_year",javaType=String.class),
		@Result(property="tariffName",column="tariff_name",javaType=String.class)
		
	})
	   @Select(value="select * from t_business_month where user_name = #{username} and business_year= #{year}")
	   List<BusinessMonthBean> getBunsinessCost(@Param("username")String user,@Param("year")String year);
	   
	   @Results({
			@Result(id=true,property="id",column="id",javaType=Long.class),
			@Result(property="osCost",column="os_cost",javaType=Double.class),
			@Result(property="businessYear",column="business_year",javaType=String.class),
			@Result(property="businessMonth",column="business_month",javaType=String.class),
			@Result(property="userInfo",column="fk_user_id",javaType=UserInfoBean.class,
	        one=@One(select="org.telecom.billingservice.usermag.mapper.AccountQueryMapper.findUserInfoBeanById",fetchType=FetchType.EAGER))
		})
	   @Select(value = { "select os_cost,business_year, business_month,fk_user_id from t_bill_month as b left join t_user_info as u on b.fk_user_id=u.id where u.id=#{id} and business_year=#{year}" })
	   List<BillMonthBean>  findUserMonths(@Param("id")Long id,@Param("year")String businessYear);
}


