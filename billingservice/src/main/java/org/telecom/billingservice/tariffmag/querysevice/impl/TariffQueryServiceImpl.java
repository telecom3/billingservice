package org.telecom.billingservice.tariffmag.querysevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.AccountMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.tariffmag.querysevice.ITariffQueryService;
import org.telecom.billingservice.tariffmag.querysevice.dao.ITarffQueryDao;

/**
 * 资费业务层接口
 * @author asus
 *
 */
@Service
public class TariffQueryServiceImpl implements ITariffQueryService {
	@Resource
	private ITarffQueryDao iTarffQueryDaoImpl;
	@DataSource(value = "read")
	@Override
	public PagerBean listTariffInfoBeanBy2Params(PagerBean page, Map<String, Object> params) {
		int count = iTarffQueryDaoImpl.countTariffmagBeanBy2Params(params);
		page.setCount(count);
		
		if (count > 0) {
			params.put("index", page.getIndex());
			params.put("limit", page.getLimit());
			List<TariffInfoBean> data = iTarffQueryDaoImpl.listTariffmagBeanBy2Params(params);
			page.setData(data);
		}
		return page;
	}
	@Override
	public TariffInfoBean findTarInfoBeanById(Long tarInfoId) {
		// TODO Auto-generated method stub
		return iTarffQueryDaoImpl.findTarInfoBeanById(tarInfoId);
	}
	@Override
	public List<TariffInfoBean> listTarInfoBeanfindAll() {
		// TODO Auto-generated method stub
		return iTarffQueryDaoImpl.listTarInfoBeanfindAll();
	}
	
	
	

}
