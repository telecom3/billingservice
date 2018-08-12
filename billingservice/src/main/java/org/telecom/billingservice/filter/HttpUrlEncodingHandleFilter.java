package org.telecom.billingservice.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
/**
 * 当Rest提供时，中文路径乱码，可以使用此过滤器，解决
 * @author liuyangliang
 *
 */
public class HttpUrlEncodingHandleFilter implements Filter {

    public HttpUrlEncodingHandleFilter() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		EncodingHttpServletRequest wapper = new EncodingHttpServletRequest(req);
		chain.doFilter(wapper, res);
	}
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	private static class EncodingHttpServletRequest extends HttpServletRequestWrapper{

		private HttpServletRequest request;
		
		public EncodingHttpServletRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
			this.request = request;
		}
		
		@Override
		public String getServletPath() {
			// TODO Auto-generated method stub
			String servletPath = request.getServletPath();
			try {
				servletPath =new String(servletPath.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return servletPath;
		}
		
		
		
	}

}