package org.telecom.billingservice.logmag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.OperateInfoBean;
import org.telecom.billingservice.logmag.mapper.OperateLogQueryMapper;
import org.telecom.billingservice.logmag.querydao.IOperateLogQueryDao;

/**
 * 持久层操作日志查询接口实现类
 * @author liuyangliang
 *
 */
@Repository
public class OperateLogQueryDaoImpl implements IOperateLogQueryDao {
	@Resource
	private OperateLogQueryMapper operateLogQueryMapper;
	
	@Override
	public List<OperateInfoBean> listOperateInfoBeanBy2Params(Map<String, Object> params) {
		return operateLogQueryMapper.listOperateInfoBeanBy2Params(params);
	}

	@Override
	public int countOperateInfoBeanBy2Params(Map<String, Object> params) {
		return operateLogQueryMapper.countOperateInfoBeanBy2Params(params);
	}

}
