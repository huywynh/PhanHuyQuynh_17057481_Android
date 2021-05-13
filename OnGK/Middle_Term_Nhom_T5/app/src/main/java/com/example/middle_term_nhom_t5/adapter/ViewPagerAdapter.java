package com.example.middle_term_nhom_t5.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.middle_term_nhom_t5.fragments.JustForFunFragment;
import com.example.middle_term_nhom_t5.fragments.Special;
import com.example.middle_term_nhom_t5.fragments.Winter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new JustForFunFragment();
            case 1:
                return new Special();
            case 2:
                return new Winter();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Just for you";
                break;
            case 1:
                title = "Winter Collection";
                break;
            case 2:
                title = "Special Collection";
                break;
        }
        return title;
    }
}
