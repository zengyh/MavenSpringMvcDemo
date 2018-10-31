package edu.mvcdemo.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import common.UserList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-14 下午7:07:51
 * @文件描述: 登陆用户信息
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserInfo  implements HttpSessionBindingListener {
	//用户名
	private String userName;
	
	//密码
	private String password;
	
	//创建人
	public String createUser;
	
	//创建时间
	public Date createDate;
	
	//修改人
	public String updateUser;
	
	//修改时间
	public Date updateDate;
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		UserList.getInstance().addUser(this);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		UserList.getInstance().removeUser(this);
	}
}
