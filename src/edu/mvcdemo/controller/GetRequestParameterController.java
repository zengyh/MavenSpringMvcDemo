package edu.mvcdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.mvcdemo.model.MsgObject;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-9 下午2:37:33
 * @文件描述: 获取请求参数demo
 */
@Controller
public class GetRequestParameterController {
	
	/**
	 * 方式一，通过@RequestParam绑定请求参数
	 * 1、使用RequestMapping注解来映射请求的URL，在本案例，处理/say此URL的GET请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/say.jsp
	 * @param msg URL中传递的请求参数
	 * @return
	 */
	@RequestMapping(value="say",method=RequestMethod.GET)
	public ModelAndView  say(@RequestParam("msg") String msg){
		//其中第一个参数为View Name,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的
		return new ModelAndView("say", "msg", msg);
	}
	
	/**
	 * 方式二，通过RequestContextHolder上下文获取request对象
	 *        不推荐使用这种方式！！
	 *        当请求为multipart类型的请求的时候，如文件上传，form表单的enctype类型为"multipart/form-data"，
	 *        这种情况下，RequestHolder.getRequest().getParameter()是得不到参数值的！！
	 *        因为通过RequestHolder.getRequest()获取到的request对象是org.apache.catalina.connector.RequestFacade的实例
	 * 1、使用RequestMapping注解来映射请求的URL，在本案例，处理/say2此URL的GET请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/say.jsp
	 * @return
	 */
	@RequestMapping(value="say2",method=RequestMethod.GET)
	public ModelAndView say2(){
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		//其中第一个参数为View Name,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的
		return new ModelAndView("say", "msg", request.getParameter("msg"));
	}
	

	/**
	 * 方式三，直接将HttpServletRequest对象作为方法的入参
	 * 1、使用RequestMapping注解来映射请求的URL，在本案例，处理/say3此URL的GET请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/say.jsp
	 * @param request
	 * @return
	 */
	@RequestMapping(value="say3",method=RequestMethod.GET)
	public ModelAndView say2(HttpServletRequest request){
		//其中第一个参数为View Name,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的
		return new ModelAndView("say", "msg", request.getParameter("msg"));
	}
	
	/**
	 * 方式四，通过@ModelAttribute将请求参数转换成Java自定义对象的成员变量
	 * 1、使用RequestMapping注解来映射请求的URL，在本案例，处理/say4此URL的GET请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/say.jsp
	 * @param request
	 * @return
	 */
	@RequestMapping(value="say4",method=RequestMethod.GET)
	public ModelAndView say2(@ModelAttribute MsgObject msgObject){
		//其中第一个参数为View Name,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的
		return new ModelAndView("say", "msg", msgObject.getMsg());
	}

}
