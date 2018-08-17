package org.telecom.billingservice.administratormag.handledao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telecom.billingservice.bean.UserInfoBean;

public interface IAdministraorHandleDao extends JpaRepository<UserInfoBean, Long> {
	
}
