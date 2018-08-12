package org.telecom.billingservice.logmag.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.telecom.billingservice.bean.DataInfoBean;

/**
 * 操作数据数据库映射类
 * @author liuyangliang
 *
 */
public interface DataQueryMapper {
	/**
	 * 根据操作数据id查询操作数据对象
	 * @param id 操作数据id
	 * @return 操作数据对象
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="dataInfo", column="data_info",javaType=String.class)
	})
	@Select("select id,data_info from t_data_info where id=#{id}")
	DataInfoBean getDataInfoBeanById(@Param("id")long id);
}
