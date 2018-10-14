package edu.mvcdemo.service;

import java.util.List;
import edu.mvcdemo.entity.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-10 下午9:25:18
 * @文件描述: todo
 */
public interface IUserService {
	
	/**
	 * 模拟根据用户编号获取用户信息
	 * @param no 用户编号
	 * @return
	 */
	public edu.mvcdemo.model.User getUserByIdSample(Integer no);
	
	public List<User> findAll();
	
	public String save(User user);
	
	public User checkLogin(User user);
	
	
	public User findByUserName(String userName);
	
}
