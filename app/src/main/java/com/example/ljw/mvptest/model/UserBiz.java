package com.example.ljw.mvptest.model;

/**
 * Created by ljw on 17/9/25.
 */

public class UserBiz implements IUserBiz {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (username.equals("carrys17")&&password.equals("123456")){
                    User user = new User();
                    user.setUsrname(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else {
                    loginListener.loginFailed();
                }

            }
        }.start();

    }
}
