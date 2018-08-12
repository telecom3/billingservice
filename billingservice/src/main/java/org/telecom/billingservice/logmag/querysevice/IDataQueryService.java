package org.telecom.billingservice.logmag.querysevice;

import org.telecom.billingservice.bean.DataInfoBean;
/**
 * 业务层操作数据查询接口
 * @author Deng
 *
 */
public interface IDataQueryService {
	/**
	 * 根据操作数据id查询操作数据对象
	 * @param id 操作数据id
	 * @return 操作数据对象
	 */
	DataInfoBean getDataInfoBeanById(long id);
}
