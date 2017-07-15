package edu.mvcdemo.controller;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mvcdemo.model.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-15 下午12:14:41
 * @文件描述: 表单提交demo
 */
@Controller
@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class FormSubmitController {
	
	private Logger logger = Logger.getLogger(FormSubmitController.class);
	
	@RequestMapping(value="/user/view/{userId}", method=RequestMethod.GET)
	private String viewUser(@PathVariable("userId") String userId){
		return "user/view";
	}
	
	@RequestMapping(value="/admin/user", method=RequestMethod.GET, params="add")
	private String addUser(){
		return "user/add";
	}
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST)
	private String doSave(@ModelAttribute User user, HttpSession session){

		
		user.setNo(RandomUtils.nextInt(1000)); //模拟数据库持久化
		
		/**
		 * 进行数据库的持久化，省略
		 */

        logger.info(ReflectionToStringBuilder.toString(user));
        
        session.setAttribute("user", user);
        
		return "redirect:/user/view/"+user.getNo();
	}
}
