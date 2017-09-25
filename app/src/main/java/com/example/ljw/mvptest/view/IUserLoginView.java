package com.example.ljw.mvptest.view;

import android.provider.MediaStore;

/**
 * Created by ljw on 17/9/25.
 */

public interface IUserLoginView {

    String getUsername();
    String getPassword();

    void clearUsername();
    void clearPassword();

    void showLoding();
    void hideLoding();

    void toMainActivity();
    void showFailedMessage();
}
