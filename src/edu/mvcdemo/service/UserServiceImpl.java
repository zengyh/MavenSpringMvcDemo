package edu.mvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.mvcdemo.dao.IUserDao;
import edu.mvcdemo.model.User;

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
	 * 根据用户编号获取用户信息
	 * @param no 用户编号
	 * @return
	 */
	@Override
	public User getUserById(Integer no) {
		return userDao.getUserById(no);
	}

}
