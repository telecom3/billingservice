package org.telecom.billingservice.authoritymag.handledao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telecom.billingservice.bean.AuthorityInfoBean;

/**
 * 持久层权限处理接口
 * @author wzc
 *
 */
public interface IAuthorityHandleDao extends JpaRepository<AuthorityInfoBean, Long>{
	
	 
}
