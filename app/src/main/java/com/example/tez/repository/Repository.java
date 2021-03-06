package com.example.tez.repository;

import androidx.lifecycle.LiveData;


import com.example.tez.api.ApiService;
import com.example.tez.models.ResponseDay;
import com.example.tez.models.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;

/**
 * Created by Abhinav Singh on 17,June,2020
 */

public class Repository {

    private ApiService apiService;

    @Inject
    public Repository( ApiService apiService) {
        this.apiService = apiService;
    }


    public Observable<Response<com.example.tez.models.Response>> getData(String name, String pass){

        return apiService.getData(name,pass);

    }

    public Observable<ResponseDay> getMainData(String cookie){
        return apiService.getMainData(cookie);
    }
}
