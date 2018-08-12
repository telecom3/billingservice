package org.telecom.billingservice.publicservicemag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.publicservicemag.handledao.IPublicHandleDao;
import org.telecom.billingservice.publicservicemag.handleservice.IPublicHandleService;
/**
 * 业务层公共服务处理接口实现类
 * @author 李博
 *
 */
@Service
public class PublicHandleServiceImpl implements IPublicHandleService{
    @Resource
	private IPublicHandleDao publicHandleDaoImpl;
	@Override
	public void updateUserPassword(UserInfoBean userInfo) {
		// TODO Auto-generated method stub
		publicHandleDaoImpl.saveAndFlush(userInfo);
	}

}
