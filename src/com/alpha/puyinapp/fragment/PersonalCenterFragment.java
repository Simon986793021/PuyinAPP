package com.alpha.puyinapp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.activity.AddressActivity;
import com.alpha.puyinapp.activity.CollcetActivity;
import com.alpha.puyinapp.activity.LoginActivity;
import com.alpha.puyinapp.activity.MyOrderActivity;
import com.alpha.puyinapp.base.BaseFragment;

/**
 * 
 * 
 * @author Simon
 * @category我的会员中心页面
 */
public class PersonalCenterFragment extends BaseFragment implements
        OnItemClickListener {
    private GridView gridView;
    private ImageView loginImageView;
    private LinearLayout mLinearLayout;

    // 数据源
    private final String[] texts = { "存银", "存款", "收藏", "账号安全", "足迹", "退货",
            "账号管理", "地址管理" };
    private final int[] Images = { R.drawable.cunyin, R.drawable.cunkuan,
            R.drawable.shoucang, R.drawable.anquan, R.drawable.zuji,
            R.drawable.tuihuo, R.drawable.guanli, R.drawable.dizhi };

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.personalcenter, container, false);
        gridView = (GridView) view.findViewById(R.id.gv_personalcenter);
        gridView.setAdapter(new SimpleAdapter(getActivity(), getData(),
                R.layout.personalcenter_gridview_item, new String[] { "texts",
                        "images" }, new int[] {
                        R.id.tv_personalcenter_gridview,
                        R.id.iv_personalcenter_gridview }));
        gridView.setOnItemClickListener(this);
        /*
         * 我的订单点击事件
         */
        mLinearLayout = (LinearLayout) view.findViewById(R.id.ll_order);
        mLinearLayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent orderIntent = new Intent(getActivity(),
                        MyOrderActivity.class);
                startActivity(orderIntent);
            }
        });

        loginImageView = (ImageView) view.findViewById(R.id.iv_login);

        loginImageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        return view;
    }

    /**
     * @return 将数据源加入到adapter
     */
    private List<Map<String, Object>> getData() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < Images.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("texts", texts[i]);
            map.put("images", Images[i]);
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
        /*
         * 跳转到地址页面
         */
        switch (Images[position]) {
        case R.drawable.dizhi:
            Intent intent = new Intent(getActivity(), AddressActivity.class);
            startActivity(intent);
            break;
        /*
         * 跳转至收藏页面
         */
        case R.drawable.shoucang:
            Intent collectintent = new Intent();
            ComponentName componentName = new ComponentName(getActivity(),
                    CollcetActivity.class);
            collectintent.setComponent(componentName);
            startActivity(collectintent);
            break;
        default:
            break;
        }

    }
}
