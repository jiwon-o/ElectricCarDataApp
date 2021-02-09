package com.example.electriccardataapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

// Pager adapter in fragment_data
public class PagerAdapterData extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public PagerAdapterData(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm, NumOfTabs);
        this.mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DataFragment_week();
            case 1:
                return new DataFragment_month();
            case 2:
                return new DataFragment_year();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
