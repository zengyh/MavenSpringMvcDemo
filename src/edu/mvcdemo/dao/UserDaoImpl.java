package edu.mvcdemo.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.mvcdemo.model.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-10 下午10:47:53
 * @文件描述: todo
 */
@Repository("userDao")
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class UserDaoImpl implements IUserDao {

	/**
	 * 根据用户编号获取用户信息
	 * @param no 用户编号
	 * @return
	 */
	@Override
	public User getUserById(Integer no) {
		User user = new User();
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

}
