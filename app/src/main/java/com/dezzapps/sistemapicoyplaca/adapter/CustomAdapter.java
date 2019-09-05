package com.dezzapps.sistemapicoyplaca.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dezzapps.sistemapicoyplaca.R;
import com.dezzapps.sistemapicoyplaca.holder.HistoryItem;
import com.dezzapps.sistemapicoyplaca.models.History;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<History> historyList
            ;
    private Context context;

    private static final int TYPE_CANDIDATO = 0;
    private static final int TYPE_COORDINADOR = 1;
    private static final int TYPE_LIDER = 2;
    private static final int TYPE_VOTANTE = 3;

    public CustomAdapter(Context context, List<History> historyList){
        this.context = context;
        this.historyList = historyList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {


            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_history, viewGroup, false);
            return new HistoryItem(itemView, context);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HistoryItem holderHistory = (HistoryItem) holder;
        ((HistoryItem) holder).bind(historyList.get(position));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

}
