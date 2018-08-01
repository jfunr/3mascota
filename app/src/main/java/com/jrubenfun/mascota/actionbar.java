package com.jrubenfun.mascota;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

public class actionbar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar);
    }









    public void irLista (View view){
        Intent intent=new Intent(actionbar.this,ListaMascotas.class);
        startActivity(intent);


    }
}