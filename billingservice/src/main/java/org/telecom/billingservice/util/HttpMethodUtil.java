package org.telecom.billingservice.util;
import java.io.IOException;
import javax.ws.rs.core.Response;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;





/**
 * web接口Http工具类
 * @author Deng
 *
 */
public class HttpMethodUtil {
	/**
	 * 设置HTTP的请求头
	 */
	public static void setMethodHeaders(HttpMethod method) {
		if (method instanceof PostMethod || method instanceof PutMethod) {
			method.setRequestHeader("Content-Type", "application/xml;charset=UTF-8");
		}
		method.setRequestHeader("Accept", "application/xml;charset=UTF-8");
	}
 
 
	public  static void handleHttpMethod(HttpMethod method) {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		int ret = 0;
		try {
			ret = client.executeMethod(method);
			Response.Status status = Response.Status.fromStatusCode(ret);
			//当返回等于200时
			if(status == Response.Status.OK){
				System.out.println("Authorication true");
			}else if(status == Response.Status.FORBIDDEN){
				System.out.println("Authorication failure");
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
