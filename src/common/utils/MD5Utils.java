package common.utils;

import java.security.MessageDigest;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-10-13 下午9:41:53
 * @文件描述: MD5加密
 */
public class MD5Utils {

	private final static String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"}; 
    
    public static String encode(String str){ 
        if (str!=null) { 
            try { 
                MessageDigest md5 = MessageDigest.getInstance("MD5"); 
                byte[] results = md5.digest(str.getBytes()); 
                String result = byteArrayToHexString(results); 
                return result; 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
        } 
        return null; 
    } 
 
    /** 
    * 轮换字节数组为十六进制字符串 
    * @param b 字节数组 
    * @return 十六进制字符串 
    */ 
    private static String byteArrayToHexString(byte[] b){ 
        StringBuffer resultSb = new StringBuffer(); 
        for(int i=0;i<b.length;i++){ 
            resultSb.append(byteToHexString(b[i])); 
        } 
        return resultSb.toString(); 
    } 
 
    //将一个字节转化成十六进制形式的字符串 
    private static String byteToHexString(byte b){ 
        int n = b; 
        if(n<0){
        	n=256+n; 
        }
        int d1 = n/16; 
        int d2 = n%16; 
        return hexDigits[d1] + hexDigits[d2]; 
    } 
    
    
    public static void main(String args[]){
    	System.out.println(encode("123112412412"));
    	System.out.println(encode("1231124124121111111111111111111111123444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444sf afsd           44"));
    }
}
