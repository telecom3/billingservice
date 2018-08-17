package org.telecom.billingservice.usermag.handleservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.MyLog;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.enmu.OperateLogEnum;
import org.telecom.billingservice.usermag.handledao.IAccountHandleDao;
import org.telecom.billingservice.usermag.handleservice.IAccountHandleService;
import org.telecom.billingservice.util.JAXBTools;
import org.telecom.billingservice.util.SendMessage;

/**
 * 业务层账务账号处理接口实现
 * 
 * @author wzc
 *
 */
@Service
public class AccountHandleServiceImpl implements IAccountHandleService {
	@Resource
	private SendMessage sendMessage;

	@Resource(name = "queue2Destination")
	private ActiveMQDestination queue2Destination;
	@Resource
	private IAccountHandleDao accountHandleDaoImpl;

	@Override
	@MyLog(menuName = 0, operateType = OperateLogEnum.SAVE)
	public void saveUserInfoBean(UserInfoBean user) {
		// TODO Auto-generated method stub
		accountHandleDaoImpl.save(user);
	}

	@Override
	@MyLog(menuName = 0, operateType = OperateLogEnum.UPDATE)
	public void updateUserInfoBean(UserInfoBean user) {
		// TODO Auto-generated method stub
		accountHandleDaoImpl.saveAndFlush(user);
	}

	@Override
	@MyLog(menuName = 0, operateType = OperateLogEnum.DELETE)
	public void deleteUserInfoBeanById(Long userId) {
		// TODO Auto-generated method stub
		accountHandleDaoImpl.delete(userId);
	}

	@Override
	public void saveUserInfoBeans(List<UserInfoBean> users) {
		// TODO Auto-generated method stub
		for (UserInfoBean userInfoBean : users) {
			
			try {
				 String xml=JAXBTools.java2Xml(UserInfoBean.class, userInfoBean);
				 sendMessage.sendMessage(queue2Destination, xml);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
	}
	

}
