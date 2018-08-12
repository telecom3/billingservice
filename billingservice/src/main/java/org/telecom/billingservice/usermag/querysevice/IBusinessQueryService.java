package org.telecom.billingservice.usermag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层业务账号 查询接口
 * @author Deng
 *
 */
public interface IBusinessQueryService {
	/**
	 * 根据业务账号得id查找业务账号信息
	 * @param businessInfoId 业务账号id
	 * @return  业务账号实体Bean
	 */
BusinessInfoBean findBusinessInfoBeanById(Long businessInfoId);
/**
 * 分页查询业务账号
 * @param page 分页实体
 * @param params 动态条件参数
 * @return  分页实体
 */
PagerBean listBusinessInfoBeanBy2Params(PagerBean page,Map<String,Object> params);
}
