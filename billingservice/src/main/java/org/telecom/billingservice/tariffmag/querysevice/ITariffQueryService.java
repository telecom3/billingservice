package org.telecom.billingservice.tariffmag.querysevice;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;



/**
 * 业务层资费查询接口
 * 
 * @author Deng
 *
 */
public interface ITariffQueryService {
	
	
	/**
	 * emmm
	 * @param tarInfoId
	 * @return
	 */
	TariffInfoBean findTarInfoBeanById(Long tarInfoId);
	/**
	 * 资费分页
	 * 
	 * @param page
	 *            分页实体
	 * @param params
	 *            动态添加参数
	 * @return 分页实体
	 */
	PagerBean listTariffInfoBeanBy2Params(PagerBean page, Map<String, Object> params);
	
	/**
	 * 查找全部
	 * @return
	 */
	List<TariffInfoBean> listTarInfoBeanfindAll();
}
