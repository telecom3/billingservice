package org.telecom.billingservice.billmag.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;


public interface IBillDao {
    
	
	
	/**
	 * 点击费用信息，查找账务用户下的所有业务账号的明细
	 * @param userId
	 * @return
	 */
	Map<String,Object> findUserAndBusyiness(Long userId);
	
	/**
	 * 点击业务账号资费查询每个业务账号的资费明细
	 * @param userId
	 * @return
	 */
	Map<String,Object> fnidAccountAndBusyiness(Long busynessrId);
	
	/**
	 * 
	 * 查询月表的数量
	 * @param params
	 * @return
	 */
	int countBusiness(@Param("params") Map params);
	/**
	 * 分页来查询月表
	 * @param params
	 * @param pager
	 * @return
	 */
	PagerBean listByBusiness(@Param("params") Map params,@Param("pager") PagerBean pager);
	
	BusinessMonthBean findBusinessMonthBean();
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	int countMonthBill(@Param("param")Map params);
	
	/**
	 * 
	 * @param params
	 * @param pager
	 * @return
	 */
	PagerBean ListByMonthBill(@Param("params")Map params,@Param("pager")PagerBean pager);
}
