package org.telecom.billingservice.authoritymag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.authoritymag.handledao.IRoleHandleDao;
import org.telecom.billingservice.authoritymag.handleservice.IRoleHandleService;
import org.telecom.billingservice.bean.RoleInfoBean;
/**
 * 实现业务层角色处理接口
 * @author wzc
 *
 */
@Service
public class RoleHandleServiceImpl implements IRoleHandleService{
	@Resource
	private IRoleHandleDao roleHandleDaoImpl;
	@DataSource(value = "write")
	@Override
	public void saveRoleInfoBean(RoleInfoBean roleInfo) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.save(roleInfo);
	}
	@DataSource(value = "write")
	@Override
	public void updateRoleInfoBean(RoleInfoBean roleInfo) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.saveAndFlush(roleInfo);
	}
	@DataSource(value = "write")
	@Override
	public void deleteRoleInfoBeanById(Long roleInfoId) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.delete(roleInfoId);
	}

}
