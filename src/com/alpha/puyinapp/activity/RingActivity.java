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
 * @category 戒指页面2016.4.28
 */
public class RingActivity extends Activity implements OnClickListener {
    private ListView listView;
    private TextView textView;
    private static String URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?type1=3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ring);
        listView = (ListView) findViewById(R.id.lv_silver);
        textView = (TextView) findViewById(R.id.tv_back);
        textView.setOnClickListener(this);
        new MyAsyncTask(listView, RingActivity.this).execute(URL);
    }

    /*
     * 将url对应的json格式数据转化为我们所封装的newbean对象
     */

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        finish();
    }

}
