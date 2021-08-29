package com.example.tez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tez.adapter.PokemonAdapter;
import com.example.tez.databinding.ActivityDataBinding;
import com.example.tez.databinding.ActivityMainBinding;
import com.example.tez.models.GroupedTasks;
import com.example.tez.models.ResponseDay;
import com.example.tez.models.testRes;
import com.example.tez.viewmodel.DetailViewModel;
import com.example.tez.viewmodel.MainViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint

public class DataActivity extends AppCompatActivity {
    ActivityDataBinding binding;
    private DetailViewModel viewModel;
    private PokemonAdapter adapter;
    private ArrayList<testRes> pokemonList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        initRecyclerView();
        viewModel.getPokemonList().observe(this, new Observer<ResponseDay>() {
            @Override
            public void onChanged(ResponseDay responseDay) {
                for (int i=0;i<responseDay.getGroupedTasks().size();i++)
                {
                    pokemonList.add(responseDay.getGroupedTasks().get(i).getTask().get(0));
                }
                binding.progress.setVisibility(View.INVISIBLE);
                adapter.updateList(pokemonList);
            }
        });

    }

    private void initRecyclerView() {
        adapter = new PokemonAdapter(DataActivity.this,pokemonList);
        binding.pokemonRecyclerView.setAdapter(adapter);
    }
}