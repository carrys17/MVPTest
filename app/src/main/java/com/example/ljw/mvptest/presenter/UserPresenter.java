package com.example.ljw.mvptest.presenter;

import android.os.Handler;

import com.example.ljw.mvptest.model.IUserBiz;
import com.example.ljw.mvptest.model.OnLoginListener;
import com.example.ljw.mvptest.model.User;
import com.example.ljw.mvptest.model.UserBiz;
import com.example.ljw.mvptest.view.IUserLoginView;



/**
 * Created by ljw on 17/9/25.
 */

public class UserPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserPresenter(IUserLoginView loginView){
        this.userLoginView = loginView;
        this.userBiz = new UserBiz();
    }

    public void login(){
        userLoginView.showLoding();

        userBiz.login(userLoginView.getUsername(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity();
                        userLoginView.hideLoding();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedMessage();
                        userLoginView.hideLoding();
                    }
                });
            }
        });
    }

    public void clear(){
        userLoginView.clearPassword();
        userLoginView.clearUsername();
    }
}
