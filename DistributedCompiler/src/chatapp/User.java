/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.net.InetAddress;

/**
 *
 * @author zaranaparekh1
 */
public class User {
    protected static String UserName = "My Name";//getUserName();
    protected static String UserIPAddress = "127.0.0.1";//getUserIP();
    protected static int UserPortNumber = 10001;
    public static Boolean online = true;
    
    public User() {
        
    }
    private static String getUserIP() {
        String IPAddress = "";
        try {
            InetAddress localIp = InetAddress.getLocalHost();
            IPAddress = localIp.getHostAddress();
            UserName = localIp.getHostName();
        }
        catch(Exception e) {
            System.out.println("IP Error" + e);
        }
        return IPAddress;
    }
    
    public static String getUserName() {
        String userName = new String();
        try {
            InetAddress localIp = InetAddress.getLocalHost();
            userName = localIp.getHostName();
            System.out.println("username : "+userName);
        }
        catch(Exception e) {
            System.out.println("IP Error" + e);
        }
        return userName;
    }
     
    public static void setUserName(String userName) {
        UserName = userName;
    }
    
    public static int getUserPort() {
        return UserPortNumber;
    }
}
