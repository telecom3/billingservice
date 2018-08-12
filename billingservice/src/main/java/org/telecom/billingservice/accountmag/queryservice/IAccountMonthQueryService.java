package org.telecom.billingservice.accountmag.queryservice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层月账务查询接口
 * @author Deng
 *
 */
public interface IAccountMonthQueryService {
	/**
	 * 月账务分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	PagerBean listAccountMonthBeanBy2Params(PagerBean page,Map<String,Object> params);
}
