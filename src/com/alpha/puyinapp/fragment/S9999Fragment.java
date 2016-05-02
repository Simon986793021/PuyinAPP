/**
 * 
 */
package com.alpha.puyinapp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.activity.S9999Activity;

/**
 * @author Simon
 * @category 万足银页面
 */
public class S9999Fragment extends Fragment implements OnItemClickListener {
    private GridView gridView;
    private final String[] textStrings = { "项链", "戒指", "珠宝", "耳饰", "吊坠",
            "大人手镯", "宝宝手镯", "手链", "首饰包装", "首饰道具", "银餐具", "银条", "银摆件", "银料",
            "打金工具", "打金模具" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.s9999, container, false);
        gridView = (GridView) view.findViewById(R.id.gv_wanzu);
        gridView.setAdapter(new SimpleAdapter(getActivity(), getData(),
                R.layout.s9999_gridview_item, new String[] { "image", "text" },
                new int[] { R.id.iv_s9999, R.id.tv_s9999 }));
        gridView.setOnItemClickListener(this);
        return view;
    }

    /**
     * @return
     */
    private List<Map<String, Object>> getData() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < textStrings.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", R.drawable.sort1);
            map.put("text", textStrings[i]);
            list.add(map);
        }
        return list;
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
        Intent intent = new Intent(getActivity(), S9999Activity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
