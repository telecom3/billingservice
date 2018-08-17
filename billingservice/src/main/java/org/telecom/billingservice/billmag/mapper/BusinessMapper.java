package org.telecom.billingservice.billmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;

public interface BusinessMapper {
    
	@ResultType(Integer.class)
	@SelectProvider(type=BusinessMonthSqlProvider.class,method="countBusiness")
	int countBusiness(@Param("params") Map params);
	
	
	
//	@Results({
//		@Result(id=true,property="id",column="id",javaType=Long.class),
//		@Result(property="payType",column="pay_type",javaType=Integer.class),
//		@Result(property="payState",column="pay_state",javaType=Integer.class),
//		@Result(property="osTime",column="os_time",javaType=Integer.class),
//		@Result(property="osCost",column="os_cost",javaType=Integer.class),
//		@Result(property="businessYear",column="business_year",javaType=Integer.class),
//		@Result(property="businessMonth",column="business_month",javaType=Integer.class),
//	})
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="businessName",column="business_name",javaType=String.class),
		@Result(property="userName",column="user_name",javaType=String.class),
		@Result(property="osTime",column="os_time",javaType=Long.class),
		@Result(property="osCost",column="os_cost",javaType=Double.class),
		@Result(property="businessMonrth",column="business_Monrth",javaType=String.class),
		@Result(property="businessYear",column="business_year",javaType=String.class),
		@Result(property="tariffName",column="tariff_name",javaType=String.class),
		
	})
	@SelectProvider(type=BusinessMonthSqlProvider.class,method="listByBusiness")
	List<BusinessMonthBean> listByBusiness(@Param("params")Map params,@Param("pager")PagerBean pager);
	
	/**
	 * 查询年表的数量
	 * @param params
	 * @return
	 */
	
	@ResultType(Integer.class)
	@SelectProvider(type=BusinessMonthSqlProvider.class,method="countBusinessDay")
	int countDayBusiness(@Param("params")Map params);
	/**
	 * 
	 * @param params
	 * @param pager
	 * @return
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="osName",column="os_name",javaType=String.class),
		@Result(property="userName",column="user_name",javaType=String.class),
		@Result(property="osCost",column="os_cost",javaType=Double.class),
		@Result(property="businessDay",column="business_day",javaType=String.class),
		@Result(property="businessMonth",column="business_month",javaType=String.class),
		@Result(property="businessYear",column="business_year",javaType=String.class),
		@Result(property="tariffName",column="tariff_name",javaType=String.class),
	})
	@SelectProvider(type=BusinessMonthSqlProvider.class,method="listByBusinessDay")
	List<BusinessDayBean> ListByDayBusiness(@Param("params")Map params,@Param("pager")PagerBean pager);
	
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="businessOs",column="business_os",javaType=String.class),
		@Result(property="ipAdress",column="IP_adress",javaType=String.class),
		@Result(property="businessState",column="business_state",javaType=Integer.class),
		@Result(property="createTime",column="create_time",javaType=Date.class),
		@Result(property="updateTime",column="update_time",javaType=Date.class),
	})
	@Select("select * from t_business_info where business_os=#{osName}")
	BusinessInfoBean findOS(@Param("osName")String osName);
	
}
