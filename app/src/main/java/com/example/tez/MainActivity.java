package com.example.tez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tez.databinding.ActivityMainBinding;
import com.example.tez.models.Response;
import com.example.tez.models.User;
import com.example.tez.viewmodel.MainViewModel;

import org.simpleframework.xml.Element;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.username.getText().length()==0)
                {
                    binding.username.setError("Enter User Name");
                }
                else if (binding.password.getText().length()==0)
                {
                    binding.password.setError("Enter Passwprd");

                }
                else {
                    viewModel.getPokemons(binding.username.getText().toString()
                            , binding.password.getText().toString());
                }
            }
        });

        viewModel.getPokemonList().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response user) {
                if (user.getAuth().equals("true")) {
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    startActivity(intent);
                    viewModel.getPokemons2();

                }
            }
        });

        viewModel.ErrorpokemonList.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("HTTP 500 Internal Server Error"))
                {
                    Toast.makeText(MainActivity.this,"Enter Valid username or password",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}