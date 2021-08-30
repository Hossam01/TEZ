package com.example.tez.viewmodel;


import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Response;

import com.example.tez.models.ResponseDay;
import com.example.tez.repository.Repository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";

    private Repository repository;
    private MutableLiveData<Response<com.example.tez.models.Response>> pokemonList = new MutableLiveData<>();
   public MutableLiveData<String> ErrorpokemonList = new MutableLiveData<>();

    @ViewModelInject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<Response<com.example.tez.models.Response>> getPokemonList() {
        return pokemonList;
    }



    public void getPokemons(String name,String pass){
        String cookie ;

        repository.getData(name, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> pokemonList.setValue(result)
                        ,
                        error-> ErrorpokemonList.setValue(error.getMessage().toString()));

    }




}
