package org.telecom.billingservice.statementmag.dao;

import java.util.List;

import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.BusinessMonthBean;

public interface IReportDao {
      
	   List<BusinessMonthBean> findBusinessMonths(String username,String year);
	
	   
	   List<BillMonthBean>  findUserMonths(Long id,String year);
	   
}