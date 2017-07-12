package edu.mvcdemo.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

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

}
