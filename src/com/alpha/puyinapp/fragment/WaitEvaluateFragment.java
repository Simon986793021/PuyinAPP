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
 * @category 待评价Fragment
 */
public class WaitEvaluateFragment extends BaseFragment {
    View view;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.alpha.puyinapp.base.BaseFragment#initView(android.view.LayoutInflater
     * , android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.waitevaluate, container, false);
        return view;
    }

}
