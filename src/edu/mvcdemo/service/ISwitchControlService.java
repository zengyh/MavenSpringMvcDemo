package edu.mvcdemo.service;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-31 下午10:13:32
 * @文件描述: todo
 */
public interface ISwitchControlService {

	/**
	 * 判断开关是否打开
	 * @param switchName
	 * @return
	 */
	public boolean isSwitchOpen(String switchName);
	
}
