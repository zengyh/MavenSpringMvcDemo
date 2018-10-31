package net.sf.log4jdbc;

import java.sql.Connection;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import net.sf.log4jdbc.RdbmsSpecifics;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-13 下午5:48:40
 * @文件描述: 根据Log4jdbc写的一个扩展的一个拦截器类，用于sql执行语句的日志打印
 */
public class DataSourceSpyInterceptor implements MethodInterceptor {

	private RdbmsSpecifics rdbmsSpecifics = null;
	
    private RdbmsSpecifics getRdbmsSpecifics(Connection conn) {
        if(rdbmsSpecifics == null) {
            rdbmsSpecifics = DriverSpy.getRdbmsSpecifics(conn);
        }
        return rdbmsSpecifics;
    }
    
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = invocation.proceed();
		if(SpyLogFactory.getSpyLogDelegator().isJdbcLoggingEnabled()) {
    		if(result instanceof Connection) {
    			Connection conn = (Connection)result;
    			return new ConnectionSpy(conn,getRdbmsSpecifics(conn));
    		}
		}
		return result;
	}

}