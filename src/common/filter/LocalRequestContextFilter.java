package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.threadlocal.LocalRequestContextHolder;

/**
 * Title: LocalRequestContextFilter.java
 * Description: 初始化当前请求上下文的过滤器
 * @author yh.zeng
 * @date 2017-6-22
 */
public class LocalRequestContextFilter implements Filter{

	private ServletContext servletContext;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		LocalRequestContextHolder.setLocalRequestContext(servletContext, (HttpServletRequest)req, (HttpServletResponse)res);
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		servletContext = config.getServletContext();
	}

}
