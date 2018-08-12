package org.telecom.billingservice.statementmag.querysevice;

import org.telecom.billingservice.bean.ResultMapBean;

/**
 * 业务层数据报表查询接口
 * @author Deng
 *
 */
public interface IStatementService {
	/**
	 * 账务账号饼图数据
	 * @param uerInfoId
	 * @return
	 */
ResultMapBean getDataById(Long userInfoId);
/**
 * 账务账号下，业务账号的折线图数据
 * @param uerInfoId
 * @return
 */
ResultMapBean getImgeById(Long userInfoId,Long buinessId);

}
