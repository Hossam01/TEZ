package com.example.tez.api;

import com.example.tez.models.ResponseDay;
import com.example.tez.models.User;

import javax.annotation.Generated;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Abhinav Singh on 17,June,2020
 */
public interface ApiService {

    @POST("rest/service/auth")
    Observable<Response<com.example.tez.models.Response>> getData(@Query("j_username") String name, @Query("j_password") String pass);

    @POST("rest/service/tasks/16-06-2021/16-06-2021")
    @Headers("Authorization: Bearer Bearer riohauug3nhyxtztgn2i8fkwuk3zzpjs")
    Observable<ResponseDay> getMainData(@Header("Cookie") String content_type);



}
