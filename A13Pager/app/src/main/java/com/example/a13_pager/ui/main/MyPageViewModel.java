package com.example.a13_pager.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MyPageViewModel extends ViewModel {

    private MutableLiveData<Integer> mv_mIndex = new MutableLiveData<>();

    private LiveData<String> mv_mText = Transformations.map(mv_mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Page " + input + " is selected";
        }
    });

    public void mf_setIndex(int index) {
        mv_mIndex.setValue(index);
    }

    public LiveData<String> mf_getText() {
        return mv_mText;
    }
}