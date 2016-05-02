/**
 * 
 */
package com.alpha.puyinapp.util;

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

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.alpha.adapter.MyBaseAdapter;
import com.alpha.puyinapp.activity.NecklaceActivity;

/**
 * @author Simon
 */
public class MyAsyncTask extends AsyncTask<String, Void, List<NewsBean>> {

    private final ListView listView;
    private final Context context;

    public MyAsyncTask(ListView listView, Context context) {
        this.listView = listView;
        this.context = context;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.os.AsyncTask#doInBackground(java.lang.Object[])
     */
    @Override
    protected List<NewsBean> doInBackground(String... params) {
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
     * 
     * 
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

    @Override
    protected void onPostExecute(List<NewsBean> result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(context, result);
        listView.setAdapter(myBaseAdapter);

    }

}
