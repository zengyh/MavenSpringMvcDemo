package edu.mvcdemo.model;

import java.util.Map;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-10-7 下午5:27:15
 * @文件描述: todo
 */
public class MapForm {
	private Map<String,User> users;

	public Map<String,User> getUsers() {
		return users;
	}

	public void setUsers(Map<String,User> users) {
		this.users = users;
	}

	public String toString() {
		return "users=" + users ;
	}
	
}
