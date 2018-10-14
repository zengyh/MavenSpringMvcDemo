package edu.mvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import edu.mvcdemo.model.User;
import edu.mvcdemo.service.IUserService;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-11 下午9:09:03
 * @文件描述: Controller中如何将model数据返回给页面的demo2
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
@RequestMapping("users")
@SessionAttributes({"user"}) //Model中key=user的数据也会存到HttpSession
public class RetunnModelDataController2 {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	/**
	 * 方式五，通过@SessionAttributes将指定key的模型数据存到HttpSession，让页面可以获取
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/SessionAttributes", method=RequestMethod.GET)
	private ModelAndView getUserInfo(@PathVariable("userId") Integer userId){
		User user = userService.getUserByIdSample(userId);
		return new ModelAndView("userinfo", "user", user);
	}

}
