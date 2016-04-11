/**
 * 
 */
package com.alpha.puyinapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.alpha.puyinapp.R;

/**
 * @author Simon
 * @category登录页面 2016.3.15
 */
public class LoginActivity extends Activity {
    private TextView backTextView;
    private TextView registerTextView;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.login);
        backTextView = (TextView) findViewById(R.id.tv_back);
        registerTextView = (TextView) findViewById(R.id.tv_register);
        loginButton = (Button) findViewById(R.id.bt_login);

        /*
         * 返回的监听事件
         */
        backTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                LoginActivity.this.finish();
            }
        });
        /*
         * 注册的监听事件
         */
        registerTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(LoginActivity.this,
                        RegisterActivity.class));
            }
        });
    }
}
