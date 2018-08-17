package org.telecom.billingservice.usermag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.usermag.mapper.BusinessQueryMapper;
import org.telecom.billingservice.usermag.querydao.IBusinessQueryDao;

/**
 * 持久层业务账号 查询接口实现
 * @author wzc
 *
 */
@Repository
public class BusinessQueryDaoImpl implements IBusinessQueryDao{
	@Resource
	private BusinessQueryMapper businessQueryMapper;
	
	@Override
	public BusinessInfoBean findBusinessInfoBeanById(Long businessInfoId) {
		// TODO Auto-generated method stub
		return businessQueryMapper.findBusinessInfoBeanById(businessInfoId);
	}

	@Override
	public int countBusinessInfoBeanByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return businessQueryMapper.countBusinessInfoBeanByParams(params);
	}

	@Override
	public List<BusinessInfoBean> listBusinessInfoBeanByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return businessQueryMapper.listBusinessInfoBeanByParams(params);
	}

}
