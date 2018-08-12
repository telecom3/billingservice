/**
 * 
 */
package org.telecom.billingservice.logmag.querydao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.DataInfoBean;
import org.telecom.billingservice.logmag.mapper.DataQueryMapper;
import org.telecom.billingservice.logmag.querydao.IDataQueryDao;

/**
 * 持久层操作数据查询接口实现类
 * @author liuyangliang
 *
 */
@Repository
public class DataQueryDaoImpl implements IDataQueryDao {
	@Resource
	private DataQueryMapper dataQueryMapper;
	
	@DataSource(value = "read")
	@Override
	public DataInfoBean getDataInfoBeanById(long id) {
		return dataQueryMapper.getDataInfoBeanById(id);
	}

}
