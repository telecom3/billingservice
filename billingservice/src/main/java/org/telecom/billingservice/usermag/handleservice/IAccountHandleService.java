package org.telecom.billingservice.usermag.handleservice;


import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务层账务账号处理接口
 * @author Deng
 *
 */
public interface IAccountHandleService {
	/**
	 * 添加账务账号
	 * @param user 账务账号实体
	 */
void saveUserInfoBean(UserInfoBean user);

/**
 * 修改账务账号，修改之前需要根据id查询，将要修改得属性更新后再使用该方法
 * 如果是修改账务账号的状态为停用状态，该账号对应的业务所有业务也必须修改为停用状态，
 * @param user  账务账号实体
 */
void updateUserInfoBean(UserInfoBean user);
/**
 * 删除账务账号，账号删除后，该账号对应的业务状态也必须修改为暂停使用状态，不然会继续计费
 * @param user  账务账号实体
 */
void deleteUserInfoBeanById(Long userId);

}
