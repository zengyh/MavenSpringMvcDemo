package edu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-6-25 下午5:12:43
 * @文件描述: Spring MVC Controller Demo，Hello World
 */

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
 
	/**
	 * 1、使用RequestMapping注解来映射请求的URL，在本案例，处理/hello/world此URL的GET请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/helloworld.jsp
	 * @return
	 */
	@RequestMapping(value="/world", method=RequestMethod.GET)
	public String helloMvcGet(){
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		System.out.println(request.getRequestURI());
		return "helloworld";
	}
	
	/**
	 * 1、使用RequestMapping注解来映射请求的URL，在本案例，处理/hello/world此URL的POST请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/send-helloworld-post-return.jsp
	 * @return
	 */
	@RequestMapping(value="/world", method=RequestMethod.POST)
	public String helloMvcPost(){
		return "send-helloworld-post-return";
	}
	
	/**
	 * 1、使用RequestMapping注解来映射请求的URL，在本案例，处理/hello/world2此URL的GET和POST请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/helloworld2.jsp
	 * @return
	 */
	@RequestMapping(value="/world2")
	public String helloWorld(){
		return "helloworld2";
	}
}
