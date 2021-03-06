package com.jrubenfun.mascota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    ImageButton starButton;
    int indices[] = new int[5];
    ArrayList<Mascota> topFiveMascotas;
    String[] topNombres = new String[5];;
    String[] topRates = new String[5];
    int topFoto[] = new int[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaMascotas = (RecyclerView) findViewById(R.id.rvListaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarMascotas();
        inicializarAdaptador();

        starButton = (ImageButton) findViewById(R.id.starButton);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rates[] = new int[mascotas.size()];
                //Toast.makeText(MainActivity.this,Integer.toString(rates.length),Toast.LENGTH_SHORT).show();

                for (int i=0; i<rates.length;i++){
                    rates[i]=Integer.parseInt(mascotas.get(i).getRate());
                    //Log.v("Contador " + Integer.toString(i),Integer.toString(rates[i]));
                }

                topCinco(rates);
                crearTopFive();

                Intent intent = new Intent(MainActivity.this,ListaMascotas.class);
                intent.putExtra("TopNombres",topNombres);
                intent.putExtra("TopRates",  topRates);
                intent.putExtra("TopFoto",   topFoto);
                startActivity(intent);

            }
        });
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1,"john","31"));
        mascotas.add(new Mascota(R.drawable.perro2,"happy","23"));
        mascotas.add(new Mascota(R.drawable.perro3,"ears","20"));
        mascotas.add(new Mascota(R.drawable.perro4,"furry","18"));
        mascotas.add(new Mascota(R.drawable.perro5,"black","15"));
        mascotas.add(new Mascota(R.drawable.perro6,"run","10"));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void topCinco(int[] rates){

        int i;
        int max = 0;
        int indiceAux;
        for (int j=0; j<5; j++){
            max = rates[0];
            indiceAux = 0;
            for (i =1; i<rates.length; i++){
                if (max< rates[i]){
                    max=rates[i];
                    indiceAux=i;
                }
            }
            indices[j]=indiceAux;
            rates[indiceAux]=Integer.MIN_VALUE;
        }
    }

    public void crearTopFive(){
        topFiveMascotas = new ArrayList<Mascota>();

        for (int i=0;i<indices.length;i++){
            //Log.v("Indices " + Integer.toString(i),Integer.toString(indices[i])+mascotas.get(indices[i]).getNombre());

            topFoto[i] = mascotas.get(indices[i]).getFoto();
            topNombres[i]= mascotas.get(indices[i]).getNombre();
            topRates[i]= mascotas.get(indices[i]).getRate();

        }



    }
}




























