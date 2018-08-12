package org.telecom.billingservice.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
 * 中文乱码过滤器
 * 既可以处理POST乱码，又可以处理GET乱码
 * @author liuyangliang
 *
 */
public class CharacterEncodingFilter implements Filter {

	private String encoding;
	private boolean forceEncoding = false;

	public CharacterEncodingFilter() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String method = req.getMethod();
		
		String post ="POST";
		String put ="PUT";
		String get ="GET";
		String delete ="DELETE";
		
		if (post.equals(method.toUpperCase()) ||put.equals(method.toUpperCase()) || delete.equals(method.toUpperCase())) {
			req.setCharacterEncoding(encoding);
			if (forceEncoding) {
				res.setCharacterEncoding(encoding);
			}
			chain.doFilter(req, res);
		} else if (get.equals(method.toUpperCase())) {
			HttpServletRequest wrapper = new EncodingHttpServletRequest(req, encoding);
			chain.doFilter(wrapper, res);
		}
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		encoding = config.getInitParameter("encoding");
		forceEncoding = Boolean.valueOf(config.getInitParameter("forceEncoding"));
	}
	
	private static class EncodingHttpServletRequest extends HttpServletRequestWrapper {

		private HttpServletRequest request;
		private String encoding;

		public EncodingHttpServletRequest(HttpServletRequest request, String encoding) {
			super(request);
			// TODO Auto-generated constructor stub
			this.request = request;
			this.encoding = encoding;
		}

		@Override
		public String getQueryString() {
			// TODO Auto-generated method stub
			String content = request.getQueryString();

			if (content != null) {
				try {
					content = URLDecoder.decode(content, encoding);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return content;
		}
		
		@Override
		public Map<String, String[]> getParameterMap() {
			// TODO Auto-generated method stub
			String content = getQueryString();
			Map<String, String[]> params = new HashMap<String, String[]>(30);
			// 处理多值的情况
			Map<String, List<String>> multiValues = new HashMap<String, List<String>>(30);
			if (content != null) {
				String[] tem = content.split("&");
				for (String str : tem) {
					// userName=撒旦法
					String[] kvs = str.split("=");
					// 需要处理一个提交项有多个值的情况发生
					if (params.containsKey(kvs[0])) {
						// 需要处理checkbox的多值情况，例如：ck=111&ck=222&ck=333
						List<String> valuesList;
						// 如果多值集合中已经包含某个键
						if (multiValues.containsKey(kvs[0])) {
							valuesList = multiValues.get(kvs[0]);
							if (kvs.length >= 2) {
								valuesList.add(kvs[1]);
							} else {
								valuesList.add("");
							}
						} else {
							// 如果多值集合中尚未包含某个键
							valuesList = new ArrayList<String>();
							// 初始加入
							valuesList.add(params.get(kvs[0])[0]);
							// ck=111
							if (kvs.length >= 2) {
								valuesList.add(kvs[1]);
							} else {
								valuesList.add("");
							}
							multiValues.put(kvs[0], valuesList);
						}
					} else {
						// userName=撒旦法
						if (kvs.length >= 2) {
							params.put(kvs[0], new String[] { kvs[1] });
						} else {
							params.put(kvs[0], new String[] { "" });
						}
					}
				} 
				// for循环结束
				// --------------将多值情况，同样添加到params集合中去-------------
				if (multiValues != null && !multiValues.isEmpty()) {
					Iterator<String> its = multiValues.keySet().iterator();
					while (its.hasNext()) {
						String key = (String) its.next();
						List<String> strs = multiValues.get(key);
						// 获得值的个数
						int size = strs.size();
						String[] arrays = new String[size];
						for (int i = 0; i < size; i++) {
							arrays[i] = strs.get(i);
						}
						// 将多值的情况也处理到Map集合中去
						params.put(key, arrays);
					}
				}
			}
			return params;
		}

		@Override
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			Map<String, String[]> params = getParameterMap();
			String val = "";
			if (params != null && params.containsKey(name)) {
				val = params.get(name)[0];
			}
			return val;
		}

		@Override
		public Enumeration<String> getParameterNames() {
			// TODO Auto-generated method stub
			return Collections.enumeration(getParameterMap().keySet());
		}

		@Override
		public String[] getParameterValues(String name) {
			// TODO Auto-generated method stub
			return (String[]) getParameterMap().get(name);
		}
	}

}
