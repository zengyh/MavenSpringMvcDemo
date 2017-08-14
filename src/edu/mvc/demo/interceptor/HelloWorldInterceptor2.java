package edu.mvc.demo.interceptor;

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
	
	@Override
	public void preHandle(WebRequest request) throws Exception {
		logger.info("执行了HelloWorldInerceptor2.preHandle方法");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		logger.info("执行了HelloWorldInerceptor2.postHandle方法");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex)
			throws Exception {
		logger.info("执行了HelloWorldInerceptor2.afterCompletion方法");
	}

}
