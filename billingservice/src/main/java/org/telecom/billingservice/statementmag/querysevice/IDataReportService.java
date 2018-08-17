package org.telecom.billingservice.statementmag.querysevice;

import java.util.List;

import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessMonthBean;

/**
 * 业务层数据报表查询接口
 * @author Deng
 *
 */
public interface IDataReportService {

	
	 List<BusinessMonthBean> findBusinessMonths(String username,String year);
		
	   
	   List<BillMonthBean>  findUserMonths(Long id,String year);
	   
}
