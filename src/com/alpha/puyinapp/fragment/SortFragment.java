package com.alpha.puyinapp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.activity.OrderListActivity;
import com.alpha.puyinapp.base.BaseFragment;

/**
 * 
 * @author Simon
 * @category分类页面 2016.3.21
 */
public class SortFragment extends BaseFragment implements OnClickListener,
        OnItemClickListener {
    private GridView sortgGridView;
    private ImageView picImageView;
    private TextView textView;
    private TextView goldTextView;
    private TextView investinggoldTextView;
    private TextView kgoldTextView;
    private TextView birkinTextView;
    private TextView colorfulgoldTextView;
    private TextView jadeTextView;
    private TextView silverTextView;
    SimpleAdapter adapter;
    List<Map<String, Object>> list;
    Map<String, Object> map;
    TextView textarray[] = {};

    String[] text = new String[] { "黄金", "黄金", "黄金", "黄金", "黄金", "黄金", "黄金",
            "黄金", "黄金", "黄金" };
    int[] image = new int[] { R.drawable.silver1, R.drawable.silver1,
            R.drawable.silver1, R.drawable.silver1, R.drawable.silver1,
            R.drawable.silver1, R.drawable.silver1, R.drawable.silver1,
            R.drawable.silver1, R.drawable.silver1 };
    View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.sort, container, false);
        init();
        textarray = new TextView[] { goldTextView, investinggoldTextView,
                kgoldTextView, birkinTextView, colorfulgoldTextView,
                jadeTextView, silverTextView };
        /*
         * 设置第一个textview的颜色
         */
        setclickcolor(0);
        setnormalcolor(1, 2, 3, 4, 5, 6);

        setInvents();
        list = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            map = new HashMap<>();
            map.put("picture", image[i]);
            map.put("text", text[i]);
            list.add(map);
        }
        adapter = new SimpleAdapter(getActivity(), list,
                R.layout.gridview_sort_item,
                new String[] { "picture", "text" }, new int[] {
                        R.id.iv_picture, R.id.tv_text });
        sortgGridView.setAdapter(adapter);
        sortgGridView.setOnItemClickListener(this);

        return view;
    }

    /**
     * 设置监听事件
     */
    private void setInvents() {
        // TODO Auto-generated method stub
        goldTextView.setOnClickListener(this);
        investinggoldTextView.setOnClickListener(this);
        kgoldTextView.setOnClickListener(this);
        birkinTextView.setOnClickListener(this);
        colorfulgoldTextView.setOnClickListener(this);
        jadeTextView.setOnClickListener(this);
        silverTextView.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void init() {
        // TODO Auto-generated method stub
        sortgGridView = (GridView) view.findViewById(R.id.gv_sort);
        picImageView = (ImageView) view.findViewById(R.id.iv_picture);
        textView = (TextView) view.findViewById(R.id.tv_text);
        goldTextView = (TextView) view.findViewById(R.id.tv_gold);
        investinggoldTextView = (TextView) view
                .findViewById(R.id.tv_investing_gold);
        kgoldTextView = (TextView) view.findViewById(R.id.tv_Kgold);
        birkinTextView = (TextView) view.findViewById(R.id.tv_birkin);
        colorfulgoldTextView = (TextView) view
                .findViewById(R.id.tv_colorful_gold);
        jadeTextView = (TextView) view.findViewById(R.id.tv_jade);
        silverTextView = (TextView) view.findViewById(R.id.tv_silver);
    }

    /*
     * (non-Javadoc)
     * 
     * 需要根据点击的事件适配不同的数据，布局是一样的
     * 
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */

    // String text[] = {};

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {
        /*
         * 黄金首饰事件
         */
        case R.id.tv_gold:
            setclickcolor(0);
            setnormalcolor(1, 2, 3, 4, 5, 6);
            list.clear();
            for (int j = 0; j < 20; j++) {
                map.put("picture", R.drawable.silver3);
                map.put("text", "黄金");
                list.add(map);

            }

            adapter.notifyDataSetChanged();
            break;
        /*
         * 投资黄金事件
         */
        case R.id.tv_investing_gold:
            setclickcolor(1);
            setnormalcolor(0, 2, 3, 4, 5, 6);
            list.clear();
            for (int j = 0; j < 20; j++) {
                map.put("picture", R.drawable.silver3);
                map.put("text", "投资黄金");
                list.add(map);

            }

            adapter.notifyDataSetChanged();
            break;
        /*
         * K金首饰事件
         */
        case R.id.tv_Kgold:
            setclickcolor(2);
            setnormalcolor(0, 1, 3, 4, 5, 6);
            list.clear();
            for (int j = 0; j < 20; j++) {
                map.put("picture", R.drawable.silver3);
                map.put("text", "K金首饰");
                list.add(map);

            }

            adapter.notifyDataSetChanged();
            break;
        /*
         * 铂金首饰事件
         */
        case R.id.tv_birkin:
            setclickcolor(3);
            setnormalcolor(0, 1, 2, 4, 5, 6);
            list.clear();
            for (int j = 0; j < 20; j++) {
                map.put("picture", R.drawable.silver3);
                map.put("text", "铂金");
                list.add(map);

            }

            adapter.notifyDataSetChanged();

            break;
        /*
         * 彩宝首饰事件
         */
        case R.id.tv_colorful_gold:

            setclickcolor(4);
            setnormalcolor(0, 1, 2, 3, 5, 6);
            list.clear();
            for (int j = 0; j < 20; j++) {
                map.put("picture", R.drawable.silver3);
                map.put("text", "彩宝首饰");
                list.add(map);

            }

            adapter.notifyDataSetChanged();
            break;
        /*
         * 翡翠玉石事件
         */
        case R.id.tv_jade:
            setclickcolor(5);
            setnormalcolor(1, 2, 3, 4, 6, 0);
            list.clear();
            for (int j = 0; j < 20; j++) {
                map.put("picture", R.drawable.silver3);
                map.put("text", "翡翠玉石");
                list.add(map);

            }

            adapter.notifyDataSetChanged();
            break;
        /*
         * 
         * 纯银首饰事件
         */
        case R.id.tv_silver:
            setclickcolor(6);
            setnormalcolor(0, 1, 2, 3, 4, 5);
            list.clear();
            for (int j = 0; j < 20; j++) {
                map.put("picture", R.drawable.silver3);
                map.put("text", "纯银首饰");
                list.add(map);

            }

            adapter.notifyDataSetChanged();
            break;

        default:
            break;
        }

    }

    private void setclickcolor(int i) {
        textarray[i].setTextColor(Color.CYAN);

    }

    private void setnormalcolor(int a, int b, int c, int d, int f, int e) {
        textarray[a].setTextColor(Color.DKGRAY);
        textarray[b].setTextColor(Color.DKGRAY);
        textarray[c].setTextColor(Color.DKGRAY);
        textarray[d].setTextColor(Color.DKGRAY);
        textarray[e].setTextColor(Color.DKGRAY);
        textarray[f].setTextColor(Color.DKGRAY);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget
     * .AdapterView, android.view.View, int, long)
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(getActivity(), OrderListActivity.class);
        intent.putExtra("index", position);
        startActivity(intent);
    }

}
