package com.example.cadiapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cadiapp2.adapters.ScreenPagerAdapter;
import com.example.cadiapp2.screen_layouts.InfoFragment;
import com.example.cadiapp2.screen_layouts.NoticeFragment;
import com.example.cadiapp2.screen_layouts.TodoFragment;
import com.example.cadiapp2.screen_layouts.VideoFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private Fragment noticeFragment;
    private Fragment todoFragment;
    private Fragment videoFragment;
    private Fragment infoFragment;
    private ViewPager viewPager;
    private ScreenPagerAdapter scPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initTabs();
        initPaging();
    }


    private void initViews() {
        noticeFragment = new NoticeFragment();
        todoFragment = new TodoFragment();
        videoFragment = new VideoFragment();
        infoFragment = new InfoFragment();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        scPagerAdapter = new ScreenPagerAdapter(this);

        getSupportFragmentManager().beginTransaction().add(R.id.container, noticeFragment).commit();

    }

    private void initTabs() {
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_speaker_notes_black_24dp));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_today_black_24dp));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_slideshow_black_24dp));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_account_box_black_24dp));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = noticeFragment;
                        break;
                    case 1:
                        fragment = todoFragment;
                        break;
                    case 2:
                        fragment = videoFragment;
                        break;
                    case 3:
                        fragment = infoFragment;
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initPaging() {
        viewPager.setAdapter(scPagerAdapter);
    }
}
