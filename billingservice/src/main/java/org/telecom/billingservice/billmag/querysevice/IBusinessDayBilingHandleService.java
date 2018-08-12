package org.telecom.billingservice.billmag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层业务日计费查询接口
 * @author Deng
 *
 */
public interface IBusinessDayBilingHandleService {
	/**
	 * 账务账号下单个业务账号每日发生的费用明细信息分页
	 * @param page   分页实体
	 * @param params  动态条件参数
	 * @return  分页
	 */
	PagerBean listBusinessDayBeanBy2Params(PagerBean page,Map<String,Object> params);
}
