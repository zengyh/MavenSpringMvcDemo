package edu.mvcdemo.dao;

import java.util.List;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-13 下午11:21:11
 * @文件描述: todo
 */
public interface  IBaseDao<T> {
	public int getMatchedCount(T t);
	
	public List<T> getMatchedList(T t);
	
	public void save(T t);
	
	public int update(T t);
	
    public int delete(T t); 
}
