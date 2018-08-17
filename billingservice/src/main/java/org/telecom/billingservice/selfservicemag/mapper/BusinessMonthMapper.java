package org.telecom.billingservice.selfservicemag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.BusinessMonthBean;

public interface BusinessMonthMapper {
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
		@Result(property="businessMonrth", column="business_monrth",javaType=String.class),
		@Result(property="businessYear", column="business_year",javaType=String.class),
		@Result(property="tariffName", column="tariff_name",javaType=String.class),
	})
	@SelectProvider(type=BusinessMonthMapperSqlProvider.class,method="listBusinessMonthBeanBy2Params")
	List<BusinessMonthBean> listBusinessMonthBeanBy2Params(@Param("params")Map<String,Object> params);
	/**
	 * 日账单分页统计方法
	 * @param params 查询条件
	 * @return 统计的条数
	 */
	@SelectProvider(type=BusinessMonthMapperSqlProvider.class,method="countBusinessMonthByParams")
	int countBusinessMonthByParams(@Param("params")Map params);
}
