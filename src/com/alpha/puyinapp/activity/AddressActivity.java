/**
 * 
 */
package com.alpha.puyinapp.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.alpha.puyinapp.R;

/**
 * @author Simon
 * @category 地址管理页面 2016.3.19
 */
public class AddressActivity extends Activity {
    private Button button;
    private TextView backTextView;
    ListView listView;
    String name;
    String phonenum;
    String addressdetail;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.address_manage);
        button = (Button) findViewById(R.id.bt_newaddress);
        listView = (ListView) findViewById(R.id.lv_address);
        backTextView = (TextView) findViewById(R.id.tv_back);
        /*
         * 点击返回事件
         */
        backTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        /*
         * 点击添加新地址事件
         */
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(AddressActivity.this,
                        AddaddressActivity.class);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            name = data.getStringExtra("name");
            phonenum = data.getStringExtra("phonenum");
            addressdetail = data.getStringExtra("addressdetail");
            listView.setAdapter(new SimpleAdapter(getApplicationContext(),
                    getDatabasePath(), R.layout.address_item, new String[] {
                            "name", "phonenum", "addressdetail" }, new int[] {
                            R.id.tv_name, R.id.tv_phonenum, R.id.tv_address }));
        }
    }

    /**
     * @return
     */
    private List<Map<String, Object>> getDatabasePath() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("phonenum", phonenum);
        map.put("addressdetail", addressdetail);
        list.add(map);

        return list;
    }
}
