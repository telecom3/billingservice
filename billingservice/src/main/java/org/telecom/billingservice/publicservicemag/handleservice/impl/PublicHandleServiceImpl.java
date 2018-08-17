package org.telecom.billingservice.publicservicemag.handleservice.impl;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.MyLog;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.enmu.OperateLogEnum;
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
	@MyLog(menuName=8,operateType=OperateLogEnum.UPDATE)
	public void updateUserPassword(UserInfoBean user) {
		// TODO Auto-generated method stub
		Object result = new SimpleHash("MD5", user.getUserPwd(), ByteSource.Util.bytes(user.getUserName()), 1024);
		user.setUserPwd(result.toString());
		publicHandleDaoImpl.saveAndFlush(user);
	}

}
