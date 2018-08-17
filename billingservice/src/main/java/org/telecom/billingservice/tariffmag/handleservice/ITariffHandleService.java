package org.telecom.billingservice.tariffmag.handleservice;

import org.telecom.billingservice.bean.TariffInfoBean;

/**
 * 业务层资费处理接口
 * 
 * @author Deng
 *
 */
public interface ITariffHandleService {
	/**
	 * 添加资费
	 * 
	 * @param tariffInfo
	 *            资费实体
	 */
	void saveTariffInfoBean(TariffInfoBean tariffInfo);

	/**
	 * 修改资费 暂停状态下，资费支持修改，删除操作。 但是一旦开通后，需要记录开通时间，且开通资费后，一旦被业务使用，资费不允许修改，
	 * 不能再停用，只有在资费并未被任何业务使用到的情况下，才可以被暂停。
	 * 
	 * @param tariffInfo
	 *            资费实体
	 */
	void updateTariffInfoBean(TariffInfoBean tariffInfo);

	/**
	 * 删除资费 暂停状态下，资费支持修改，删除操作。 但是一旦开通后，需要记录开通时间，且开通资费后，一旦被业务使用，资费不允许删除，
	 * 只有在资费并未被任何业务使用到的情况下，才可以被删除
	 * 
	 * @param userId
	 */
	void deleteTariffInfoBeanById(TariffInfoBean tariffInfoId);
	
	/**
	 * 查找
	 * @param tariffInfoId
	 * @return
	 */
	TariffInfoBean getTariffInfoBeanById(Long tariffInfoId);

	/**
	 * 测试删除
	 * @param id
	 */
	void deleteTariffInfoBeanById(long id);
}
