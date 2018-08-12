package org.telecom.billingservice.logmag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层操作日志查询接口
 * @author Deng
 *
 */
public interface IOperateLogQueryService {
	/**
	 * 分页查询操作日志
	 * @param page 分页实体
	 * @param params 动态条件参数
	 * @return  分页实体
	 */
	PagerBean listOperateInfoBeanBy2Params(PagerBean page,Map<String,Object> params);
}
