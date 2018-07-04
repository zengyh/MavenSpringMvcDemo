package edu.mvcdemo.model;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-8-20 下午10:28:38
 * @文件描述: todo
 */
public class Admin {
	private Integer no; // 用户编号
	private String userName; // 用户名
	private Integer age; // 年龄

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Admin {no=" + no + ", userName=" + userName + ", age=" + age
				+ "}";
	}

}
