package common.threadlocal;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.mvcdemo.model.UserInfo;

/**
 * Title: LocalRequestContext.java
 * Description: 当前请求上下文对象 (存放了HttpSession、HttpServletRequest等对象)
 * @author yh.zeng
 * @date 2017-6-25
 */
public class LocalRequestContext {
	
	public ServletContext servletContext;
	public HttpSession session;
	public HttpServletRequest request;
	public HttpServletResponse response;
	public Map<String, Cookie> cookies;
	public UserInfo currentUser;  //当前登陆用户
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Cookie> getCookies() {
		return cookies;
	}

	public void setCookies(Map<String, Cookie> cookies) {
		this.cookies = cookies;
	}

	public UserInfo getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserInfo currentUser) {
		this.currentUser = currentUser;
	} 

}
