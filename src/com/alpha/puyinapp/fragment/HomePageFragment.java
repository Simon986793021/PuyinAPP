package com.alpha.puyinapp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.alpha.extra.HomeBanner;
import com.alpha.puyinapp.R;
import com.alpha.puyinapp.activity.JewelryActivity;
import com.alpha.puyinapp.activity.SilverActivity;
import com.alpha.puyinapp.activity.SilvergiftActivity;
import com.alpha.puyinapp.activity.ToolActivity;
import com.alpha.puyinapp.base.BaseFragment;

/**
 * 
 * 
 * @author Simon
 * @category 首页
 */
public class HomePageFragment extends BaseFragment implements
        OnItemClickListener {
    private HomeBanner banner;
    private GridView gridView;
    private GridView gridView2;
    private int[] res;
    private String[] titles;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    // Spinner数据源
    private final String[] Sp_Texts = { "银饰-项链推荐款", "银饰-手镯推荐款", "银饰-耳环推荐款",
            "银饰-戒指推荐款", };
    // GridView的数据源
    private final String[] Texts = { "银饰", "银礼", "珠宝", "打金工具" };
    private final int[] Images = { R.drawable.silver1, R.drawable.silver2,
            R.drawable.silver3, R.drawable.silver4, };
    // GridView2的数据源
    private final String[] gv_slivername = { "恒久之星", "GIA裸砖", "恒久之星", "恒久之星", };
    private final String[] gv_silverinfor = { "珠宝钻戒 女款18K", "诗华珠宝 GIA裸钻",
            "铂金钻石戒指", "恒久之星珠宝钻石吊坠" };
    private final String[] gv_silverprice = { "￥9999", "￥9999", "￥9999",
            "￥9999" };
    private final int[] gv_silverpicture = { R.drawable.silver1,
            R.drawable.silver2, R.drawable.silver3, R.drawable.silver4, };

    @SuppressLint("NewApi")
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.homepage, container, false);

        res = new int[] { R.drawable.viewpager, R.drawable.viewpager,
                R.drawable.viewpager, R.drawable.viewpager };
        titles = new String[] { "lalal1", "lalal2", "lalal3", "lalal4" };
        banner = (HomeBanner) view.findViewById(R.id.banner);
        gridView = (GridView) view.findViewById(R.id.gridview);
        spinner = (Spinner) view.findViewById(R.id.sp_homepage);
        gridView2 = (GridView) view.findViewById(R.id.gd_homepage);
        gridView.setOnItemClickListener(this);

        banner.setImagesRes(res, titles);

        /*
         * GridView simpleadapter适配数据
         */
        gridView.setAdapter(new SimpleAdapter(getActivity(), getData(),
                R.layout.gridview_item, new String[] { "images", "text" },
                new int[] { R.id.gridview_imageview, R.id.gridview_textview }));
        /*
         * 
         * Spinner arrayadapter适配数据
         */

        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, Sp_Texts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        /*
         * GridView2 simpleadapter适配数据
         */
        gridView2.setAdapter(new SimpleAdapter(getActivity(), getData2(),
                R.layout.silver_gridview_item, new String[] { "silvername",
                        "silverinfo", "silverprice", "silverpicture" },
                new int[] { R.id.tv_gridview_item1, R.id.tv_gridview_item2,
                        R.id.tv_gridview_item3, R.id.iv_gridview_item }));

        return view;

    }

    /**
     * @return
     */
    private List<Map<String, Object>> getData2() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list2 = new ArrayList<>();

        for (int i = 0; i < gv_silverinfor.length; i++) {
            Map<String, Object> map2 = new HashMap<>();
            map2.put("silvername", gv_slivername[i]);
            map2.put("silverinfo", gv_silverinfor[i]);
            map2.put("silverprice", gv_silverprice[i]);
            map2.put("silverpicture", gv_silverpicture[i]);
            list2.add(map2);
        }

        return list2;
    }

    /**
     * GridView集合加载数据
     */
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < Texts.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("images", Images[i]);
            map.put("text", Texts[i]);
            list.add(map);
        }

        // TODO Auto-generated method stub
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
        switch (Images[position]) {
        case R.drawable.silver1:
            startActivity(new Intent(getActivity(), SilverActivity.class));

            break;
        case R.drawable.silver2:
            startActivity(new Intent(getActivity(), SilvergiftActivity.class));

            break;
        case R.drawable.silver3:
            startActivity(new Intent(getActivity(), JewelryActivity.class));

            break;
        case R.drawable.silver4:
            startActivity(new Intent(getActivity(), ToolActivity.class));

            break;

        default:
            break;
        }

    }
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.alpha.extra.HomeBanner.OnItemClickListener#click(android.view.View,
     * com.alpha.extra.TopBannerEntity)
     */

}
