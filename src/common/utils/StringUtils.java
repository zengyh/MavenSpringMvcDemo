package common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-9 下午2:56:21
 * @文件描述: todo
 */
public class StringUtils {
	
    /**
     * 获取异常信息
     *
     * @param e
     * @return
     */
    public static String getExceptionMessage(Exception e) {

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);

        return stringWriter.toString();
    }
    

    /**
     * 返回web项目的context path，格式 为：协议://服务器IP或服务器主机名:端口号/项目的Context ROOT
     * @param request
     * @return
     */
    public static String getWebContextPath(HttpServletRequest request){
		StringBuilder webContextPathBuilder = new StringBuilder();
		webContextPathBuilder.append(request.getScheme())
		                     .append("://")
		                     .append(request.getServerName())
		                     .append(":")
		                     .append(request.getServerPort())
		                     .append(request.getContextPath());
		return webContextPathBuilder.toString();
    }
    
    /**
     * 判断字符串中是否包含代码注入的特殊符号
     * @param str
     * @return
     */
    public static boolean isCodeInject(String str){
    	String regEx = "^select\\s|\\sselect\\s|^update\\s|\\supdate\\s|^delete\\s|\\sdelete\\s|^exec\\s|\\sexec\\s|^insert\\s|\\sinsert\\s|^drop\\s|\\sdrop\\s|\\'|%|--|#|;|>|<";
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(str);
        return m.find();
    }
    
}
