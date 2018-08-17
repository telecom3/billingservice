package org.telecom.billingservice.usermag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.usermag.mapper.AccountQueryMapper;
import org.telecom.billingservice.usermag.querydao.IAccountQueryDao;

/**
 * 持久层账务账号查询接口实现类
 * @author wzc
 *
 */
@Repository
public class AccountQueryDaoImpl implements IAccountQueryDao{
	@Resource
	private AccountQueryMapper accountQueryMapper;
	@Override
	public UserInfoBean findUserInfoBeanById(Long userId) {
		// TODO Auto-generated method stub
		return accountQueryMapper.findUserInfoBeanById(userId);
	}
	@Override
	public int countUserInfoByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountQueryMapper.countUserInfoByParams(params);
	}
	@Override
	public List<UserInfoBean> listUserInfoByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountQueryMapper.listUserInfoByParams(params);
	}

}
