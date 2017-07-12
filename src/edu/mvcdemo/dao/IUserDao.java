package edu.mvcdemo.dao;

import edu.mvcdemo.model.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-10 下午10:45:40
 * @文件描述: todo
 */
public interface IUserDao {
	
	/**
	 * 根据用户编号获取用户信息
	 * @param no 用户编号
	 * @return
	 */
	public User getUserById(Integer no);

}
