package com.example.ilmi.retrofithanddirty.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ilmi.retrofithanddirty.R;
import com.example.ilmi.retrofithanddirty.adapter.NoticeAdapter;
import com.example.ilmi.retrofithanddirty.model.Notice;
import com.example.ilmi.retrofithanddirty.model.NoticeList;
import com.example.ilmi.retrofithanddirty.my_interface.GetNoticeDataService;
import com.example.ilmi.retrofithanddirty.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycle;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    GetNoticeDataService dataService;
    public static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //handler for retrofit interface
        dataService = RetrofitInstance.getRetrofit().create(GetNoticeDataService.class);

        Call<NoticeList> listCall = dataService.getNoticeList();


        Log.wtf("URL Called", listCall.request().url() + "");

        listCall.enqueue(new Callback<NoticeList>() {

            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                generateNoticeList(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateNoticeList(ArrayList<Notice> noticeArrayList) {
        mRecycle = (RecyclerView) findViewById(R.id.recycler_view_notice_list);
        mAdapter = new NoticeAdapter(noticeArrayList);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(MainActivity.this);
        mRecycle.setLayoutManager(mLayout);
        mRecycle.setAdapter(mAdapter);
    }

}
