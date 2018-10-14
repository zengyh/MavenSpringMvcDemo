package common.interceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import common.utils.StringUtils;

import edu.mvcdemo.servlet.request.SecurityRiskRequestWrapper;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-14 下午11:01:47
 * @文件描述: 信息安全风险问题避免，漏洞修复
 */
public class SecurityRiskInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(SecurityRiskInterceptor.class);

    /**
     * 是否需要将当前请求拦截下来，方法将在Controller处理之前进行调用
     * 返回false，则请求被拦截下来，即不继续往下执行
     * 返回true，继续往下执行
     */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if(request instanceof SecurityRiskRequestWrapper){
			
			SecurityRiskRequestWrapper httpRequest = (SecurityRiskRequestWrapper) request;
			/*
			 * 模拟解决以下场景，场景一：
			 *    系统组织结构分机构，按深圳、上海、北京等等片区划分，
			 *    系统用户，只能查询所在机构以及下级机构的员工、销售额报表等信息。
			 *    所以，在页面上都有机构列表，给用户选择，查询哪个机构下的数据。
			 *    要查询的机构ID由页面传递，这样的话，就存在漏洞，用户可以修改页面传递的值，
			 *    比如深圳机构的权限，用户可以篡改ID，改成总部的机构ID，那么用户就可以查询
			 *    全国的数据，要怎么避免这个问题呢？
			 *    
			 */
			Long orgId = null;
			
			//获取页面传递的机构ID
			if(httpRequest.getParameter("orgId") != null){
				try {
					orgId = Long.parseLong( httpRequest.getParameter("orgId") );
				} catch (Exception e) {
				}
			}
			
			if(orgId != null){
				
				//判断用户是否篡改了页面的机构ID
				boolean isModify = true;
				
				//模拟获取当前用户所在的机构以及下级机构列表
				List<Long> orgList = new ArrayList<Long>();
				orgList.add(new Long(1));
				orgList.add(new Long(2));
				
				if(orgList != null && !orgList.isEmpty()){
					for(Long oid : orgList){
						if(oid.longValue() == orgId.longValue()){
							isModify = false;
							break;
						}
					}
					if(isModify){
						//如果用户篡改了页面的机构ID，则将机构ID设置成当前用户所在机构ID
						httpRequest.addParameter("orgId", orgList.get(0));
					}
				}
			}
			//end 场景一
			
			
			/*
			 * 模拟解决以下场景，场景二：
			 *    防止SQL和JS代码注入
			 */
			Enumeration<String> keys = httpRequest.getParameterNames();
			while(keys.hasMoreElements()){
				if(StringUtils.isCodeInject( httpRequest.getParameter(keys.nextElement()) )){
					throw new Exception("用户录入的数据存在安全隐患，不能包含特殊字符，如select、delete、'、#等等!");
				}
			}
		}
		
		return true;
	}

	/**
	 * postHandle是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，
	 * 也就是说在这个方法中你可以对ModelAndView进行操作。
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	/**
	 * afterCompletion将在整个请求完成之后，也就是DispatcherServlet渲染了视图后执行，
	 *  这个方法的主要作用是用于清理资源的，
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}


}
