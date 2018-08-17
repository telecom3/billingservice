package org.telecom.billingservice.billmag.querysevice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.billmag.dao.IBillDao;
import org.telecom.billingservice.billmag.dao.impl.BillDaoImpl;
import org.telecom.billingservice.billmag.querysevice.IBillMonthQueryService;

@Service
public class BillMonthServiceImpl implements IBillMonthQueryService {

	
	@Resource
	private IBillDao billDaoImpl;
	@Override
	public PagerBean listBillMonthBeanBy2Params(PagerBean pager, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return billDaoImpl.ListByMonthBill(params, pager);
	}

}
