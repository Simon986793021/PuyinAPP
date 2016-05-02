/**
 * 
 */
package com.alpha.puyinapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.util.MyAsyncTask;

/**
 * @author Simon
 * @category 珠宝页面 2016.3.11
 */
public class JewelryActivity extends Activity implements OnClickListener {
    private ListView listView;
    private TextView textView;
    private static String URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?type1=102";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jewelry);
        listView = (ListView) findViewById(R.id.lv_silver);
        textView = (TextView) findViewById(R.id.tv_back);
        textView.setOnClickListener(this);
        new MyAsyncTask(listView, JewelryActivity.this).execute(URL);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        finish();
    }

}
