package edu.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-9 下午6:59:11
 * @文件描述: 处理Resetful风格的URL的demo例子
 */
@Controller
public class ResetFulController {
	/**
	 * 
	 * 1、处理Resetful风格的URL，本案例处理如：say/helloworld、say/what 等格式的URL的GET请求
	 * 2、返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 *    通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发到该实际的物理视图，在本案例，
	 *    得到实际的物理视图是/jsp/say.jsp
	 * 3、通过@PathVariable绑定URL路径中的某部分内容作为方法的参数
	 * @param msg URL路径中say/的下一个内容作为方法的参数传入
	 * @return
	 */
	@RequestMapping(value="say/{msg}",method=RequestMethod.GET)
	public ModelAndView say(@PathVariable("msg") String msg){
		//其中第一个参数为View Name,第二个参数为要传递的数据的key,第三个参数为数据对象。在这里要注意的是:数据是默认被存放在request中的
		return new ModelAndView("say", "msg", msg);
	}
}
