package org.telecom.billingservice.billmag.handleservice;

import org.telecom.billingservice.annotation.MyLog;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.enmu.OperateLogEnum;

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
	@MyLog(menuName=3,operateType=OperateLogEnum.UPDATE)
	void updateBillMonthBean(BillMonthBean billMonth);
}
