package com.jrubenfun.mascota;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListaMascotas extends AppCompatActivity {

    //private ActionBar ActionBar;
    private Button mBtGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);


        ActionBar actionBar = getSupportActionBar();
        //getSupportActionBar().setTitle("Mascota");
       // actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        //actionBar.setIcon();

        mBtGoBack = (Button) findViewById(R.id.bt_go_back);


        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });


    }
}
