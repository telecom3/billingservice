package org.telecom.billingservice.accountmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.AccountDayBean;

/**
 * 日账务数据库映射类
 * @author liuyangliang
 *
 */
public interface AccountDayQueryMapper {

	/**
	 * 日账务分页数据
	 * @param page 分页bean
	 * @param params 分页条件
	 * @return 日账务分页数据集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="userName", column="user_name",javaType=String.class),
		@Result(property="osName", column="os_name",javaType=String.class),
		@Result(property="serviceIp", column="service_ip",javaType=String.class),
		@Result(property="accountYear", column="account_year",javaType=String.class),
		@Result(property="accountMonth", column="account_month",javaType=String.class),
		@Result(property="accountDay", column="account_day",javaType=String.class),
		@Result(property="countTime", column="count_time",javaType=long.class)
	})
	@SelectProvider(type=AccountDayQueryMapperSqlProvider.class,method="listAccountDayBeanBy2Params")
	List<AccountDayBean> listAccountDayBeanBy2Params(@Param("params")Map<String,Object> params);
	
	/**
	 * 日账务分页数据总条数
	 * @param params 分页条件
	 * @return 日账务分页数据总条数
	 */
	@SelectProvider(type=AccountDayQueryMapperSqlProvider.class,method="countAccountDayBeanBy2Params")
	int countAccountDayBeanBy2Params(@Param("params")Map<String,Object> params);
}
