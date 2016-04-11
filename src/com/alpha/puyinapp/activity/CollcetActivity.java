/**
 * 
 */
package com.alpha.puyinapp.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alpha.puyinapp.R;

/**
 * @author Simon
 * @category 收藏页面 2016.3.28
 */
public class CollcetActivity extends Activity implements OnClickListener {
    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    private ListView listView;
    private List<Map<String, Object>> data;
    private ImageView goodsImageView;
    private TextView nameTextView;
    private TextView priceTextView;
    private TextView backTextView;
    private TextView deleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collcet);
        listView = (ListView) findViewById(R.id.lv_collect);
        data = getData();
        Myadapter adapter = new Myadapter(this);
        listView.setAdapter(adapter);
        backTextView = (TextView) findViewById(R.id.tv_back);
        deleTextView = (TextView) findViewById(R.id.tv_delete);
        backTextView.setOnClickListener(this);
        deleTextView.setOnClickListener(this);
    }

    /*
     * list集合
     */
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("picture", R.drawable.silver2);
            map.put("name", "CRD克徕帝六爪结婚钻戒30分50分1克拉钻石求婚戒指女戒正品挚爱");
            map.put("price", "￥5999");
            list.add(map);
        }
        return list;

    }

    class Myadapter extends BaseAdapter {
        private LayoutInflater inflater = null;

        /*
         * (non-Javadoc)
         * 
         * @see android.widget.Adapter#getCount()
         */
        private Myadapter(Context context) {
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return data.size();
        }

        /*
         * (non-Javadoc)
         * 
         * @see android.widget.Adapter#getItem(int)
         */
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        /*
         * (non-Javadoc)
         * 
         * @see android.widget.Adapter#getItemId(int)
         */
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        /*
         * (non-Javadoc)
         * 
         * @see android.widget.Adapter#getView(int, android.view.View,
         * android.view.ViewGroup)
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            convertView = inflater
                    .inflate(R.layout.listview_collect_item, null);
            goodsImageView = (ImageView) convertView
                    .findViewById(R.id.iv_collect_goods);
            nameTextView = (TextView) convertView
                    .findViewById(R.id.tv_collect_goodsname);
            priceTextView = (TextView) convertView
                    .findViewById(R.id.tv_collect_goodsprice);
            /*
             * 将data放入view中
             */
            goodsImageView.setBackgroundResource((Integer) data.get(position)
                    .get("picture"));
            nameTextView.setText((String) data.get(position).get("name"));
            priceTextView.setText((String) data.get(position).get("price"));
            return convertView;
        }
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
        case R.id.tv_delete:
            data = null;
        default:
            break;
        }
    }
}
