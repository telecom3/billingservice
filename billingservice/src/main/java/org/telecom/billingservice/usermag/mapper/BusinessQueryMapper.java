package org.telecom.billingservice.usermag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务账号查询接口映射
 * 
 * @author wzc
 *
 */
public interface BusinessQueryMapper {
	/**
	 * 根据业务账号得id查找业务账号信息
	 * 
	 * @param businessInfoId
	 *            业务账号id
	 * @return 业务账号实体Bean
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="businessOs", column="business_os",javaType=String.class),
		@Result(property="businessOsPwd", column="business_os_pwd",javaType=String.class),
		@Result(property="ipAdress", column="IP_adress",javaType=String.class),
		@Result(property="businessState", column="business_state",javaType=int.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),
		@Result(property="version", column="version",javaType=int.class),
		@Result(property="userInfo", column="fk_account_id",one=@One(select="org.telecom.billingservice.usermag.mapper.AccountQueryMapper.findUserInfoBeanById")),
		@Result(property="tariffInfo", column="fk_tariff_id",one=@One(select="org.telecom.billingservice.tariffmag.mapper.TarffQueryMapper.findTarInfoBeanById"))
	})
	@Select(value = { "select id,business_os,business_os_pwd,IP_adress,business_state,fk_account_id,fk_tariff_id,create_time,update_time,version from t_business_info where id=#{id} " })
	BusinessInfoBean findBusinessInfoBeanById(@Param("id")Long businessInfoId);

	/**
	 * 按多条件统计条数
	 * 
	 * @param params
	 *            查询条件
	 * @return 数据条数
	 */
	@SelectProvider(method = "countBusinessInfoBeanByParams", type = BusinessMapperSqlProvider.class)
	int countBusinessInfoBeanByParams(@Param("params")Map<String, Object> params);

	/**
	 * 多条件查询业务账号集合
	 * 
	 * @param params
	 *            查询条件
	 * @return 业务账号集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="businessOs", column="business_os",javaType=String.class),
		@Result(property="businessOsPwd", column="business_os_pwd",javaType=String.class),
		@Result(property="ipAdress", column="IP_adress",javaType=String.class),
		@Result(property="businessState", column="business_state",javaType=int.class),
		@Result(property="createTime", column="create_time",javaType=Date.class),
		@Result(property="updateTime", column="update_time",javaType=Date.class),
		@Result(property="version", column="version",javaType=int.class),
		@Result(property="userInfo", column="fk_account_id",one=@One(select="org.telecom.billingservice.usermag.mapper.AccountQueryMapper.findUserInfoBeanById")),
		@Result(property="tariffInfo", column="fk_tariff_id",one=@One(select="org.telecom.billingservice.tariffmag.mapper.TarffQueryMapper.findTarInfoBeanById"))
	})
	@SelectProvider(method = "listBusinessInfoBeanByParams", type = BusinessMapperSqlProvider.class)
	List<BusinessInfoBean> listBusinessInfoBeanByParams(@Param("params")Map<String, Object> params);
}
