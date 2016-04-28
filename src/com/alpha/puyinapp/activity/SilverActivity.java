package com.alpha.puyinapp.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.alpha.adapter.MyBaseAdapter;
import com.alpha.puyinapp.R;
import com.alpha.puyinapp.util.NewsBean;

/**
 * @author Simon
 * @category银饰界面 2016/3/6
 * 
 */
public class SilverActivity extends Activity {
    private ListView listView;
    private static String URL = "http://www.puyinwang.com/Puyin/common/good!listByProperty.shtml?type1=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.silver);
        listView = (ListView) findViewById(R.id.lv_silver);
        new MyAsyncTask().execute(URL);
    }

    /*
     * 将url对应的json格式数据转化为我们所封装的newbean对象
     */
    private List<NewsBean> getJsonData(String url) throws JSONException {
        List<NewsBean> list = new ArrayList<>();
        String jsonString = "";
        try {
            jsonString = readString(new java.net.URL(url).openStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        NewsBean newsBean = null;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        jsonObject = jsonObject.getJSONObject("data");
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray = jsonObject.getJSONArray("list");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                jsonObject = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            newsBean = new NewsBean();

            newsBean.picture = jsonObject.getString("goods_image_md5");
            newsBean.name = jsonObject.getString("goodName");
            newsBean.sale = jsonObject.getString("ab_Weight");// 目前好像是没有字段
            newsBean.price = jsonObject.getString("retail_Price");
            list.add(newsBean);
        }
        return list;
    }

    private String readString(InputStream is) {
        InputStreamReader isr = null;
        String result = "";
        String line = "";
        try {
            isr = new InputStreamReader(is, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(isr);
        try {
            while ((line = bufferedReader.readLine()) != null) {
                result += line;

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }

    /*
     * 异步加载
     */
    class MyAsyncTask extends AsyncTask<String, Void, List<NewsBean>> {

        /*
         * 
         * asyncTask 必须重写的方法，在子线程中运行，耗时操作在这里处理
         */
        @Override
        protected List<NewsBean> doInBackground(String... params) {
            // TODO Auto-generated method stub
            List<NewsBean> list = null;
            try {
                list = getJsonData(params[0]);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return list;
        }

        /*
         * 最后默认执行的 将doInBackground返回的参数进行处理
         */
        @Override
        protected void onPostExecute(List<NewsBean> result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            MyBaseAdapter myBaseAdapter = new MyBaseAdapter(
                    SilverActivity.this, result);
            listView.setAdapter(myBaseAdapter);

        }
    }

}
