package org.telecom.billingservice.logmag.handleservice.impl;

import javax.annotation.Resource;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.LoginInfoBean;
import org.telecom.billingservice.bean.OperateInfoBean;
import org.telecom.billingservice.logmag.handleservice.ISendLogMessageService;
import org.telecom.billingservice.util.JAXBTools;
import org.telecom.billingservice.util.SendMessage;

@Service
public class SendLogMessageServiceImpl implements ISendLogMessageService{
    @Resource
	private SendMessage sendMessage;
	
	@Resource(name="queue1Destination")
	private ActiveMQDestination queue1Destination;
	
	@Resource(name="queueDestination")
	private ActiveMQDestination queueDestination;
	
	@Override
	public void sendLoginMessage(LoginInfoBean loginInfo) {
		// TODO Auto-generated method stub
		try {
			 String xml=JAXBTools.java2Xml(LoginInfoBean.class, loginInfo);
			 sendMessage.sendMessage(queue1Destination, xml);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void sendOperateMessage(OperateInfoBean operateInfo) {
		// TODO Auto-generated method stub
		try {
			//数据向queue://message中传输
		    String xml=JAXBTools.java2Xml(OperateInfoBean.class, operateInfo);
		    sendMessage.sendMessage(queueDestination, xml);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
