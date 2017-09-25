package com.example.ljw.mvptest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ljw.mvptest.R;
import com.example.ljw.mvptest.model.User;
import com.example.ljw.mvptest.presenter.UserPresenter;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView{

    private EditText usernameEt,passwordEt;
    private Button clearBtn,loginBtn;
    private ProgressBar progressBar;

    // 记得初始化
    UserPresenter mUserPresent = new UserPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        usernameEt = (EditText) findViewById(R.id.editText);
        passwordEt = (EditText) findViewById(R.id.editText2);
        clearBtn = (Button) findViewById(R.id.button2);
        loginBtn = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserPresent.login();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserPresent.clear();
            }
        });

    }

    @Override
    public String getUsername() {
        return usernameEt.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return passwordEt.getText().toString().trim();
    }

    @Override
    public void clearUsername() {
        usernameEt.setText("");
    }

    @Override
    public void clearPassword() {
        passwordEt.setText("");
    }

    @Override
    public void showLoding() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoding() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(UserLoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMessage() {
        Toast.makeText(UserLoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
    }
}
