/**
 * 
 */
package com.alpha.puyinapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.util.JudgePhoneNumber;

/**
 * @author Simon
 * @category 添加新地址
 */
public class AddaddressActivity extends Activity implements OnClickListener {
    private Button button;
    private TextView backTextView;
    private EditText nameEditText;
    private EditText phonenumEditText;
    private EditText zipcodeEditText;
    private EditText addressdetailEditText;
    String name;
    String phonenum;
    String zipcode;
    String addressdetail;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.newaddress);
        init();
        button.setOnClickListener(this);
        backTextView.setOnClickListener(this);

    }

    /**
     * 初始化控件
     */
    private void init() {
        // TODO Auto-generated method stub
        button = (Button) findViewById(R.id.bt_save);
        backTextView = (TextView) findViewById(R.id.tv_back);
        nameEditText = (EditText) findViewById(R.id.et_name);
        phonenumEditText = (EditText) findViewById(R.id.et_phonenum);
        zipcodeEditText = (EditText) findViewById(R.id.et_zipcode);
        addressdetailEditText = (EditText) findViewById(R.id.et_addressdetail);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.tv_back:

            finish();

            break;
        case R.id.bt_save:

            name = nameEditText.getText().toString();
            phonenum = phonenumEditText.getText().toString();
            zipcode = zipcodeEditText.getText().toString();
            addressdetail = addressdetailEditText.getText().toString();
            if (isEmpty(name, phonenum, zipcode, addressdetail)) {
                Intent intentdata = new Intent(AddaddressActivity.this,
                        AddressActivity.class);
                intentdata.putExtra("name", name);
                intentdata.putExtra("phonenum", phonenum);
                intentdata.putExtra("zipcode", zipcode);
                intentdata.putExtra("addressdetail", addressdetail);
                setResult(2, intentdata);
                finish();
            }

        default:
            break;
        }
    }

    private boolean isEmpty(String name, String phonenum, String zipcode,
            String addressdetail) {
        if (!JudgePhoneNumber.judgePhoneNums(phonenum)) {
            Toast.makeText(getApplicationContext(), "请输入正确的手机号码",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "请输入姓名", Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
        if (TextUtils.isEmpty(zipcode)) {
            Toast.makeText(getApplicationContext(), "请输入邮编", Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
        if (TextUtils.isEmpty(addressdetail)) {
            Toast.makeText(getApplicationContext(), "请输入详细地址",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
