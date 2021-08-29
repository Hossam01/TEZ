package com.example.tez.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tez.databinding.ItemBinding;
import com.example.tez.models.GroupedTasks;
import com.example.tez.models.testRes;

import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

/**
 * Created by Abhinav Singh on 17,June,2020
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private Context mContext;
    private ArrayList<testRes> mList;
    private ItemBinding binding;

    public PokemonAdapter(Context mContext, ArrayList<testRes> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = ItemBinding.inflate(inflater,parent,false);
        return new PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
       binding.Country.setText(mList.get(position).getCountry());
       binding.Driver.setText(mList.get(position).getDriver());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder{
        private ItemBinding itemBinding;

        public PokemonViewHolder(ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    public  void updateList(ArrayList<testRes> updatedList){
        mList = updatedList;
        notifyDataSetChanged();
    }

    public  testRes getPokemonAt(int position){
        return mList.get(position);
    }
}
