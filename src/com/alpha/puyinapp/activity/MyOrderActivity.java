/**
 * 
 */
package com.alpha.puyinapp.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.alpha.adapter.TabAdapter;
import com.alpha.puyinapp.R;
import com.alpha.puyinapp.fragment.AllOrderFragment;
import com.alpha.puyinapp.fragment.ObligationFragment;
import com.alpha.puyinapp.fragment.WaitDeliveryFragment;
import com.alpha.puyinapp.fragment.WaitEvaluateFragment;
import com.alpha.puyinapp.fragment.WaitReceiveFragment;
import com.viewpagerindicator.TabPageIndicator;

/**
 * @author Simon
 * @category我的订单页面
 */
public class MyOrderActivity extends FragmentActivity {
    private TextView backTextView;
    private ViewPager mViewPager;
    private TabPageIndicator mTabPageIndicator;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private ViewPager mviViewPager;
    private TabAdapter mTabAdapter;
    private AllOrderFragment allOrderFragment;
    private ObligationFragment obligationFragment;
    private WaitDeliveryFragment waitDeliveryFragment;
    private WaitEvaluateFragment waitEvaluateFragment;
    private WaitReceiveFragment waitReceiveFragment;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.myorder);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        backTextView = (TextView) findViewById(R.id.tv_back);
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
        mFragmentList = new ArrayList<Fragment>();
        allOrderFragment = new AllOrderFragment();
        obligationFragment = new ObligationFragment();
        waitDeliveryFragment = new WaitDeliveryFragment();
        waitEvaluateFragment = new WaitEvaluateFragment();
        waitReceiveFragment = new WaitReceiveFragment();
        mFragmentList.add(allOrderFragment);
        mFragmentList.add(obligationFragment);
        mFragmentList.add(waitDeliveryFragment);
        mFragmentList.add(waitReceiveFragment);
        mFragmentList.add(waitEvaluateFragment);
        mTabAdapter = new TabAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mTabAdapter);
        mViewPager.setCurrentItem(0);
        mTabPageIndicator.setViewPager(mViewPager, 0);

        backTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
