package edu.mvcdemo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import edu.mvcdemo.servlet.request.SecurityRiskRequestWrapper;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-13 下午11:31:36
 * @文件描述: 封装SecurityRiskRequestWrapper请求对象
 */
public class SecurityRiskRequestWrapperFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		SecurityRiskRequestWrapper requestWrapper = new SecurityRiskRequestWrapper( (HttpServletRequest) request );
		chain.doFilter(requestWrapper, response);
	}

	@Override
	public void destroy() {
	}


}
