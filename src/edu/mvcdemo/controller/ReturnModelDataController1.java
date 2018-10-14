package edu.mvcdemo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import edu.mvcdemo.model.User;
import edu.mvcdemo.service.IUserService;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-10 下午9:16:54
 * @文件描述: Controller中如何将model数据返回给页面的demo1
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
@RequestMapping("users")
public class ReturnModelDataController1 {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	
	/**
	 * 方式一，通过ModelAndView返回用户信息数据到页面
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/ModelAndView", method=RequestMethod.GET)
	private ModelAndView getUserInfo(@PathVariable("userId") Integer userId){
		User user = userService.getUserByIdSample(userId);
		return new ModelAndView("userinfo", "user", user);
	}
	
	/**
	 * 方式二，通过Model返回用户信息数据到页面
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/Model", method=RequestMethod.GET)
	private String getUserInfo(@PathVariable("userId") Integer userId, Model model){
		User user = userService.getUserByIdSample(userId);
		model.addAttribute("user", user);
		return "userinfo";
	}
	
	
	/**
	 * 方式三，通过ModelMap返回用户信息数据到页面
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/ModelMap", method=RequestMethod.GET)
	private String getUserInfo(@PathVariable("userId") Integer userId, ModelMap model){
		User user = userService.getUserByIdSample(userId);
		model.addAttribute("user", user);
		return "userinfo";
	}
	
	/**
	 * 方式四，通过Map返回用户信息数据到页面
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/Map", method=RequestMethod.GET)
	private String getUserInfo(@PathVariable("userId") Integer userId, Map<String,Object> model){
		User user = userService.getUserByIdSample(userId);
		model.put("user", user);
		return "userinfo";
	}

}
