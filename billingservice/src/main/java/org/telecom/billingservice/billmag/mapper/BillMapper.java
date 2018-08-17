package org.telecom.billingservice.billmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;

public interface BillMapper {

	@ResultType(Integer.class)
	@SelectProvider(type=BillMonthSqlProvider.class,method="countMonthBill")
	int countMonthBill(Map params);

	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="payType",column="pay_type",javaType=Integer.class),
		@Result(property="payState",column="pay_state",javaType=Integer.class),
		@Result(property="osTime",column="os_time",javaType=Long.class),
		@Result(property="osCost",column="os_cost",javaType=Double.class),
		@Result(property="businessYear",column="business_year",javaType=String.class),
		@Result(property="businessMonth",column="business_month",javaType=String.class),
		@Result(property="userInfo",column="fk_user_id",javaType=UserInfoBean.class,
        one=@One(select="org.telecom.billingservice.usermag.mapper.AccountQueryMapper.findUserInfoBeanById",fetchType=FetchType.EAGER))
	})
	@SelectProvider(type=BillMonthSqlProvider.class,method="listByMonthBill")
	List<BillMonthBean> listByMonthBill(@Param("params")Map params,@Param("pager")PagerBean pager);
}
