/**
 * 
 */
package com.alpha.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author Simon
 */
public class TabAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentlist = new ArrayList<Fragment>();
    public static String[] title = { "全部   ", "待付款", "待发货    ", "待收货", "待评价" };

    /**
     * @param fm
     */
    public TabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        fragmentlist = fragments;
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */
    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub
        return fragmentlist.get(position);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return title.length;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.view.PagerAdapter#getPageTitle(int)
     */
    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        return title[position];
    }

}
