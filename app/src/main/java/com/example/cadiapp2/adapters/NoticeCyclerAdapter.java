package com.example.cadiapp2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cadiapp2.R;
import com.example.cadiapp2.items.NoticeItems;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeCyclerAdapter extends RecyclerView.Adapter<NoticeCyclerAdapter.ViewHolder> {
    private ArrayList<NoticeItems> noticeItemList;
    private Context context;

    public NoticeCyclerAdapter(ArrayList<NoticeItems> mainItemList, Context context) {
        this.noticeItemList = mainItemList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView contents;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.simple_title);
            contents = (TextView)itemView.findViewById(R.id.simple_contents);
        }
    }

    @Override
    public NoticeCyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NoticeCyclerAdapter.ViewHolder holder, int position) {
        holder.title.setText(noticeItemList.get(position).getTitle());
        holder.contents.setText(noticeItemList.get(position).getContents());
    }

    @Override
    public int getItemCount() {
        return noticeItemList.size();
    }

    public void addAtPosition(int position,String title,String contents){
        if(position > noticeItemList.size()){
            // 전체 사이즈보다 클 경우 .. 맨 뒤로!!
            position = noticeItemList.size();
        }
        noticeItemList.add(position,new NoticeItems(title,contents));
        notifyItemInserted(position);
    }
    public void removeAtPosition(int position){
        if(position < noticeItemList.size()){
            noticeItemList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void move(int fromPosition,int toPosition){
        final String title = noticeItemList.get(fromPosition).getTitle();
        final String contents = noticeItemList.get(fromPosition).getContents();
        noticeItemList.remove(fromPosition);
        noticeItemList.add(toPosition,new NoticeItems(title,contents));
        notifyItemMoved(fromPosition,toPosition);
    }
}
