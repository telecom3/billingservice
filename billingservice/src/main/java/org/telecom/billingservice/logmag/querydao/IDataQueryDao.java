package org.telecom.billingservice.logmag.querydao;

import org.telecom.billingservice.bean.DataInfoBean;

/**
 * 持久层操作数据查询接口
 * @author liuyangliang
 *
 */
public interface IDataQueryDao {
	/**
	 * 根据操作数据id查询操作数据对象
	 * @param id 操作数据id
	 * @return 操作数据对象
	 */
	DataInfoBean getDataInfoBeanById(long id);
}
