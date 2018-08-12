package org.telecom.billingservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.telecom.billingservice.annotation.MyLog;

/**
 * 操作日志切面
 * @author liuyangliang
 *
 */
@Aspect
@Component
public class OperateLogAspect{
	
	/**
	 * 切入点
	 */
	@Pointcut(value="@annotation(org.telecom.billingservice.annotation.MyLog)")
	public void pointcut() {}
	
	
	@AfterReturning(pointcut="pointcut() && @annotation(mylog)",returning="rev")
	public void afterReturningAdvice(JoinPoint jp,MyLog mylog,Object rev) {
		
		//记录操作日志
		
	}
}
