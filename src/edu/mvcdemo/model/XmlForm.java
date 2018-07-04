package edu.mvcdemo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-10-7 下午10:28:03
 * @文件描述: todo
 */
@XmlRootElement(name="user")
public class XmlForm {
	private String name;
	private Integer age;

	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "XmlForm {name=" + name + ", age=" + age + "}";
	}

}
