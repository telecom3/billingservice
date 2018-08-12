package org.telecom.billingservice.usermag.querysevice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.usermag.querydao.IAccountQueryDao;
import org.telecom.billingservice.usermag.querysevice.IAccountQueryService;

/**
 * 业务层账务账号查询接口实现类
 * @author wzc
 *
 */
@Service
public class AccountQueryServiceImpl implements IAccountQueryService{
	@Resource
	private IAccountQueryDao accountQueryDaoImpl;
	@Override
	public UserInfoBean findUserInfoBeanById(Long userId) {
		// TODO Auto-generated method stub
		return accountQueryDaoImpl.findUserInfoBeanById(userId);
	}

	@Override
	public PagerBean listUserInfoBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
