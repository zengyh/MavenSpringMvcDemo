package edu.mvcdemo.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import edu.mvcdemo.utils.StringUtils;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-13 下午4:34:28
 * @文件描述: Controller中void方法的声明demo，这种场景一般是通过HttpServletResponse对象来输出页面内容
 */
@Controller
@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
@RequestMapping("/voidMethod")
public class VoidMethodDemoController {
	
	private Logger logger = Logger.getLogger(VoidMethodDemoController.class);
	
	/**
	 * 方式一：通过声明HttpServletResponse类型的方法入参，来使用HttpServletResponse对象。
	 *        注意：在Controller中，@RequestMapping注解的方法，在调用这个方法时候，
	 *             如果有定义HttpServletResponse类型的入参，Spring MVC框架会自动传入一个HttpServletResponse对象作为方法参数；
	 *             如果有定义HttpServletRequest类型的入参，Spring MVC框架会自动传入一个HttpServletRequest对象作为方法参数。
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/demo1", method=RequestMethod.GET)
	private void test1(HttpServletRequest request, HttpServletResponse response){
		try {
			response.getWriter().print("<h1>Hello World</h1>");
		} catch (IOException e) {
			logger.error(StringUtils.getExceptionMessage(e));
		}
	}
	
	/**
	 * 错误的方式二：void方法不定义HttpServletResponse类型的入参，HttpServletResponse对象通过RequestContextHolder上下文获取
	 *             注意：这种方式是不可行的，void方法不定义HttpServletResponse类型的入参，
	 *                  Spring MVC会认为@RequestMapping注解中指定的路径就是要返回的视图name，在本案例中，
	 *                  页面上访问 http://127.0.0.1:8080/MavenSpringMvcDemo/voidMethod/demo2，接着会将
	 *                  http://127.0.0.1:8080/MavenSpringMvcDemo/jsp/voidMethod/demo2.jsp 作为此次请求的响应内容
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/demo2", method=RequestMethod.GET)
	private void test2(HttpServletRequest request){
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		try {
			response.getWriter().print("<h1>Hello World</h1>");
		} catch (IOException e) {
			logger.error(StringUtils.getExceptionMessage(e));
		}
	}
	
}
