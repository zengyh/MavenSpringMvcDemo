package edu.mvcdemo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-10-5 下午12:27:15
 * @文件描述: todo
 */
public class SetForm {
	
	private Set<User> users;
	
    public SetForm(){
    	users = new HashSet<User>();
    	users.add(new User());
    	users.add(new User());
   }

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "users=" + users ;
	}
	
}
