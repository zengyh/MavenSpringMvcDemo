package edu.mvcdemo.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import edu.mvcdemo.entity.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-10 下午10:45:40
 * @文件描述: todo
 */
@Repository("userDao")
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public interface IUserDao extends IBaseDao<User>{
	 
}
