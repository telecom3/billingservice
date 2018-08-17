package org.telecom.billingservice.publicservicemag.handleservice.impl;

import org.apache.commons.httpclient.methods.GetMethod;
import org.telecom.billingservice.publicservicemag.handleservice.IWeatherService;
import org.telecom.billingservice.util.HttpMethodUtil;
import org.apache.commons.httpclient.NameValuePair;
import org.springframework.stereotype.Service;

/**
 * 业务层天气接口实现类
 * @author Deng
 *
 */
@Service
public class WeatherServiceImpl implements IWeatherService {

	@Override
	public String getWeather(String city) {
		// TODO Auto-generated method stub
		 GetMethod get = new GetMethod("https://way.jd.com/jisuapi/weather");
			NameValuePair mes01 = new NameValuePair("city", city);
			NameValuePair mes02 = new NameValuePair("appkey", "44d9a7557cb7e241525d8eb3c114eefa");
          
			get.setQueryString(new NameValuePair[]{mes01,mes02});
//			WeatherBean  weath=null;
//			JSONObject obj=null;
			//执行方法的提交
			HttpMethodUtil.handleHttpMethod(get);
			String json="";
			try {
				json=get.getResponseBodyAsString();
//				 obj=JSONObject.fromObject(json);
//				 weath=(WeatherBean ) JSONObject.toBean(obj, WeatherBean .class);
//				System.out.println( weath);
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		return json;
	}

}
