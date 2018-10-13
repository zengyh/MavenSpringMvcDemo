package edu.mvcdemo.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.mvcdemo.model.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-8-7 下午10:12:26
 * @文件描述: Controller返回JSON数据的demo
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class ReturnJsonController {
	
	/**
	 * 方式一：使用@ResponseBody标注
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/jsontype/view1/users/{userId}", method=RequestMethod.GET)
	public User getUserInJson(@PathVariable("userId") Integer userId){
		User user = new User();
   	    user.setNo(userId);
   	    user.setUserName("user"+userId);
		return user;
	}
	
	/**
	 * 方式二：使用ResponseEntity
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/jsontype/view2/users/{userId}", method=RequestMethod.GET)
	public ResponseEntity<User> getUserInJson2(@PathVariable("userId") Integer userId){
		User user = new User();
   	    user.setNo(userId);
   	    user.setUserName("user"+userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * 方式三：使用HttpServletResponse对象返回JSON数据
	 * @param userId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/jsontype/view3/users/{userId}", method=RequestMethod.GET)
	public void getUserInJson3(@PathVariable("userId") Integer userId, HttpServletResponse response) throws Exception{
		response.setContentType("application/json");
		response.getWriter().println("{\"no\":"+userId+",\"userName\":\"user"+userId+"\",\"age\":null}");
	}

}
