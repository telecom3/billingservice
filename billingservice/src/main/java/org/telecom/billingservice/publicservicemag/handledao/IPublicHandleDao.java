package org.telecom.billingservice.publicservicemag.handledao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.UserInfoBean;
/**
 * 持久层公共服务处理接口
 * @author 李博
 *
 */
@Repository
public interface IPublicHandleDao extends JpaRepository<UserInfoBean,Long>,JpaSpecificationExecutor<UserInfoBean>{


}
