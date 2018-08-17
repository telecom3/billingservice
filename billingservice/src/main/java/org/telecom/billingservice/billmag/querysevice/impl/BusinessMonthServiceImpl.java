package org.telecom.billingservice.billmag.querysevice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.billmag.dao.IBillDao;
import org.telecom.billingservice.billmag.dao.IBusinessDao;
import org.telecom.billingservice.billmag.dao.impl.BillDaoImpl;
import org.telecom.billingservice.billmag.querysevice.IBusinessDayQueryService;
import org.telecom.billingservice.billmag.querysevice.IBusinessMonthQueryService;

@Service
public class BusinessMonthServiceImpl implements IBusinessMonthQueryService{
    
	@Resource
	private IBillDao billDaoImpl;
	
	
	@Override
	public PagerBean listBusinessMonthBeanBy2Params(PagerBean pager, Map<String, Object> params) {
		// TODO Auto-generated method stub
		
		return billDaoImpl.listByBusiness(params, pager);
		
	}

	
}
