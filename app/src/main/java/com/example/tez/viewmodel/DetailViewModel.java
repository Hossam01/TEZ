package com.example.tez.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tez.models.Response;
import com.example.tez.models.ResponseDay;
import com.example.tez.repository.Repository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DetailViewModel  extends ViewModel {
    private static final String TAG = "DetailViewModel";

    private Repository repository;
    private MutableLiveData<ResponseDay> pokemonList = new MutableLiveData<>();

    @ViewModelInject
    public DetailViewModel(Repository repository) {

        this.repository = repository;
        getPokemons();

    }


    public MutableLiveData<ResponseDay> getPokemonList() {
        return pokemonList;
    }

    public void getPokemons(){
        repository.getMainData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> pokemonList.setValue(result),
                        error-> Log.e(TAG,error.getMessage()));

    }

}
