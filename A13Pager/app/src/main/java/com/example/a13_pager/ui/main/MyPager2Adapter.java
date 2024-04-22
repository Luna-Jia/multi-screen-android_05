package com.example.a13_pager.ui.main;

import android.content.Context;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.a13_pager.R;

public class MyPager2Adapter extends FragmentStateAdapter {
    Context cv_context;

    @StringRes
    private final int[] TAB_TITLES = new int[]{R.string.rstr_tab_text_1,
            R.string.rstr_tab_text_2, R.string.rstr_tab_text_3, R.string.rstr_tab_text_4};

    public MyPager2Adapter(FragmentActivity fa) {
        super(fa);
        cv_context = fa.getApplicationContext();
    }

    @Override
    public Fragment createFragment(int position) {
        // [] index from 0, "Page 1-4 is selected"
        return MyPlaceholderFragment.cf_newInstance(position+1, cf_getTabTitle(position));
    }

    @Override
    public int getItemCount() {
        return TAB_TITLES.length;
    }

    public String cf_getTabTitle(int position) {
        return cv_context.getResources().getString(TAB_TITLES[position]);
    }
}