package com.dezzapps.sistemapicoyplaca.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dezzapps.sistemapicoyplaca.R;
import com.dezzapps.sistemapicoyplaca.models.History;

public class HistoryItem extends RecyclerView.ViewHolder {

    TextView dataOut,datain, create_at;


    public HistoryItem(@NonNull View itemView,  Context context) {
        super(itemView);

        datain = itemView.findViewById(R.id.textViewDatain);
        dataOut = itemView.findViewById(R.id.textViewDataout);

    }

    public void bind(final History history){
        

        dataOut.setText(history.getDataOut());
        datain.setText(history.getDataIn());

    }
}
