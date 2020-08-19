package com.example.cadiapp2.screen_layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cadiapp2.R;
import com.example.cadiapp2.adapters.NoticeCyclerAdapter;
import com.example.cadiapp2.items.NoticeItems;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager manager;
    private NoticeCyclerAdapter noticeAdapter;
    private ArrayList<NoticeItems> noticeItemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_notice_layout, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.noticeCyclerView);
        manager = new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setHasFixedSize(true);

        noticeItemList = new ArrayList<>();
        // 서버 연동은 이쪽에서
        // 예시
        noticeItemList.add(new NoticeItems("공지제목1","공지내용1"));
        noticeItemList.add(new NoticeItems("공지제목2","공지내용2"));
        noticeItemList.add(new NoticeItems("공지제목3","공지내용3"));
        noticeItemList.add(new NoticeItems("공지제목4","공지내용4"));
        noticeItemList.add(new NoticeItems("공지제목5","공지내용5"));
        noticeItemList.add(new NoticeItems("공지제목6","공지내용6"));

        noticeAdapter = new NoticeCyclerAdapter(noticeItemList,rootView.getContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(noticeAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove( RecyclerView recyclerView,  RecyclerView.ViewHolder viewHolder,  RecyclerView.ViewHolder target) {
                noticeAdapter.move(viewHolder.getAdapterPosition(),target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped( RecyclerView.ViewHolder viewHolder, int direction) {
                noticeAdapter.removeAtPosition(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(mRecyclerView);

        return rootView;
    }

}
