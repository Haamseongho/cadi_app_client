package com.example.cadiapp2.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadiapp2.R;
import com.example.cadiapp2.items.NoticeItems;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeCyclerAdapter extends RecyclerView.Adapter<NoticeCyclerAdapter.ViewHolder> {
    private ArrayList<NoticeItems> noticeItemList;
    private Context context;
    private AlertDialog.Builder dlg;

    public NoticeCyclerAdapter(ArrayList<NoticeItems> mainItemList, Context context) {
        this.noticeItemList = mainItemList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView contents;

        public ViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.simple_title);
            contents = (TextView) itemView.findViewById(R.id.simple_contents);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    final int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        dlg = new AlertDialog.Builder(view.getContext());
                        dlg.setTitle("[공지]: " + noticeItemList.get(pos).getTitle() + " ");
                        dlg.setMessage("선택하신 공지 내용을 별도로 저장하시겠습니까?");
                        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int inx) {
                                Toast.makeText(itemView.getContext(), "저장: " + pos, Toast.LENGTH_LONG).show(); // Bundle로 넘길지 Intent로 넘길지 체크

                            }
                        });
                        dlg.setNegativeButton("취소", null);
                        dlg.show();
                    }
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dlg = new AlertDialog.Builder(view.getContext());
                }
            });
        }
    }


    @Override
    public NoticeCyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items, parent, false);
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

    public void addAtPosition(int position, String title, String contents) {
        if (position > noticeItemList.size()) {
            // 전체 사이즈보다 클 경우 .. 맨 뒤로!!
            position = noticeItemList.size();
        }
        noticeItemList.add(position, new NoticeItems(title, contents));
        notifyItemInserted(position);
    }

    public void removeAtPosition(int position) {
        if (position < noticeItemList.size()) {
            noticeItemList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void move(int fromPosition, int toPosition) {
        final String title = noticeItemList.get(fromPosition).getTitle();
        final String contents = noticeItemList.get(fromPosition).getContents();
        noticeItemList.remove(fromPosition);
        noticeItemList.add(toPosition, new NoticeItems(title, contents));
        notifyItemMoved(fromPosition, toPosition);
    }
}
