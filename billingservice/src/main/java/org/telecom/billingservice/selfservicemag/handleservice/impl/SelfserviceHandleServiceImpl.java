package org.telecom.billingservice.selfservicemag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.selfservicemag.handledao.ISelfserviceHandleDao;
import org.telecom.billingservice.selfservicemag.handleservice.ISelfserviceHandleService;
/**
 * 业务层用户自服务处理接口实现类
 * @author 李博
 *
 */
@Service
public class SelfserviceHandleServiceImpl implements ISelfserviceHandleService{
    @Resource
	private ISelfserviceHandleDao selfserviceHandleDaoImpl;
    @DataSource(value="write")
	@Override
	public void updateSelfInfo(UserInfoBean userInfo) {
		// TODO Auto-generated method stub
		selfserviceHandleDaoImpl.saveAndFlush(userInfo);
	}

}
