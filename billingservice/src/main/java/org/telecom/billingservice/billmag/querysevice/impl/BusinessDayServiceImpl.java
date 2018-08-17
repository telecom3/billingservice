package org.telecom.billingservice.billmag.querysevice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.billmag.dao.IBusinessDao;
import org.telecom.billingservice.billmag.querysevice.IBusinessDayQueryService;


@Service
public class BusinessDayServiceImpl implements IBusinessDayQueryService {
	
	@Resource
	private IBusinessDao businessDaoImpl;

	@Override
	public PagerBean listBusinessDayBeanBy2Params(PagerBean pager, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return businessDaoImpl.ListByDayBusiness(params, pager);
	}

}
