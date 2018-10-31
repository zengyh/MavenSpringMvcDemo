package edu.mvcdemo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.mvcdemo.dao.ISwitchControlDao;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-31 下午10:15:00
 * @文件描述: todo
 */
@Service("switchControlService")
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class SwitchControlServiceImpl implements ISwitchControlService {
	
	@Autowired
	private ISwitchControlDao switchControlDao;

	/**
	 * 判断开关是否打开
	 */
	@Override
	public boolean isSwitchOpen(String switchName) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("switchName", switchName);
		paramsMap.put("validDate", new Date());
		if(switchControlDao.fetchCount(paramsMap) > 0 ){
			return true;
		}
		return false;
	}


}
