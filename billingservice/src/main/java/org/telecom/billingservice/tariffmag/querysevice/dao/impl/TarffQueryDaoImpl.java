package org.telecom.billingservice.tariffmag.querysevice.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.tariffmag.mapper.TarffQueryMapper;
import org.telecom.billingservice.tariffmag.querysevice.dao.ITarffQueryDao;

/**
 * 资费实现类
 * @author asus
 *
 */
@Repository
public class TarffQueryDaoImpl implements ITarffQueryDao {
	@Resource
	private TarffQueryMapper iTarffQueryMapper;

	@Override
	public List<TariffInfoBean> listTariffmagBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return iTarffQueryMapper.listAccountMonthBeanBy2Params(params);
	}

	@Override
	public int countTariffmagBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return iTarffQueryMapper.countAccountMonthBeanBy2Params(params);
	}

	@Override
	public TariffInfoBean findTarInfoBeanById(Long tarInfoId) {
		// TODO Auto-generated method stub
		return iTarffQueryMapper.findTarInfoBeanById(tarInfoId);
	}

	@Override
	public List<TariffInfoBean> listTarInfoBeanfindAll() {
		// TODO Auto-generated method stub
		return iTarffQueryMapper.listTarInfoBeanfindAll();
	}

	
	
	

}
