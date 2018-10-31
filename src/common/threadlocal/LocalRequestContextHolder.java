package common.threadlocal;

import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.mvcdemo.model.UserInfo;

/**
 * Title: LocalRequestContextHolder.java
 * Description: 初始化和获取LocalRequestContext（当前请求上下文）的工具类
 * @author yh.zeng
 * @date 2017-6-21
 */
public class LocalRequestContextHolder {

	private final static ThreadLocal<LocalRequestContext> contexts = new ThreadLocal<LocalRequestContext>();
	
	private LocalRequestContextHolder(){}
	
	/**
	 * 初始化当前请求的上下文
	 * @param ctx
	 * @param req
	 * @param res
	 */
	public static void setLocalRequestContext(ServletContext servletContext, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		LocalRequestContext rc = new LocalRequestContext();
		rc.servletContext = servletContext;
		rc.request = httpServletRequest;
		rc.response = httpServletResponse;
		rc.session = httpServletRequest.getSession();
		rc.cookies = new HashMap<String, Cookie>();
		Cookie[] cookies = httpServletRequest.getCookies();
		if(cookies != null){
			for(Cookie ck : cookies) {
				rc.cookies.put(ck.getName(), ck);
			}
		}
		//当前用户信息
		Object userObj = httpServletRequest.getSession().getAttribute("logonUser");
		if(userObj != null){
			rc.currentUser = (UserInfo)userObj;
		}
		contexts.set(rc);
	}
	
	/**
	 * 获取当前请求的上下文
	 * @return
	 */
	public static LocalRequestContext getLocalRequestContext(){
		return contexts.get();
	}
	
    /**
     * 清除当前线程对请求上下文对象的引用（即让GC回收当前请求上下文对象）
     */
	public static void destoryLocalRequestContext() {
		contexts.remove();
	}
	
}