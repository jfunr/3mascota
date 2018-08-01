package com.jrubenfun.mascota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);

        //recyclerView.setAdapter(adapter);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



    }
}
