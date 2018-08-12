package org.telecom.billingservice.selfservicemag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.selfservicemag.mapper.SelfserviceMapper;
import org.telecom.billingservice.selfservicemag.querydao.ISelfserviceQueryDao;
/**
 * 持久层用户自服务查询接口实现类
 * @author 李博
 *
 */
@Repository
public class SelfserviceQueryDaoImpl implements ISelfserviceQueryDao{
    @Resource
	private SelfserviceMapper selfserviceMapper;
	@Override
	public UserInfoBean findUserInfoBeanById(Long userInfoId) {
		// TODO Auto-generated method stub
		return selfserviceMapper.findUserInfoBeanById(userInfoId);
	}
	@Override
	public int countBusinessDayByParams(Map params) {
		// TODO Auto-generated method stub
		return selfserviceMapper.countBusinessDayByParams(params);
	}
	@Override
	public int countBusinessMonthByParams(Map params) {
		// TODO Auto-generated method stub
		return selfserviceMapper.countBusinessMonthByParams(params);
	}
	@Override
	public int countBillMonthByParams(Map params) {
		// TODO Auto-generated method stub
		return selfserviceMapper.countBillMonthByParams(params);
	}
	@Override
	public List<BillMonthBean> listBillMonthBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selfserviceMapper.listBillMonthBeanBy2Params(page, params);
	}
	@Override
	public List<BusinessMonthBean> listBusinessMonthBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selfserviceMapper.listBusinessMonthBeanBy2Params(page, params);
	}
	@Override
	public List<BusinessDayBean> listBusinessDayBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selfserviceMapper.listBusinessDayBeanBy2Params(page, params);
	}



}
