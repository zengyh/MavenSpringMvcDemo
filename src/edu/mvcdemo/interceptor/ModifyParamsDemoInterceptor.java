package edu.mvcdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import edu.mvcdemo.servlet.request.SecurityRiskRequestWrapper;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-16 下午12:39:11
 * @文件描述: todo
 */
public class ModifyParamsDemoInterceptor implements HandlerInterceptor{

    /**
     * 是否需要将当前请求拦截下来，方法将在Controller处理之前进行调用
     * 返回false，则请求被拦截下来，即不继续往下执行
     * 返回true，继续往下执行
     */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		SecurityRiskRequestWrapper req = (SecurityRiskRequestWrapper)request;
		req.addParameter("userName", "被ModifyParamsDemoInterceptor篡改了！");
		return true;
	}

	/**
	 * postHandle是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，
	 * 也就是说在这个方法中你可以对ModelAndView进行操作。
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
        		
	}

	/**
	 * afterCompletion将在整个请求完成之后，也就是DispatcherServlet渲染了视图后执行，
	 *  这个方法的主要作用是用于清理资源的，
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}


}
