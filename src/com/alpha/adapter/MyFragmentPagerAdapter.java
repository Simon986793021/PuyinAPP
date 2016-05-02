/**
 * 
 */
package com.alpha.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alpha.puyinapp.fragment.SortFragment;

/**
 * @author Simon
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> list;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
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
        return list.get(arg0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return SortFragment.TITLES.length;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.view.PagerAdapter#getPageTitle(int)
     */
    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        return SortFragment.TITLES[position];
    }
}
