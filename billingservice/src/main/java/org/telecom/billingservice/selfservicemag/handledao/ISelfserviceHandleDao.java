package org.telecom.billingservice.selfservicemag.handledao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.UserInfoBean;
/**
 * 持久层用户自服务处理接口
 * @author 李博
 *
 */
@Repository
public interface ISelfserviceHandleDao extends JpaRepository<UserInfoBean,Long>{

}
