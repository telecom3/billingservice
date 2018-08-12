package org.telecom.billingservice.usermag.handleservice;

import org.telecom.billingservice.bean.BusinessInfoBean;

/**
 * 业务层业务账号处理接口
 * @author Deng
 *
 */
public interface IBusinessHandleService {
	/**
	 * 添加业务账号
	 * @param businessInfo  业务账号实体
	 */
void saveBusinessInfoBean(BusinessInfoBean businessInfo);
   /**
    * 修改业务账号
    * 如果是修改业务得状态
    * @param businessInfo  业务账号实体
    */
void updateBusinessInfoBean(BusinessInfoBean businessInfo);
/**
 * 根据id删除业务账号  
 * 首先判断业务得使用状态，如果是未开通，那么可以直接删除
 * 如果是被其它账号使用的话，那么这个业务是不能被删除的
 * 如果是 修改资费套餐，那么需要月底生效
 * @param businessInfoId  业务账号id
 */
void deleteBusinessInfoBeanById(Long  businessInfoId);

}
