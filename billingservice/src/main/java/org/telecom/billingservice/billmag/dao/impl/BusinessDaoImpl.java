package org.telecom.billingservice.billmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.billmag.dao.IBusinessDao;
import org.telecom.billingservice.billmag.mapper.BusinessMapper;

@Repository
public class BusinessDaoImpl implements IBusinessDao {
	
	   @Resource
	    private BusinessMapper businessMapper;
	
		@DataSource(value = "read")
		@Override
		public int countDayBusiness(Map params) {
			// TODO Auto-generated method stub
			return businessMapper.countDayBusiness(params);
		}
		@DataSource(value = "read")
		@Override
		public PagerBean ListByDayBusiness(Map params, PagerBean pager) {
			// TODO Auto-generated method stub
			List<BusinessDayBean> list= businessMapper.ListByDayBusiness(params, pager);
			int num=this.countDayBusiness(params);
			pager.setData(list);
			pager.setCount(num);
			return pager;
		}
		@Override
		public BusinessInfoBean findOS(String osName) {
			// TODO Auto-generated method stub
			return businessMapper.findOS(osName);
		}
}
