package com.alpha.puyinapp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.alpha.adapter.OrderListFragmentPagerAdapter;
import com.alpha.puyinapp.R;
import com.viewpagerindicator.TabPageIndicator;

/**
 * @author Simon
 * @category商品列表页面 2016.3.24
 */
public class OrderListActivity extends FragmentActivity implements
        OnClickListener {
    // index为分类页面gridview的索引，根据点击不同的分类获取不同的数据
    // int index = getIntent().getExtras().getInt("index");
    private OrderListFragmentPagerAdapter orderListFragmentPagerAdapter;
    private ViewPager viewPager;
    private TabPageIndicator tabPageIndicator;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderlist);
        init();
        textView.setOnClickListener(this);

    }

    /**
     * 
     */
    private void init() {
        // TODO Auto-generated method stub
        tabPageIndicator = (TabPageIndicator) findViewById(R.id.id_tabpageindicator);
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);
        textView = (TextView) findViewById(R.id.tv_back);
        // viewPager.setOffscreenPageLimit(1);
        orderListFragmentPagerAdapter = new OrderListFragmentPagerAdapter(
                getSupportFragmentManager());

        viewPager.setAdapter(orderListFragmentPagerAdapter);

        tabPageIndicator.setViewPager(viewPager, 0);

    }

    /*
     * (non-Javadoc)
     * 
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        finish();
    }
}
