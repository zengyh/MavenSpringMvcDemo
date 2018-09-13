package edu.mvcdemo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-8-13 下午9:19:16
 * @文件描述: Spring MVC 拦截器demo2
 */
public class HelloWorldInterceptor2 implements WebRequestInterceptor{
	
	Logger logger = LoggerFactory.getLogger(HelloWorldInterceptor2.class);
	
    /**
     * 是否需要将当前请求拦截下来，方法将在Controller处理之前进行调用
     * 返回false，则请求被拦截下来，即不继续往下执行
     * 返回true，继续往下执行
     */
	@Override
	public void preHandle(WebRequest request) throws Exception {
		logger.info("执行了HelloWorldInerceptor2.preHandle方法");
	}

	/**
	 * postHandle是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，
	 * 也就是说在这个方法中你可以对ModelAndView进行操作。
	 */
	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		logger.info("执行了HelloWorldInerceptor2.postHandle方法");
	}

	/**
	 * afterCompletion将在整个请求完成之后，也就是DispatcherServlet渲染了视图后执行，
	 *  这个方法的主要作用是用于清理资源的，
	 */
	@Override
	public void afterCompletion(WebRequest request, Exception ex)
			throws Exception {
		logger.info("执行了HelloWorldInerceptor2.afterCompletion方法");
	}

}
