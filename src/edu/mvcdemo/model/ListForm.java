package edu.mvcdemo.model;

import java.util.List;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-8-24 上午12:00:57
 * @文件描述: todo
 */
public class ListForm {
	
	private List<User> users;

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "users=" + users;
	}
	
}
