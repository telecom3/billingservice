package org.telecom.billingservice.administratormag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.administratormag.mapper.AdministratorMapper;
import org.telecom.billingservice.administratormag.querydao.IAdministratorQueryDao;
import org.telecom.billingservice.bean.UserInfoBean;
@Repository
public class AdministratorQueryDaoImpl implements IAdministratorQueryDao {
	@Resource
	private AdministratorMapper administratorMapper;
	@SuppressWarnings("rawtypes")
	@Override
	public int countAdministratorByParams(Map params) {
		return administratorMapper.countAdministratorByParams(params);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<UserInfoBean> listAdministratorByParams( Map params) {
		return administratorMapper.listAdministratorByParams(params);
	}

	@Override
	public UserInfoBean findUserInfoBeanById(Long id) {
		return administratorMapper.findUserInfoBeanById(id);
	}


}
