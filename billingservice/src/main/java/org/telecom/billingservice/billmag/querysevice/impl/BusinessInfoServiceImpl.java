package org.telecom.billingservice.billmag.querysevice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.billmag.dao.IBusinessDao;
import org.telecom.billingservice.billmag.querysevice.IBusinessInfoService;

@Service
public class BusinessInfoServiceImpl implements IBusinessInfoService {

    @Resource
    private IBusinessDao IBusinessDaoImpl;
	
	@Override
	public BusinessInfoBean getBusinessInfoBean(String osName) {
		// TODO Auto-generated method stub
		return IBusinessDaoImpl.findOS(osName);
	}

}
