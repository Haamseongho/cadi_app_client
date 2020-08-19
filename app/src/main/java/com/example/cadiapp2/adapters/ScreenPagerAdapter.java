package com.example.cadiapp2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cadiapp2.R;
import com.example.cadiapp2.screen_layouts.InfoFragment;
import com.example.cadiapp2.screen_layouts.NoticeFragment;
import com.example.cadiapp2.screen_layouts.TodoFragment;
import com.example.cadiapp2.screen_layouts.VideoFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class ScreenPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private int mPageCount;

    public ScreenPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm, pageCount);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0: {
                fragment = new NoticeFragment();
                break;
            }
            case 1: {
                fragment = new TodoFragment();
                break;
            }
            case 2: {
                fragment = new VideoFragment();
                break;
            }
            case 3: {
                fragment = new InfoFragment();
                break;
            }
            default:
                return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
