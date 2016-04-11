/**
 * 
 */
package com.alpha.puyinapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.util.JudgePhoneNumber;

/**
 * @author Simon
 * @category第二个注册页面 2016.3.15
 */
public class SecondRegisterActivity extends Activity {

    /*
     * 
     * Simon's mob APPKEY
     */
    int i = 30;
    String APPKEY = "108aec10caf20";
    String APPSECRETE = "b5527755d1849eec235d13858f7b1499";

    private TextView backTextView;
    private EditText editText;
    private Button completeButton;
    private Button verificationcodeButton;
    private TextView verificationcodeTextView;
    private EditText passwordEditText;
    private EditText secondpasswordEditText;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.secondregister);
        completeButton = (Button) findViewById(R.id.bt_complete);
        verificationcodeButton = (Button) findViewById(R.id.bt_verificationcode);
        editText = (EditText) findViewById(R.id.et_secondregister);
        /*
         * 获取验证码事件间监听
         */
        verificationcodeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (JudgePhoneNumber.judgePhoneNums(editText.getText()
                        .toString())) {
                    verificationcodeButton.setClickable(false);
                    // 2. 通过sdk发送短信验证
                    SMSSDK.getVerificationCode("86", editText.getText()
                            .toString());
                    verificationcodeButton.setText("重新发送(" + i + ")");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (; i > 0; i--) {
                                handler.sendEmptyMessage(-9);
                                if (i <= 0) {
                                    break;
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            handler.sendEmptyMessage(-8);
                        }
                    }).start();
                } else {
                    Toast.makeText(getApplicationContext(), "请输入正确的手机号码",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        backTextView = (TextView) findViewById(R.id.tv_back);

        passwordEditText = (EditText) findViewById(R.id.et_password);
        secondpasswordEditText = (EditText) findViewById(R.id.et_secondpassword);

        verificationcodeTextView = (TextView) findViewById(R.id.et_verificationcode);
        // 先设置验证码不可点击

        // verificationCode();
        /*
         * intent 传值 1.在另一个activity设置新建intent对象 intent.putExtra("phoneNumber",
         * phonenums); 键值对传值 2.在这个activity 调用方法获取键 String phonenums =
         * getIntent().getExtras().getString("phoneNumber");
         */
        final String phoneNums = getIntent().getExtras().getString(
                "phoneNumber");
        editText.setText(phoneNums);
        // 启动短信验证sdk
        SMSSDK.initSDK(this, APPKEY, APPSECRETE);
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                handler.sendMessage(msg);
            }
        };
        // 注册回调监听接口
        SMSSDK.registerEventHandler(eventHandler);
        /*
         * 返回事件监听
         */
        backTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SecondRegisterActivity.this.finish();
            }
        });
        /*
         * 获取再次输入密码事件监听
         */
        secondpasswordEditText.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String password = passwordEditText.getText().toString().trim();
                if (password.equals("") && password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "请输入长度大于6的密码",
                            Toast.LENGTH_SHORT).show();
                    secondpasswordEditText.setFocusable(false);
                } else {
                    secondpasswordEditText.setFocusable(true);
                }
            }
        });

        /*
         * 完成注册 事件监听
         */
        completeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                /*
                 * 
                 * 输入框的值
                 */

                String phoneNumber = editText.getText().toString();
                String verficationCode = verificationcodeTextView.getText()
                        .toString();
                String passWord = passwordEditText.getText().toString();
                String secondpassWord = secondpasswordEditText.getText()
                        .toString();

                SMSSDK.submitVerificationCode("86", editText.getText()
                        .toString(), verificationcodeTextView.getText()
                        .toString());
                if (isEmpty(phoneNumber, verficationCode, passWord,
                        secondpassWord, event)) {
                    Intent intent = new Intent(SecondRegisterActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    int event;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == -9) {
                verificationcodeButton.setText("重新发送(" + i + ")");
            } else if (msg.what == -8) {
                verificationcodeButton.setText("获取验证码");
                verificationcodeButton.setClickable(true);
                i = 30;
            } else {
                event = msg.arg1;
                int result = msg.arg2;
                Object data = msg.obj;
                Log.e("event", "event=" + event);
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 短信注册成功后，返回MainActivity,然后提示
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功
                        Toast.makeText(getApplicationContext(), "提交验证码成功",
                                Toast.LENGTH_SHORT).show();

                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        Toast.makeText(getApplicationContext(), "正在获取验证码",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        ((Throwable) data).printStackTrace();
                    }
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        SMSSDK.unregisterAllEventHandler();
        super.onDestroy();
    }

    private boolean isEmpty(String phoneNumber, String verificationCode,
            String passWord, String secondpassWord, int event)

    {
        if (TextUtils.isEmpty(phoneNumber)) {
            Toast.makeText(getApplicationContext(), "请输入手机号码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(verificationCode)) {
            Toast.makeText(getApplicationContext(), "请输入验证码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(passWord)) {
            Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
        if (TextUtils.isEmpty(secondpassWord)) {
            Toast.makeText(getApplicationContext(), "请再次输入密码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!passWord.equals(secondpassWord)) {
            Toast.makeText(getApplicationContext(), "两次输入的密码不一致",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (passWord.trim().length() < 6) {
            Toast.makeText(getApplicationContext(), "您输入的密码长度小于6",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!JudgePhoneNumber.judgePhoneNums(phoneNumber)) {

            Toast.makeText(getApplicationContext(), "请输入正确的手机号码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE)) {
            Toast.makeText(getApplicationContext(), "验证码错误", Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
        return true;

    }
}
