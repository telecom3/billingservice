package org.telecom.billingservice.tariffmag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.TariffInfoBean;

/**
 * 业务层资费查询接口
 * @author Deng
 *
 */
public interface ITariffQueryService {
/**
 * 根据id查询资费
 * @param tariffInfoId  资费id
 * @return  资费实体
 */
TariffInfoBean findBusinessInfoBeanById(Long tariffInfoId);
/**
 * 资费分页
 * @param page  分页实体
 * @param params  动态添加参数
 * @return  分页实体
 */
PagerBean listTariffInfoBeanBy2Params(PagerBean page,Map<String,Object> params);
}
