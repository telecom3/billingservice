package org.telecom.billingservice.accountmag.queryservice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层日账务查询接口
 * @author Deng
 *
 */
public interface IAccountDayQueryService {
	/**
	 * 日账务分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	PagerBean listAccountDayBeanBy2Params(PagerBean page,Map<String,Object> params);
}
