package edu.mvcdemo.service;

import edu.mvcdemo.model.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-10 下午9:25:18
 * @文件描述: todo
 */
public interface IUserService {
	
	/**
	 * 根据用户编号获取用户信息
	 * @param no 用户编号
	 * @return
	 */
	public User getUserById(Integer no);

}
