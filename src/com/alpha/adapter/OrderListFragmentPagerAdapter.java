/**
 * 
 */
package com.alpha.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alpha.puyinapp.fragment.OrderListTabFragment;

/**
 * @author Simon 2016.3.24
 */
public class OrderListFragmentPagerAdapter extends FragmentPagerAdapter {

    public static String[] TITLES = { "销量优先", "价格优先", "综合排序" };

    public OrderListFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */
    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        OrderListTabFragment orderListTabFragment = new OrderListTabFragment(
                arg0);
        return orderListTabFragment;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TITLES.length;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.view.PagerAdapter#getPageTitle(int)
     */
    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        return TITLES[position];
    }

}
