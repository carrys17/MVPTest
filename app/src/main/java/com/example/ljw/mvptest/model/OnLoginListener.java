package com.example.ljw.mvptest.model;

/**
 * Created by ljw on 17/9/25.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
