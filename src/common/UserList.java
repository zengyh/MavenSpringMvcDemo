package common;

import java.util.Enumeration;
import java.util.Vector;
import edu.mvcdemo.model.UserInfo;

/**
 * 文件名称: UserList.java
 * 编写人: yh.zeng
 * 编写时间: 17-1-5 下午7:48
 * 文件描述: 已登录的用户列表（在线用户列表）
 */
public class UserList
{
    private static UserList userList = new UserList();

    private Vector<UserInfo>  v = null;


    private UserList(){
        v = new Vector<UserInfo>();
    }


    public static UserList getInstance(){
        return userList;
    }


    public void addUser(UserInfo user){
        if(user != null && !v.contains(user)){
            v.add(user);
        }
    }

    public void removeUser(UserInfo user){
        if(user != null){
            v.remove(user);
        }
    }

    public Enumeration<UserInfo>  getUserList(){
        return v.elements();
    }

    public int getUserCount(){
        return v.size();
    }

}
