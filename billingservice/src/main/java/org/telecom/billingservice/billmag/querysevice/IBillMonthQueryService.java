package org.telecom.billingservice.billmag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层月账单查询接口
 * @author Deng
 *
 */
public interface IBillMonthQueryService {
	/**
	 * 月账单分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	PagerBean listBillMonthBeanBy2Params(PagerBean page,Map<String,Object> params);
}
