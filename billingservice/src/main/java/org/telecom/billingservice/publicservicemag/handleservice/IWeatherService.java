package org.telecom.billingservice.publicservicemag.handleservice;



/**
 * 业务层天气服务接口
 * @author Deng
 *
 */
public interface IWeatherService {
	/**
	 * 获取天气
	 * @param city 城市
	 * @return 天气实体
	 */
String getWeather(String city);
}
