package com.example.ljw.mvptest.model;

/**
 * Created by ljw on 17/9/25.
 */

public interface IUserBiz {
    void login(String username,String password,OnLoginListener loginListener);
}
