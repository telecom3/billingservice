package org.telecom.billingservice.statementmag.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.billmag.mapper.BillMapper;
import org.telecom.billingservice.statementmag.dao.IReportDao;
import org.telecom.billingservice.statementmag.mapper.ReportMapper;

@Repository
public  class ReportDaoImpl implements IReportDao {

	@Resource
	private ReportMapper reportMapper;
	

	@Override
	public List<BusinessMonthBean> findBusinessMonths(String username,String year) {
		// TODO Auto-generated method stub
		
		return reportMapper.getBunsinessCost(username,year);
	}


	@Override
	public List<BillMonthBean> findUserMonths(Long id, String businessYear) {
		// TODO Auto-generated method stub
		
		return reportMapper.findUserMonths(id, businessYear);
	}



}
