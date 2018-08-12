package org.telecom.billingservice.billmag.handleservice;

import org.telecom.billingservice.bean.BillMonthBean;

/**
 * 业务层月账单操作接口
 * @author Deng
 *
 */
public interface IBillMonthHandleService {
	/**
	 * 修改账单的支付状态
	 * @param billMonth
	 */
	void updateBillMonthBean(BillMonthBean billMonth);
}
