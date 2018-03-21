package com.test.vo;

public class User_vo {
    String userName;
    String userPwd;

    public User_vo(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User_vo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
