package edu.mvcdemo.servlet.request;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-13 下午10:41:41
 * @文件描述: 封装Request对象
 */
public class SecurityRiskRequestWrapper extends HttpServletRequestWrapper {

	// 请求参数Map
	private Map<String, String[]> paramsMap = new LinkedHashMap<String, String[]>();

	@SuppressWarnings("unchecked")
	public SecurityRiskRequestWrapper(HttpServletRequest request) {
		super(request);
		this.paramsMap.putAll(request.getParameterMap());
	}

	public SecurityRiskRequestWrapper(HttpServletRequest request,
			                          Map<String, Object> extendParams) {
		this(request);
		addAllParameters(extendParams);
	}

	@Override
	public String getParameter(String name) {
		String[] values = paramsMap.get(name);
		if (values == null || values.length == 0) {
			return null;
		}
		return values[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		return this.paramsMap.get(name);
	}

	public void addAllParameters(Map<String, Object> otherParams) {
		for (Map.Entry<String, Object> entry : otherParams.entrySet()) {
			addParameter(entry.getKey(), entry.getValue());
		}
	}

	public void addParameter(String name, Object value) {
		if (value != null) {
			if (value instanceof String[]) {
				this.paramsMap.put(name, (String[]) value);
			} else if (value instanceof String) {
				this.paramsMap.put(name, new String[] { (String) value });
			} else {
				this.paramsMap.put(name, new String[] { String.valueOf(value) });
			}
		}
	}
	
	@Override
	public Map<String, String[]> getParameterMap() {
		return this.paramsMap;
	}
	
	@Override
	public Enumeration<String> getParameterNames() {
		Set<String> keys = this.paramsMap.keySet();
		return Collections.enumeration(keys);
	}
}
