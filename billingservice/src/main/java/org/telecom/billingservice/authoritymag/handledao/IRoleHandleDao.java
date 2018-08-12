package org.telecom.billingservice.authoritymag.handledao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telecom.billingservice.bean.RoleInfoBean;

/**
 * 持久层角色处理接口
 * @author wzc
 *
 */
public interface IRoleHandleDao extends JpaRepository<RoleInfoBean, Long>{

}
