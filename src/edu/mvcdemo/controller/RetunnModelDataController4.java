package edu.mvcdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class RetunnModelDataController4 {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	/**
	 * 方式七，直接将数据存到HttpSession，让页面可以获取
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/HttpSession", method=RequestMethod.GET)
	private String getUserInfo(@PathVariable("userId") Integer userId, HttpSession session){
		User user = userService.getUserByIdSample(userId);
		session.setAttribute("user", user);
		return "userinfo";
	}
	
	/**
	 * 方式八，直接将数据存到HttpServletRequest，让页面可以获取
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/HttpServletRequest", method=RequestMethod.GET)
	private String getUserInfo(@PathVariable("userId") Integer userId, HttpServletRequest request){
		User user = userService.getUserByIdSample(userId);
		request.setAttribute("user", user);
		return "userinfo";
	}

}
