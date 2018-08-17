package org.telecom.billingservice.billmag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层业务月计费查询接口
 * @author Deng
 *
 */
public interface IBusinessMonthQueryService {
	/**
	 * 账务账号下所有业务账号当月发生的费用明细信息分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	PagerBean listBusinessMonthBeanBy2Params(PagerBean page,Map<String,Object> params);
}
