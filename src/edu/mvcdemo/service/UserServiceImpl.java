package edu.mvcdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import common.utils.StringUtils;
import edu.mvcdemo.dao.IUserDao;
import edu.mvcdemo.entity.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-10 下午9:57:23
 * @文件描述: todo
 */
@Service("userService")
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class UserServiceImpl implements IUserService {
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	/**
	 * 模拟根据用户编号获取用户信息
	 * @param no 用户编号
	 * @return
	 */
	@Override
	public edu.mvcdemo.model.User getUserByIdSample(Integer no) {
		edu.mvcdemo.model.User user = new edu.mvcdemo.model.User();
		//硬编码方式实现，不查询数据库
		switch(no.intValue()){
		    case 1: 
		    	    user.setNo(no);
		    	    user.setUserName("a");
		    	    user.setAge(16);
		    	    break;
		    case 2:
		    	    user.setNo(no);
	    	        user.setUserName("b");
	    	        user.setAge(18);
	    	        break;
		    case 3:
		    	    user.setNo(no);
    	            user.setUserName("c");
    	            user.setAge(20);
    	            break;
    	    default:       
    	    	    user.setNo(no);
	                user.setUserName("others");
	                user.setAge(30);
		}
		
		return user;
	}

	@Override
	public List<User> findAll() {
		return userDao.getMatchedList(new User());
	}

	@Override
	public String save(User user) {
		String errorMsg = null;
		try{
			userDao.save(user);
		}catch(Exception e){
			errorMsg = StringUtils.getExceptionMessage(e);
		}
		
		return errorMsg;
	}

	@Override
	public User checkLogin(User user) {
		List<User> userList = userDao.getMatchedList(user);
		if(userList != null && !userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		User user = new User();
		user.setUserName(userName);
		List<User> userList = userDao.getMatchedList(user);
		if(userList != null && !userList.isEmpty()){
			return userList.get(0);
		}else{
			return null;
		}
	}

}
