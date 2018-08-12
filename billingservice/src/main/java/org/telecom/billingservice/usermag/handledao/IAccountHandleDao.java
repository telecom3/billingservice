package org.telecom.billingservice.usermag.handledao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 持久层账务账号处理接口
 * @author wzc
 *
 */
public interface IAccountHandleDao extends JpaRepository<UserInfoBean, Long>{
	
}
