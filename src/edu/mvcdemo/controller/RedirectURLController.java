package edu.mvcdemo.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.utils.StringUtils;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-13 上午9:10:29
 * @文件描述: Spring MVC重定向demo
 */
@Controller
@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
@RequestMapping("/redirect")
public class RedirectURLController {
	
	private Logger logger = Logger.getLogger(RedirectURLController.class);
	
	
	/**
	 * 方式一：方法返回的URI（相对路径）中加上"redirect:"前缀，声明要重定向到该地址
	 *        "redirect:"后面跟着的是"/"和不跟着"/"是不一样的：
	 *        1) "redirect:"后面跟着"/"： 说明该URI是相对于项目的Context ROOT的相对路径
	 *        2) "redirect:"后面没有跟着"/"： 说明该URI是相对于当前路径
	 * @return
	 */
	@RequestMapping(value="/demo1", method=RequestMethod.GET)
	private String testRedirect1(){
		//注意："redirect:/hello/world" 和 "redirect:hello/world"这两种写法是不一样的！！
		//     本案例中：
		//     "redirect:/hello/world" 重定向到的URL路径为：协议://服务器IP或服务器主机名:端口号/项目的Context ROOT/hello/world
		//     "redirect:hello/world"  重定向到的URL路径为：协议://服务器IP或服务器主机名:端口号/项目的Context ROOT/redirect/hello/world
		return "redirect:/hello/world";
	}
	
	/**
	 * 方式二：使用HttpServletResponse对象进行重定向，HttpServletResponse对象通过方法入参传入
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/demo2", method=RequestMethod.GET)
	private void testRedirect2(HttpServletRequest request ,HttpServletResponse response){
        String pathPrefix = StringUtils.getWebContextPath(request);
        String redirectURL = pathPrefix + "/hello/world";
		logger.info(redirectURL);
		try {
			response.sendRedirect(redirectURL);
		} catch (IOException e) {
			logger.error(StringUtils.getExceptionMessage(e));
		}
	}

}
