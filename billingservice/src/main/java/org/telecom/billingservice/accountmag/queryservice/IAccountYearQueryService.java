package org.telecom.billingservice.accountmag.queryservice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层年账务查询接口
 * @author Deng
 *
 */
public interface IAccountYearQueryService {
	/**
	 *  年账务分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	PagerBean listAccountYearBeanBy2Params(PagerBean page,Map<String,Object> params);
}
