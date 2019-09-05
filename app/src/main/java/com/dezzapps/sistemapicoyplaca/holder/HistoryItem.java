package com.dezzapps.sistemapicoyplaca.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dezzapps.sistemapicoyplaca.R;
import com.dezzapps.sistemapicoyplaca.models.History;

import java.util.Calendar;

public class HistoryItem extends RecyclerView.ViewHolder {

    TextView dataOut,datain, create_at;


    public HistoryItem(@NonNull View itemView,  Context context) {
        super(itemView);

        datain = itemView.findViewById(R.id.textViewDatain);
        dataOut = itemView.findViewById(R.id.textViewDataout);
        create_at = itemView.findViewById(R.id.created_at);

    }

    public void bind(final History history){

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(history.getCreate_at());

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minu = calendar.get(Calendar.MINUTE);

        dataOut.setText(history.getDataOut());
        datain.setText(history.getDataIn());

        create_at.setText(mYear+"/"+mMonth+"/"+mDay+" - "+hora+":"+minu);
    }
}
