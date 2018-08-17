package org.telecom.billingservice.logmag.handleservice;

import org.telecom.billingservice.bean.LoginInfoBean;
import org.telecom.billingservice.bean.OperateInfoBean;

/**
 * 发送操作日志接口
 * @author Deng
 *
 */
public interface ISendLogMessageService {
	/**
	 *  向active mq 发送登录日志
	 */
void sendLoginMessage(LoginInfoBean loginInfo);
 /**
  * 向active mq 发送操作日志
  */
void sendOperateMessage(OperateInfoBean operateInfo);
}
