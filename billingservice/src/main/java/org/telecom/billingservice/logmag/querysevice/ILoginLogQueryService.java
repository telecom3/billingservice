package org.telecom.billingservice.logmag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层登录日志查询接口
 * @author Deng
 *
 */
public interface ILoginLogQueryService {
	/**
	 * 分页查询登录日志
	 * @param page 分页实体
	 * @param params 动态条件参数
	 * @return  分页实体
	 */
	PagerBean listLoginInfoBeanBy2Params(PagerBean page,Map<String,Object> params);
}
