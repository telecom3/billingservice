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
import org.telecom.billingservice.selfservicemag.mapper.BillMonthMapper;
import org.telecom.billingservice.selfservicemag.mapper.BusinessDayMapper;
import org.telecom.billingservice.selfservicemag.mapper.BusinessMonthMapper;
import org.telecom.billingservice.selfservicemag.querydao.ISelfserviceQueryDao;
/**
 * 持久层用户自服务查询接口实现类
 * @author 李博
 *
 */
@Repository
public class SelfserviceQueryDaoImpl implements ISelfserviceQueryDao{

    @Resource
    private BillMonthMapper billMonthMapper;
    @Resource
    private BusinessDayMapper businessDayMapper;
    @Resource
    private BusinessMonthMapper businessMonthMapper;
	@Override
	public UserInfoBean findUserInfoBeanById(Long userInfoId) {
		// TODO Auto-generated method stub
		return billMonthMapper.findUserInfoBeanById(userInfoId);
	}
	@Override
	public int countBusinessDayByParams(Map params) {
		// TODO Auto-generated method stub
		return businessDayMapper.countBusinessDayByParams(params);
	}
	@Override
	public int countBusinessMonthByParams(Map params) {
		// TODO Auto-generated method stub
		return businessMonthMapper.countBusinessMonthByParams(params);
	}
	@Override
	public int countBillMonthByParams(Map params) {
		// TODO Auto-generated method stub
		return billMonthMapper.countBillMonthByParams(params);
	}
	@Override
	public List<BillMonthBean> listBillMonthBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return billMonthMapper.listBillMonthBeanBy2Params(params);
	}
	@Override
	public List<BusinessMonthBean> listBusinessMonthBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return businessMonthMapper.listBusinessMonthBeanBy2Params( params);
	}
	@Override
	public List<BusinessDayBean> listBusinessDayBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return businessDayMapper.listBusinessDayBeanBy2Params(params);
	}



}
