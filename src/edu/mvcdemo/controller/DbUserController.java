package edu.mvcdemo.controller;

import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import common.UserList;
import common.threadlocal.LocalRequestContextHolder;
import common.utils.MD5Utils;
import edu.mvcdemo.entity.User;
import edu.mvcdemo.model.UserInfo;
import edu.mvcdemo.service.IUserService;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-14 上午9:26:53
 * @文件描述: todo
 */
@Controller
@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class DbUserController {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	/**
	 * 新增用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/saveUser")
	public String saveUser(User user, Model model){
		
		boolean isSuccess = true;
		
		user.setPassword( MD5Utils.encode(user.getPassword()) );
		if(userService.findByUserName(user.getUserName()) == null){
			String errorMsg = userService.save(user);
			model.addAttribute("errorMsg", errorMsg);
			if(errorMsg != null){
				isSuccess = false;
			}
		}else{
			user.setPassword("");
			model.addAttribute("errorMsg", "该用户已经存在！");
			isSuccess = false;
		}
		
		if(isSuccess){
			List<User> userList = userService.findAll();
			model.addAttribute("userList", userList);
			return "user_db/listUser";
		}else{
			user.setPassword("");
			model.addAttribute("user", user);
			return "user_db/index";
		}
	}
	
	/**
	 * 查看所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/listUser")
	public String list(Model model){
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		return "user_db/listUser";
	}
	
	
	/**
	 * 登陆
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/user/logon")
	public String logon(User user, Model model, HttpServletRequest request){
		user.setPassword( MD5Utils.encode(user.getPassword()) );
		HttpSession session = request.getSession();
		if(session.getAttribute("logonUser") == null){
			User checkUser = userService.checkLogin(user);
			if( checkUser != null ){
				UserInfo logonUser = new UserInfo();
				BeanUtils.copyProperties(checkUser, logonUser);  
				session.setAttribute("logonUser", logonUser); //保存到session，则自动往在线用户列表添加该用户，具体实现见User类	
				Enumeration<UserInfo> userlist = UserList.getInstance().getUserList();
				 model.addAttribute("currentUser", logonUser);
				 model.addAttribute("userList", userlist);
				 model.addAttribute("userCount", UserList.getInstance().getUserCount());
				return "user_db/listOnlineUser";
			}else{
				user.setPassword("");
				model.addAttribute("errorMsg", "用户名或密码错误！");
				return "user_db/login";
			}
		}else {
			user.setPassword("");
			model.addAttribute("errorMsg", "已经登陆系统，无需重新登录！");
			return "user_db/login";
		}

	}
	
	/**
	 * 查看在线用户列表
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/listOnlineUser")
	public String listOnlineUser(User user, Model model, HttpServletRequest request){
		 UserInfo currentUser = LocalRequestContextHolder.getLocalRequestContext().getCurrentUser();
		 Enumeration<UserInfo> userlist = UserList.getInstance().getUserList();
		 
		 model.addAttribute("currentUser", currentUser);
		 model.addAttribute("userList", userlist);
		 model.addAttribute("userCount", UserList.getInstance().getUserCount());
		 
		 return "user_db/listOnlineUser";
	}
}
