package edu.mvcdemo.dao;

import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-31 下午9:52:29
 * @文件描述: todo
 */
@Repository("switchControlDao")
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public interface ISwitchControlDao {
	
	/**
	 * 获取匹配的开关数量
	 * @param paramsMap
	 * @return
	 */
	public Long fetchCount(Map<String,Object> paramsMap);
	
}
