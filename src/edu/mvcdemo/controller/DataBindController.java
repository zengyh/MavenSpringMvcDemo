package edu.mvcdemo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mvcdemo.model.Admin;
import edu.mvcdemo.model.ListForm;
import edu.mvcdemo.model.MapForm;
import edu.mvcdemo.model.SetForm;
import edu.mvcdemo.model.User;
import edu.mvcdemo.model.XmlForm;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-8-20 下午9:58:25
 * @文件描述: 数据绑定Demo
 */
@Controller
@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class DataBindController {
	
	/**
	 * 同属性多对象绑定demo
	 * @param user
	 * @param admin
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/databind/demo/object", method=RequestMethod.GET)
	private String initObject(User user, Admin admin){
		StringBuilder builder = new StringBuilder();
		builder.append(user.toString()).append("<br>");
		builder.append(admin.toString());
		
		return builder.toString();
	}
	
	/**
	 * 通过@InitBinder注解将user.前缀的请求参数绑定到变量user中
	 * 每个@RequestMapping注解的Controller方法执行前都会执行该方法
	 * @param binder
	 */
	@InitBinder("user")
	private void initUser(WebDataBinder binder){
		binder.setFieldDefaultPrefix("user.");
	}
	
	/**
	 * 通过@InitBinder注解将admin.前缀的请求参数绑定到变量admin中
	 * 每个@RequestMapping注解的Controller方法执行前都会执行该方法
	 * @param binder
	 */
	@InitBinder("admin")
	private void initAdmin(WebDataBinder binder){
		binder.setFieldDefaultPrefix("admin.");
	}
	
	
	/**
	 * 绑定List对象
	 * @param listForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/databind/demo/list", method=RequestMethod.GET)
	private String initList(ListForm listForm){
		return listForm.toString();
	}
	
	/**
	 * 绑定Set对象
	 * @param listForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/databind/demo/set", method=RequestMethod.GET)
	private String initSet(SetForm setForm){
		return setForm.toString();
	}
	
	/**
	 * 绑定Map对象
	 * @param listForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/databind/demo/map", method=RequestMethod.GET)
	private String initSet(MapForm mapForm){
		return mapForm.toString();
	}
	
	/**
	 * 绑定Json对象
	 * @param listForm
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/databind/demo/json", method=RequestMethod.POST)
	private void initJson(@RequestBody User user, HttpServletResponse reponse) throws IOException{
		reponse.setContentType("text/html");
		reponse.getWriter().println(user.toString());
	}
	
	/**
	 * 绑定Xml对象
	 * demo:
	 * <?xml version="1.0" encoding="UTF-8"?>
     * <user>
     *   <name>李四</name>
     *   <age>18</age>
     * </user>
	 * @param listForm
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/databind/demo/xml", method=RequestMethod.POST)
	private void initXml(@RequestBody XmlForm user, HttpServletResponse reponse) throws IOException{
		reponse.setContentType("text/html");
		reponse.getWriter().println(user.toString());
	}
	
	@RequestMapping(value="/databind/demo/date", method=RequestMethod.GET)
	@ResponseBody
	private String initDate(Date date){
		return date.toString();
	}
	
	@InitBinder("date")
	private void dateFormat(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}