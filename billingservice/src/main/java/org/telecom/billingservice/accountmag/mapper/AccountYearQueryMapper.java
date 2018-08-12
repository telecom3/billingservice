package org.telecom.billingservice.accountmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.telecom.billingservice.bean.AccountYearBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 年账务数据库映射类
 * @author liuyangliang
 *
 */
public interface AccountYearQueryMapper {
	/**
	 * 月账务分页数据
	 * @param page 分页bean
	 * @param params 分页条件
	 * @return 月账务分页数据集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="osName", column="os_name",javaType=String.class),
		@Result(property="serviceIp", column="service_ip",javaType=String.class),
		@Result(property="accountYear", column="account_year",javaType=String.class),
		@Result(property="countTime", column="count_time",javaType=long.class),
		@Result(property="userInfo", column="fk_user_id",one=@One(select="org.telecom.billingservice.usermag.mapper.AccountQueryMapper.findUserInfoBeanById"))
	})
	@SelectProvider(type=AccountYearQueryMapperSqlProvider.class,method="listAccountYearBeanBy2Params")
	List<AccountYearBean> listAccountYearBeanBy2Params(@Param("params")Map<String, Object> params);

	/**
	 * 月账务分页数据总条数
	 * @param params 分页条件
	 * @return 月账务分页数据总条数
	 */
	@SelectProvider(type=AccountYearQueryMapperSqlProvider.class,method="countAccountYearBeanBy2Params")
	int countAccountYearBeanBy2Params(@Param("params")Map<String, Object> params);
}
