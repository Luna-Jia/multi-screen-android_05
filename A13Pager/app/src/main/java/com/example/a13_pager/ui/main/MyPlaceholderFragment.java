package com.example.a13_pager.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.graphics.Color;
import com.example.a13_pager.databinding.FragmentMainBinding;

public class MyPlaceholderFragment extends Fragment {

    // for 'passing intent/fragment parameter' to bundle
    private static final String ARG_TAB_NUMBER = "tab_number+1";
    private static final String ARG_BG_COLOR = "tab_bgcolor";

    private MyPageViewModel cv_pageViewModel;
    private FragmentMainBinding cv_binding;

    // return MyPlaceholderFragment.newInstance(position + 1);
    public static MyPlaceholderFragment cf_newInstance(int index, String bg) {
        MyPlaceholderFragment lv_fragment = new MyPlaceholderFragment();
        Bundle lv_bundle = new Bundle();
        lv_bundle.putInt(ARG_TAB_NUMBER, index);
        lv_fragment.setArguments(lv_bundle);
        lv_bundle.putString(ARG_BG_COLOR, bg);
        lv_fragment.setArguments(lv_bundle);
        return lv_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cv_pageViewModel = new ViewModelProvider(this).get(MyPageViewModel.class);
        int lv_index = 1;
        if (getArguments() != null) {
            lv_index = getArguments().getInt(ARG_TAB_NUMBER);
        }
        cv_pageViewModel.mf_setIndex(lv_index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        cv_binding = FragmentMainBinding.inflate(inflater, container, false);
        View lv_root = cv_binding.getRoot();

        final TextView lv_textView = cv_binding.vvTvFragLabel;
        cv_pageViewModel.mf_getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                lv_textView.setText(s);
                lv_textView.setTextColor(Color.WHITE);
                // tricky -- get color string from MyPager2Adapter->cf_getTabTitle()
                if (getArguments() != null) {
                    String lv_color = getArguments().getString(ARG_BG_COLOR);
                    lv_root.setBackgroundColor(Color.parseColor(lv_color.toLowerCase()));
                    //// Alternative approach, define Color[]={Color.RED, ...}
                    //// Color[ getArguments().getInt(ARG_TAB_NUMBER) ]
                }
            }
        });
        return lv_root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cv_binding = null;
    }
}