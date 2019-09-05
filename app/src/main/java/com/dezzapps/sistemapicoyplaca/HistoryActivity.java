package com.dezzapps.sistemapicoyplaca;

import android.os.Bundle;

import com.dezzapps.sistemapicoyplaca.adapter.CustomAdapter;
import com.dezzapps.sistemapicoyplaca.data.VehiculoDBHelper;
import com.dezzapps.sistemapicoyplaca.models.History;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private VehiculoDBHelper vehiculoDBHelper;

    private List<History> historiesList = new ArrayList<>();

    private List<History> histories = new ArrayList<>();
    // candidato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vehiculoDBHelper = new VehiculoDBHelper(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(new CustomAdapter(this, historiesList));

        getData();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Historial");
    }

    private void getData(){

        histories = vehiculoDBHelper.gethistory();

        historiesList.addAll(histories);

        recyclerView.getAdapter().notifyDataSetChanged();


    }

}
