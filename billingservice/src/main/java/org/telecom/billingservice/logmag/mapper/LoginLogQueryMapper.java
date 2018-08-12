package org.telecom.billingservice.logmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.LoginInfoBean;

/**
 * 登录日志数据库映射类
 * @author liuyangliang
 *
 */
public interface LoginLogQueryMapper {
	/**
	 * 查询登录日志集合
	 * @param params 查询条件
	 * @return 登陆日志集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="loginName", column="login_name",javaType=String.class),
		@Result(property="loginExitTime", column="login_exit_time",javaType=Date.class),
		@Result(property="loginType", column="login_type",javaType=int.class),
		@Result(property="loginIp", column="login_ip",javaType=String.class),
		@Result(property="loginExit", column="login_exit",javaType=int.class)
	})
	@SelectProvider(type=LoginLogQueryMapperSqlProvider.class,method="listLoginInfoBeanBy2Params")
	List<LoginInfoBean> listLoginInfoBeanBy2Params(@Param("params")Map<String,Object> params);
	
	/**
	 * 查询登录日志条数
	 * @param params 查询条件
	 * @return 条数
	 */
	@SelectProvider(type=LoginLogQueryMapperSqlProvider.class,method="countLoginInfoBeanBy2Params")
	int countLoginInfoBeanBy2Params(@Param("params")Map<String,Object> params);
}
