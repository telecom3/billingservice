package org.telecom.billingservice.billmag.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.PagerBean;

public interface IBusinessDao {
	/**
	 * 查询日表的数量
	 * @param params
	 * @return
	 */
	int countDayBusiness(@Param("params")Map params);
	/**
	 * 
	 * @param params
	 * @param pager
	 * @return
	 */
	PagerBean ListByDayBusiness(@Param("params")Map params,@Param("pager")PagerBean pager);
	
	/**
	 * 
	 * @param osName
	 * @return
	 */
	BusinessInfoBean findOS(String osName);
	
	
}
