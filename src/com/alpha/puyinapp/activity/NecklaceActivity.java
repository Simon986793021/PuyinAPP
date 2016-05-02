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
 * @category银饰界面 2016/3/6
 * 
 */
public class NecklaceActivity extends Activity implements OnClickListener {
    private ListView listView;
    private TextView textView;
    private static String URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?type1=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.necklace);
        listView = (ListView) findViewById(R.id.lv_silver);
        textView = (TextView) findViewById(R.id.tv_back);
        textView.setOnClickListener(this);
        new MyAsyncTask(listView, NecklaceActivity.this).execute(URL);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        finish();
    }

}
