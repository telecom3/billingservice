package org.telecom.billingservice.logmag.querysevice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.DataInfoBean;
import org.telecom.billingservice.logmag.querydao.IDataQueryDao;
import org.telecom.billingservice.logmag.querysevice.IDataQueryService;
/**
 * 业务层操作数据查询接口实现类
 * @author liuyangliang
 *
 */
@Service
public class DataQueryServiceImpl implements IDataQueryService {
	@Resource
	private IDataQueryDao dataQueryDaoImpl;
	
	@DataSource(value = "read")
	@Override
	public DataInfoBean getDataInfoBeanById(long id) {
		
		return dataQueryDaoImpl.getDataInfoBeanById(id);
	}

}
