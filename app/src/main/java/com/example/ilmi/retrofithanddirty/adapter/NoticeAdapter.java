package com.example.ilmi.retrofithanddirty.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilmi.retrofithanddirty.R;
import com.example.ilmi.retrofithanddirty.model.Notice;

import java.util.ArrayList;

/**
 * Created by ILMI on 8/12/2018.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    ArrayList<Notice> notices;

    public NoticeAdapter(ArrayList<Notice> noticeArrayList) {
        notices = noticeArrayList;
    }


    @Override
    public NoticeAdapter.NoticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_view, parent, false);
        NoticeViewHolder mViewHolder = new NoticeViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(NoticeAdapter.NoticeViewHolder holder, int position) {
        holder.tvNoticeUsername.setText("user = "+notices.get(position).getIdUser());
        holder.tvNoticePass.setText("pass = "+notices.get(position).getPassword());
        holder.tvNoticeId.setText("id = "+notices.get(position).getUsername());
        holder.tvNoticeStatus.setText(notices.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return notices.size();
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNoticeStatus, tvNoticeId, tvNoticeUsername, tvNoticePass;

        public NoticeViewHolder(View itemView) {
            super(itemView);

            tvNoticeStatus = (TextView) itemView.findViewById(R.id.tv_notice_status);
            tvNoticeId = (TextView) itemView.findViewById(R.id.tv_notice_id);
            tvNoticeUsername = (TextView) itemView.findViewById(R.id.tv_notice_username);
            tvNoticePass = (TextView) itemView.findViewById(R.id.tv_notice_pass);
        }
    }
}
