package org.telecom.billingservice.authoritymag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.authoritymag.mapper.RoleMapper;
import org.telecom.billingservice.authoritymag.querydao.IRoleQueryDao;
import org.telecom.billingservice.bean.RoleInfoBean;
/**
 * 角色持久实现类
 * @author wzc
 *
 */
@Repository
public class RoleQueryDaoImpl implements IRoleQueryDao{
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public int countRoleInfoByParams(Map params) {
		// TODO Auto-generated method stub
		return roleMapper.countRoleInfoByParams(params);
	}

	@Override
	public List<RoleInfoBean> listRoleInfoByParams(Map params) {
		// TODO Auto-generated method stub
		return roleMapper.listRoleInfoByParams(params);
	}

	@Override
	public RoleInfoBean findRoleInfoBeanById(long id) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleInfoBeanById(id);
	}

}
