package org.telecom.billingservice.billmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.AccountMonthBean;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.billmag.dao.IBillDao;
import org.telecom.billingservice.billmag.mapper.BillMapper;
import org.telecom.billingservice.billmag.mapper.BusinessMapper;

@Repository
public class BillDaoImpl implements IBillDao {

	@Resource
	private BusinessMapper businessMapper;
	@Resource
	private BillMapper billMapper;
//	@Resource
//	private BillMapper billMapper;
	
	@DataSource(value = "read")
	public int countBusiness(Map params) {
		// TODO Auto-generated method stub
		int i=businessMapper.countBusiness(params);
		return i;
	}
	@DataSource(value = "read")
	@Override
	public PagerBean listByBusiness(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		List<BusinessMonthBean>list=businessMapper.listByBusiness(params, pager);
		int num=this.countBusiness(params);
		pager.setData(list);
		pager.setCount(num);
		
		return pager;
	}

	@Override
	public Map<String, Object> findUserAndBusyiness(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> fnidAccountAndBusyiness(Long busynessrId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessMonthBean findBusinessMonthBean() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@DataSource(value = "read")
	@Override
	public int countMonthBill(Map params) {
		// TODO Auto-generated method stub
		int i=billMapper.countMonthBill(params);
		return i;
	}
	@DataSource(value = "read")
	@Override
	public PagerBean ListByMonthBill(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		List<BillMonthBean> list=billMapper.listByMonthBill(params, pager);
		pager.setCount(this.countMonthBill(params));
		pager.setData(list);
		return pager;
	}

	
	
}
