package edu.mvc.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-8-11 下午11:26:32
 * @文件描述: Spring MVC 拦截器demo1
 */
public class HelloWorldInterceptor implements HandlerInterceptor{
	
	Logger logger = LoggerFactory.getLogger(HelloWorldInterceptor.class);

    /**
     * 是否需要将当前请求拦截下来
     * 返回false，则请求被拦截下来，即不继续往下执行
     * 返回true，继续往下执行
     */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("执行了HelloWorldInterceptor.preHandle方法");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("执行了HelloWorldInterceptor.postHandle方法");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("执行了HelloWorldInterceptor.afterCompletion方法");
	}

}
