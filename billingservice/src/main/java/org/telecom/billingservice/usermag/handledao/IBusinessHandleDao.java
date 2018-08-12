package org.telecom.billingservice.usermag.handledao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telecom.billingservice.bean.BusinessInfoBean;

/**
 * 持久层业务账号处理接口
 * @author wzc
 *
 */
public interface IBusinessHandleDao extends JpaRepository<BusinessInfoBean, Long>{

}
