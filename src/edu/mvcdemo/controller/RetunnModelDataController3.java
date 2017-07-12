package edu.mvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mvcdemo.model.User;
import edu.mvcdemo.service.IUserService;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-11 下午9:09:03
 * @文件描述: Controller中如何将model数据返回给页面的demo3
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singletons
@RequestMapping("users")
public class RetunnModelDataController3 {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	/**
	 * 注解@ModelAttribute用法一：
	 * 使用@ModelAttribute注解的方法会在此Controller每个方法执行前被执行，
	 * 指定@ModelAttribute的name或value都是一样的功能，都是作为key，将标注的方法返回的对象作为value存放到Model中，
	 * 不指定name和value的话，则以标注的方法返回的类型名称首字母小写作为key。
	 * @param userId  ResetFul路径的请求参数
	 * @return
	 */
	@ModelAttribute(name="user") 
	public User addAccount(@PathVariable("userId") Integer userId) {  
	   return userService.getUserById(userId);  
	}  

	/**
     * 注解@ModelAttribute用法二：
	 * 使用@ModelAttribute注解的方法会在此Controller每个方法执行前被执行
	 * @param userId    ResetFul路径的请求参数
	 * @param model     模型对象，可以使用org.springframework.ui.Model、org.springframework.ui.ModelMap 
	 *                       或 java.uti.Map 作为入参类型，以引用模型对象
	 */
  /*@ModelAttribute
	public void addAccount(@PathVariable("userId") Integer userId, Model model) {  
	   User user =  userService.getUserById(userId); 
	   model.addAttribute("user", user);
	}*/
	
	/**
	 * 方式六，通过@SessionAttributes将指定key的模型数据存到HttpSession，让页面可以获取
	 * @return
	 */
	@RequestMapping(value="/view/{userId}/use/ModelAttribute", method=RequestMethod.GET)
	private String getUserInfo(@PathVariable("userId") Integer userId){
		return "userinfo";
	}

}
