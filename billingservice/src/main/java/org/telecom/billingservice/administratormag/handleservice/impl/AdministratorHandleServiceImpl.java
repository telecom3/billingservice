package org.telecom.billingservice.administratormag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.administratormag.handledao.IAdministraorHandleDao;
import org.telecom.billingservice.administratormag.handleservice.IAdministratorHandleService;
import org.telecom.billingservice.annotation.MyLog;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.enmu.OperateLogEnum;
@Service
public class AdministratorHandleServiceImpl implements IAdministratorHandleService {
	@Resource
	private IAdministraorHandleDao administraorHandleDaoImpl;
	@Override
	@MyLog(menuName=2,operateType=OperateLogEnum.SAVE)
	public void saveAdministrator(UserInfoBean user) {
		administraorHandleDaoImpl.save(user);
	}

	@Override
	@MyLog(menuName=2,operateType=OperateLogEnum.UPDATE)
	public void updateAdministrator(UserInfoBean user) {
		administraorHandleDaoImpl.saveAndFlush(user);
	}

	@Override
	@MyLog(menuName=2,operateType=OperateLogEnum.DELETE)
	public void deleteAdministrator(Long userId) {
		administraorHandleDaoImpl.delete(userId);
	}
}
