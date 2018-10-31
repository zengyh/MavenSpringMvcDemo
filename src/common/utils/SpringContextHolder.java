package common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-28 下午7:13:24
 * @文件描述: 以静态变量保存Spring ApplicationContext, 
 *           可在任何代码任何地方任何时候取出ApplicaitonContext.
 *           注意，必须在Spring容器初始化之后才有用！
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean{

    private static ApplicationContext applicationContext = null;
    
    private SpringContextHolder(){
    	
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
	@Override
	public void destroy() throws Exception {
		applicationContext = null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
        SpringContextHolder.applicationContext = applicationContext; 
	}
	
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
    	if(applicationContext == null){
    		return null;
    	}else if(applicationContext.getBean(name) == null){
    		return null;
    	}
    	return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
    	if(applicationContext == null){
    		return null;
    	}
        return applicationContext.getBean(requiredType);
    }

}
