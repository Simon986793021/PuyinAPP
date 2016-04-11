/**
 * 
 */
package com.alpha.puyinapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.base.BaseFragment;

/**
 * @author Simon
 * @category待发货页面
 */
public class WaitDeliveryFragment extends BaseFragment {
    View view;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.waitdelivery, container, false);
        return view;
    }

}
