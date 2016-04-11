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
import android.widget.EditText;
import android.widget.TextView;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.util.JudgePhoneNumber;

/**
 * @author Simon
 * @category注册页面 2016.3.15
 */
public class RegisterActivity extends Activity {
    private TextView backTextView;
    private Button nextButton;
    public EditText phonenumsEditText;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.register);
        backTextView = (TextView) findViewById(R.id.tv_back);
        backTextView.setClickable(false);
        nextButton = (Button) findViewById(R.id.bt_next);
        nextButton.setClickable(false);
        phonenumsEditText = (EditText) findViewById(R.id.et_phonenums);
        /*
         * 返回时间监听
         */
        backTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                RegisterActivity.this.finish();
            }
        });
        /*
         * 
         * 下一步按钮事件监听
         */
        nextButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String phonenums = phonenumsEditText.getText().toString();
                if (JudgePhoneNumber.judgePhoneNums(getApplicationContext(),
                        phonenums)) {
                    Intent intent = new Intent(RegisterActivity.this,
                            SecondRegisterActivity.class);
                    intent.putExtra("phoneNumber", phonenums);
                    startActivity(intent);
                }
            }
        });

    }
}
