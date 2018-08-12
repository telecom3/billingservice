package org.telecom.billingservice.authoritymag.handleservice;

import org.telecom.billingservice.bean.RoleInfoBean;

/**
 * 业务层角色处理接口
 * @author Deng
 *
 */
public interface IRoleHandleService {
	/**
	 * 添加角色
	 * 添加的角色类型一般使用：普通管理员，用户
	 * @param roleInfo 角色实体
	 */
void saveRoleInfoBean(RoleInfoBean roleInfo);

/**
 * 修改权限
 * @param roleInfo  角色实体
 */
void updateRoleInfoBean(RoleInfoBean roleInfo);
/**
 * 删除权限
 * 
 * @param roleInfoId  角色实体ID
 */
void deleteRoleInfoBeanById(Long roleInfoId);
}
