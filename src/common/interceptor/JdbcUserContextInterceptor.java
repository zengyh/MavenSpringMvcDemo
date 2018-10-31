package common.interceptor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import net.sf.log4jdbc.SpyLogFactory;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.JdbcUtils;
import common.threadlocal.LocalRequestContext;
import common.threadlocal.LocalRequestContextHolder;
import common.utils.StringUtils;
import edu.mvcdemo.model.UserInfo;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-13 下午5:48:40
 * @文件描述: 用于拦截DataSource方法，初始化连接会话的用户名
 */
public class JdbcUserContextInterceptor implements MethodInterceptor {
	
	Logger logger = LoggerFactory.getLogger(JdbcUserContextInterceptor.class);

	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = invocation.proceed();
		if(SpyLogFactory.getSpyLogDelegator().isJdbcLoggingEnabled()) {
    		if(result instanceof Connection) {
    			Connection conn = (Connection)result;
    			this.setUser(conn);
    		}
		}
		return result;
	}
	
	/**
	 * 初始化会话的用户名
	 * @param conn
	 */
	public void setUser(Connection conn){
		CallableStatement cstmt = null;
		LocalRequestContext context = LocalRequestContextHolder.getLocalRequestContext();
		UserInfo currentUser = context.getCurrentUser();
		if(currentUser != null){
			String currentUserName = currentUser.getUserName();
			try {
				String sql = " {call pub_user_package.set_user(?)} ";
				cstmt = conn.prepareCall(sql);
				cstmt.setString(1, currentUserName);
				cstmt.execute();
			} catch (SQLException e) {
			    logger.error(StringUtils.getExceptionMessage(e));
			} finally {
				JdbcUtils.closeStatement(cstmt);
			}
			
			logger.info("---------------------设置数据库连接会话的用户名JdbcUserContextInterceptor.setUser"+currentUserName);

		}
	}

}