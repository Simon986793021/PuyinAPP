/**
 * 
 */
package com.alpha.puyinapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.util.MyAsyncTask;

/**
 * @author Simon
 * @category 万足金的页面
 */
public class S9999Activity extends Activity {
    public static String URL;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s9999_necklace);
        listView = (ListView) findViewById(R.id.lv_s9999);
        /*
         * 根据点击的item，加载不同的数据
         */
        int position = getIntent().getExtras().getInt("position");// 点击gridview
                                                                  // item的的位置
        switch (position) {
        case 0:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=1";
            break;
        case 1:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=3";
        case 2:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=102";
            break;
        case 3:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=4";
            break;
        case 4:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=2";
            break;
        case 5:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=5";
            break;
        case 6:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=6";
            break;
        case 7:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=117";
            break;
        case 8:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=103";
            break;
        case 9:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=104";
            break;
        case 10:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=100";
            break;
        case 11:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=101";
            break;
        case 12:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=98";
            break;
        case 13:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=107";
            break;
        case 14:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=105";
            break;
        case 15:
            URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?quality=w&type1=106";
            break;

        default:
            break;
        }

        new MyAsyncTask(listView, S9999Activity.this).execute(URL);

        // Toast.makeText(S9999Activity.this, position,
        // Toast.LENGTH_SHORT).show();
    }
}
