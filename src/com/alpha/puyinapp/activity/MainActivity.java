package com.alpha.puyinapp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.fragment.HomePageFragment;
import com.alpha.puyinapp.fragment.PersonalCenterFragment;
import com.alpha.puyinapp.fragment.ShoppingCartFragment;
import com.alpha.puyinapp.fragment.SortFragment;

/**
 * @author Simon
 * @created 2016/3/9
 * 
 * 
 */
@SuppressLint("NewApi")
public class MainActivity extends AppCompatActivity implements
        android.view.View.OnClickListener {
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private HomePageFragment homePageFragment;
    private PersonalCenterFragment personalCenterFragment;
    private ShoppingCartFragment shoppingCartFragment;
    private SortFragment sortFragment;
    private Fragment fragment;
    private FragmentTransaction fragmentTransaction;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.popBackStackImmediate(null, 1);
        }
        setContentView(R.layout.activity_main);
        gotoHomePage();
        findViews();
        initViews();

    }

    private void initViews() {
        // setSupportActionBar(mToolbar);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton4.setOnClickListener(this);
    }

    private void findViews() {

        radioButton1 = (RadioButton) findViewById(R.id.foot_bar_home);
        radioButton2 = (RadioButton) findViewById(R.id.foot_bar_sort);
        radioButton3 = (RadioButton) findViewById(R.id.foot_bar_shoppingcart);
        radioButton4 = (RadioButton) findViewById(R.id.foot_bar_my);

    }

    /*
     * 实现主页页面跳转
     */
    private void gotoHomePage() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        hideFragment(fragmentTransaction);
        if (homePageFragment == null) {
            homePageFragment = new HomePageFragment();
            fragmentTransaction.add(R.id.fl_content, homePageFragment);
        } else {
            fragmentTransaction.show(homePageFragment);
        }
        fragmentTransaction.commit();
    }

    /*
     * 实现分类页面跳转
     */
    private void gotoSort() {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        hideFragment(fragmentTransaction);
        if (sortFragment == null) {
            sortFragment = new SortFragment();
            fragmentTransaction.add(R.id.fl_content, sortFragment);
        } else {
            fragmentTransaction.show(sortFragment);
        }
        fragmentTransaction.commit();
    }

    /*
     * 实现购物车页面跳转
     */
    private void gotoShoppingcat() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        hideFragment(fragmentTransaction);
        if (shoppingCartFragment == null) {
            shoppingCartFragment = new ShoppingCartFragment();
            fragmentTransaction.add(R.id.fl_content, shoppingCartFragment);
        } else {
            fragmentTransaction.show(shoppingCartFragment);
        }
        fragmentTransaction.commit();
    }

    /**
     * 
     * 实现个人中心页面跳转
     */
    private void gotoPersonalCenter() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        hideFragment(fragmentTransaction);
        if (personalCenterFragment == null) {
            personalCenterFragment = new PersonalCenterFragment();
            fragmentTransaction.add(R.id.fl_content, personalCenterFragment);
        } else {
            fragmentTransaction.show(personalCenterFragment);
        }
        fragmentTransaction.commit();
    }

    // 隐藏Fragment
    public void hideFragment(FragmentTransaction fragmentTransaction) {
        if (shoppingCartFragment != null) {
            fragmentTransaction.hide(shoppingCartFragment);
        }
        if (homePageFragment != null) {
            fragmentTransaction.hide(homePageFragment);
        }
        if (personalCenterFragment != null) {
            fragmentTransaction.hide(personalCenterFragment);
        }
        if (sortFragment != null) {
            fragmentTransaction.hide(sortFragment);
        }
    }

    /**
     * 根据点击的ID实现页面跳转
     * 
     */

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.foot_bar_home:
            gotoHomePage();
            break;
        case R.id.foot_bar_sort:
            gotoSort();
            break;
        case R.id.foot_bar_shoppingcart:
            gotoShoppingcat();
            break;
        case R.id.foot_bar_my:
            gotoPersonalCenter();
            break;
        }
    }
}