package common.utils;

import edu.mvcdemo.service.ISwitchControlService;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-31 下午10:20:36
 * @文件描述: 判断开关是否打开工具类
 */
public class SwitchControlUtils {
	
	private static ISwitchControlService switchControlService;
	
	private SwitchControlUtils(){
		
	}
	
	/**
	 * 判断开关是否打开
	 * @param switchName
	 * @return
	 */
	public static boolean isSwitchOpen(String switchName){
		if(switchControlService == null){
			switchControlService = SpringContextHolder.getBean("switchControlService");
		}
		if(switchControlService == null){
			return false;
		}
		return switchControlService.isSwitchOpen(switchName);
	}

}
