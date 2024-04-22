package com.example.a13_pager;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.a13_pager.ui.main.MyPager2Adapter;
import com.example.a13_pager.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

// ver06 -- from template, modify, merge

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding cv_binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cv_binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(cv_binding.getRoot());

        MyPager2Adapter lv_pagerAdapter = new MyPager2Adapter(this);
        ViewPager2 lv_viewPager2 = cv_binding.vvVpViewpager2;
        lv_viewPager2.setAdapter(lv_pagerAdapter);

        TabLayout lv_tabs = cv_binding.vvTbTabs;
        new TabLayoutMediator(lv_tabs, lv_viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        // instead of tab.setText() at onCreate()
                        tab.setText(lv_pagerAdapter.cf_getTabTitle(position));
                    }
                }).attach();

    }
}