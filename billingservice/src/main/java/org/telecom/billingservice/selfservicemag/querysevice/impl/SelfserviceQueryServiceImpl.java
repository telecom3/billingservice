package org.telecom.billingservice.selfservicemag.querysevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.selfservicemag.querydao.ISelfserviceQueryDao;
import org.telecom.billingservice.selfservicemag.querysevice.ISelfserviceQueryService;

/**
 * 业务层用户自服务查询接口实现类
 * @author 李博
 *
 */
@Service
public class SelfserviceQueryServiceImpl implements ISelfserviceQueryService{
    @Resource
	private ISelfserviceQueryDao selfserviceQueryDaoImpl;
	@Override
	public UserInfoBean findUserInfoBeanById(Long userInfoId) {
		// TODO Auto-generated method stub
		return selfserviceQueryDaoImpl.findUserInfoBeanById(userInfoId);
	}
	@Override
	public PagerBean listBillMonthBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		int totalRows=selfserviceQueryDaoImpl.countBillMonthByParams(params);
		if(totalRows > 0) {
			params.put("index", page.getIndex());
			params.put("rows", page.getLimit());
			//分页数据查询
			List<BillMonthBean> datas = selfserviceQueryDaoImpl.listBillMonthBeanBy2Params(page, params);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}
	@Override
	public PagerBean listBusinessMonthBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		int totalRows=selfserviceQueryDaoImpl.countBillMonthByParams(params);
		if(totalRows > 0) {
			params.put("index", page.getIndex());
			params.put("rows", page.getLimit());
			//分页数据查询
			List<BusinessMonthBean> datas = selfserviceQueryDaoImpl.listBusinessMonthBeanBy2Params(page, params);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}
	@Override
	public PagerBean listBusinessDayBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		int totalRows=selfserviceQueryDaoImpl.countBusinessDayByParams(params);
		if(totalRows > 0) {
			params.put("index", page.getIndex());
			params.put("rows", page.getLimit());
			//分页数据查询
			List<BusinessDayBean> datas = selfserviceQueryDaoImpl.listBusinessDayBeanBy2Params(page, params);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

	
}
