package org.telecom.billingservice.aspect;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telecom.billingservice.annotation.MyLog;
import org.telecom.billingservice.bean.DataInfoBean;
import org.telecom.billingservice.bean.OperateInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.logmag.handleservice.ISendLogMessageService;

/**
 * 操作日志切面
 * @author liuyangliang
 *
 */
@Aspect
@Component
public class OperateLogAspect{
	@Autowired
	private HttpSession session;
	@Resource
	private ISendLogMessageService sendLogMessageServiceImpl;
	/**
	 * 切入点
	 */
	@Pointcut(value="@annotation(org.telecom.billingservice.annotation.MyLog)")
	public void pointcut() {}
	
	
	@AfterReturning(pointcut="pointcut() && @annotation(mylog)",returning="rev")
	public void afterReturningAdvice(JoinPoint jp,MyLog mylog,Object rev) {
		
		//记录操作日志
		OperateInfoBean log=new OperateInfoBean();
		DataInfoBean dataInfo=new DataInfoBean();
		Object[] args=jp.getArgs();
		dataInfo.setDataInfo(Arrays.toString(args));
		
		//操作人如何获取
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			
			Session session = currentUser.getSession();
			UserInfoBean user=(UserInfoBean) session.getAttribute("userInfo");
			
			log.setOperator(user.getUserName());
			
			log.setOperatorMode(mylog.menuName());
			log.setOperatorTime(new Date());
			log.setOperatorType(mylog.operateType().getType());
			log.setDataInfo(dataInfo);
			
			//将封装好得消息日志扔进ActiveMq
			sendLogMessageServiceImpl.sendOperateMessage(log);
		}
	}
}
