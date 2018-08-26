package com.example.ilmi.retrofithanddirty.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ILMI on 8/12/2018.
 */

public class NoticeList {

    @SerializedName("notice_list")
        private ArrayList<Notice> noticeList;

    public ArrayList<Notice> getNoticeArrayList() {
        return noticeList;
    }

    public void setNoticeArrayList(ArrayList<Notice> noticeArrayList) {
        this.noticeList = noticeArrayList;
    }
}
