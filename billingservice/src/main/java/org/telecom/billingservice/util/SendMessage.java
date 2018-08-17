package org.telecom.billingservice.util;



import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 发消息测试
 * @author Deng
 *
 */
@Component
public class SendMessage {
	@Resource
	private JmsTemplate jmsTemplate;
	 /**
		 * 特定的目的地中，发送一个Object对象
		 * @param msg
		 */
	    public void sendMessage(Destination destination,final String xml){
	 
	    	
	        //发送一个序列化对象消息
	        jmsTemplate.send(destination,new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	            	 TextMessage textMessage = session.createTextMessage(xml);
	                 return textMessage;
	            	
	            }
	        });
	    }
}
