package org.telecom.billingservice.usermag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 持久层业务账号 查询接口
 * @author wzc
 *
 */
public interface IBusinessQueryDao {
	/**
	 * 根据业务账号得id查找业务账号信息
	 * @param businessInfoId 业务账号id
	 * @return  业务账号实体Bean
	 */
BusinessInfoBean findBusinessInfoBeanById(Long businessInfoId);
/**
 * 按多条件统计条数
 * @param params 查询条件
 * @return 数据条数
 */
int countBusinessInfoBeanByParams(Map<String,Object> params);
/**
 * 多条件查询业务账号集合
 * @param params 查询条件
 * @return 业务账号集合
 */
List<BusinessInfoBean> listBusinessInfoBeanByParams(Map<String,Object> params);
}
