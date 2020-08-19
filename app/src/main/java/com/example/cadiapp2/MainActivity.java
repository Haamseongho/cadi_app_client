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
    private ViewPager viewPager;
    private ScreenPagerAdapter scPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initTabs();
    }


    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //getSupportFragmentManager().beginTransaction().add(R.id.container, noticeFragment).commit();
    }

    private void initTabs() {
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_speaker_notes_black_24dp));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_today_black_24dp));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_slideshow_black_24dp));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_account_box_black_24dp));

        scPagerAdapter = new ScreenPagerAdapter(getSupportFragmentManager(), tabs.getTabCount());
        // ViewPager 연동으로 화면 넘기기
        viewPager.setAdapter(scPagerAdapter);
        // viewPager에 탭 수만큼 연결
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                // getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
