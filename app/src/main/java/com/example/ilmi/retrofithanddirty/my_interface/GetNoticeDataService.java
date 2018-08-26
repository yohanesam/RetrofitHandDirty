package com.example.ilmi.retrofithanddirty.my_interface;

import com.example.ilmi.retrofithanddirty.model.NoticeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ILMI on 8/12/2018.
 */

public interface GetNoticeDataService {

    @GET("login/view_json_akun")
    Call<NoticeList> getNoticeList();

}
