package org.telecom.billingservice.tariffmag.mapper;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.TariffInfoBean;


/**
 * 资费分页查询mabatis类
 * @author asus
 *
 */
public interface TarffQueryMapper {
	
	/**
	 * 资费分页数据
	 * @param page 分页bean
	 * @param params 分页条件
	 * @return 资费分页数据集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="tariffState", column="tariff_state",javaType=Integer.class),
		@Result(property="tariffName", column="tariff_name",javaType=String.class),
		@Result(property="tariffType", column="tariff_type",javaType=Integer.class),
		@Result(property="baseTime", column="base_time",javaType=Long.class),
		@Result(property="baseCost", column="base_cost",javaType=Double.class),
		@Result(property="unitCost", column="unit_cost",javaType=Double.class),
		@Result(property="costDescrible", column="cost_describle",javaType=String.class),
		@Result(property="stratTime", column="strat_time",javaType=Date.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),	
	})
	@SelectProvider(type=TarffQueryMapperSqlProvicer.class,method="listAccountMonthBeanBy2Params")
	List<TariffInfoBean> listAccountMonthBeanBy2Params(@Param("params")Map<String, Object> params);

	/**
	 * 资费分页数据总条数
	 * @param params 分页条件
	 * @return 资费分页数据总条数
	 */
	@SelectProvider(type=TarffQueryMapperSqlProvicer.class,method="countAccountMonthBeanBy2Params")
	int countAccountMonthBeanBy2Params(@Param("params")Map<String, Object> params);
	
	

	/**
	 * emmm
	 * @param tarInfoId
	 * @return
	 */
	@ResultType(TariffInfoBean.class)
	@Select("select id as id,tariff_state as tariffState,tariff_name as tariffName,tariff_type as tariffType,base_time as baseTime,base_cost as baseCost,unit_cost as unitCost,cost_describle as costDescrible,version as version from t_tariff_info where id=#{id}")
	TariffInfoBean findTarInfoBeanById(@Param("id")Long tarInfoId);
	
	/**
	 * 查找全部
	 * @return
	 */
	@Select("select id as id,tariff_state as tariffState,tariff_name as tariffName,tariff_type as tariffType,base_time as baseTime,base_cost as baseCost,unit_cost as unitCost,cost_describle as costDescrible,version as version from t_tariff_info ")
	List<TariffInfoBean> listTarInfoBeanfindAll();

	

}
