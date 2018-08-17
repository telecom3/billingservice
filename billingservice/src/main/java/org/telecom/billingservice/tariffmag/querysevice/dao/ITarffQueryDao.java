package org.telecom.billingservice.tariffmag.querysevice.dao;
import java.util.List;
import java.util.Map;
import org.telecom.billingservice.bean.TariffInfoBean;

/**
 * 资费持久层接口
 * @author asus
 *
 */
public interface ITarffQueryDao {
	//TariffInfoBean
	
	/**
	 * emmm
	 * @param tarInfoId
	 * @return
	 */
	TariffInfoBean findTarInfoBeanById(Long tarInfoId);
	/**
	 * 资费
	 * @param page 分页bean
	 * @param params 分页条件
	 * @return 资费分页数据集合
	 */
	List<TariffInfoBean> listTariffmagBeanBy2Params(Map<String, Object> params);

	/**
	 * 资费分页数据总条数
	 * @param params 分页条件
	 * @return 资费分页数据总条数
	 */
	int countTariffmagBeanBy2Params(Map<String, Object> params);
	/**
	 * 查找全部
	 * @return
	 */
	List<TariffInfoBean> listTarInfoBeanfindAll();
}
