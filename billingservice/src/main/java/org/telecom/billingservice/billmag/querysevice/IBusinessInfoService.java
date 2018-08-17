package org.telecom.billingservice.billmag.querysevice;

import org.telecom.billingservice.bean.BusinessInfoBean;

public interface IBusinessInfoService {
        
	     BusinessInfoBean getBusinessInfoBean(String osName);
}
