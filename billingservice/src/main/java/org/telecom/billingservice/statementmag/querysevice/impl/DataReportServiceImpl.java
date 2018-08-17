package org.telecom.billingservice.statementmag.querysevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.statementmag.dao.IReportDao;
import org.telecom.billingservice.statementmag.querysevice.IDataReportService;

@Service
public class DataReportServiceImpl implements IDataReportService {

	@Resource
	private IReportDao reportDaoImpl;
	@Override
	public List<BusinessMonthBean> findBusinessMonths(String username,String year) {
		// TODO Auto-generated method stub
		return reportDaoImpl.findBusinessMonths(username, year);
	}

	@Override
	public List<BillMonthBean> findUserMonths(Long id, String year) {
		// TODO Auto-generated method stub
		return reportDaoImpl.findUserMonths(id, year);
		
	}
	}
