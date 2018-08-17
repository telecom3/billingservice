package org.telecom.billingservice.usermag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.usermag.handledao.IBusinessHandleDao;
import org.telecom.billingservice.usermag.handleservice.IBusinessHandleService;

/**
 * 业务层业务账号处理接口实现
 * @author wzc
 *
 */
@Service
public class BusinessHandleServiceImpl implements IBusinessHandleService{
	
	@Resource
	private IBusinessHandleDao businessHandleDaoImpl;
	@Override
	public void saveBusinessInfoBean(BusinessInfoBean businessInfo) {
		// TODO Auto-generated method stub
		businessHandleDaoImpl.save(businessInfo);
	}

	@Override
	public void updateBusinessInfoBean(BusinessInfoBean businessInfo) {
		// TODO Auto-generated method stub
		businessHandleDaoImpl.saveAndFlush(businessInfo);
	}

	@Override
	public void deleteBusinessInfoBeanById(Long businessInfoId) {
		// TODO Auto-generated method stub
		businessHandleDaoImpl.delete(businessInfoId);
	}

}
