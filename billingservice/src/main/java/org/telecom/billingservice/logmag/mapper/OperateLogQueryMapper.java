package org.telecom.billingservice.logmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.OperateInfoBean;

/**
 * 操作日志数据库映射类
 * @author liuyangliang
 *
 */
public interface OperateLogQueryMapper {
	/**
	 * 查询操作日志集合
	 * @param params 查询条件
	 * @return 操作日志集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="operator", column="operator",javaType=String.class),
		@Result(property="operatorTime", column="operator_time",javaType=Date.class),
		@Result(property="operatorMode", column="operator_mode",javaType=int.class),
		@Result(property="operatorType", column="operator_type",javaType=int.class),
		@Result(property="dataInfo", column="fk_data_id",one=@One(select="org.telecom.billingservice.logmag.mapper.DataQueryMapper.getDataInfoBeanById"))
	})
	@SelectProvider(type=OperateLogQueryMapperSqlProvider.class,method="listOperateInfoBeanBy2Params")
	List<OperateInfoBean> listOperateInfoBeanBy2Params(@Param("params")Map<String,Object> params);
	
	/**
	 * 查询操作日志条数
	 * @param params 查询条件
	 * @return 条数
	 */
	@SelectProvider(type=OperateLogQueryMapperSqlProvider.class,method="countOperateInfoBeanBy2Params")
	int countOperateInfoBeanBy2Params(@Param("params")Map<String,Object> params);
}
