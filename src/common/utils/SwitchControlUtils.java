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
		boolean isOpen = false;
		
		if(switchControlService == null){
			try{
				switchControlService = SpringContextHolder.getBean("switchControlService");
			}catch(Exception e){
			}
		}
		
		try{
			isOpen = switchControlService.isSwitchOpen(switchName);
		}catch(Exception e){
		}

		return isOpen;
	}

}
