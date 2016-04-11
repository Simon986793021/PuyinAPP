package com.alpha.puyinapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.base.BaseFragment;

/**
 * 
 * 
 * @author Simon
 * @category购物车页面
 */
public class ShoppingCartFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.shoppingcart, container, false);
    }

}
