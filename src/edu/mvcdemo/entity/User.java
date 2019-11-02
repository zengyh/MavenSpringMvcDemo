package edu.mvcdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-14 下午11:58:59
 * @文件描述: 
 */
@Data
@NoArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class User extends BaseEntity {

	//用户名
	private String userName;
	
	//密码
	private String password;
	
}
