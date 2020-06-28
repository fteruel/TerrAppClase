package com.example.terrappclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        ArrayList<Terremoto> terremotos = new ArrayList<>();

        terremotos.add(new Terremoto("8.5", "San Francisco", "Feb 2 2016"));
        terremotos.add(new Terremoto("5.5", "Londres", "May 2 2016"));
        terremotos.add(new Terremoto("6.5", "Tokio", "Oct 2 2016"));
        terremotos.add(new Terremoto("7.5", "Madrid", "Dec 2 2018"));
        terremotos.add(new Terremoto("7.0", "Mexico City", "Ocy 2 2017"));
*/


        ArrayList<Terremoto> terremotos = QueryUtils.extractTerremotos();

        ListView listaTerremotos = findViewById(R.id.listaTerremotos);

        TerremotoAdapter adaptador = new TerremotoAdapter(this, terremotos);

        listaTerremotos.setAdapter(adaptador);

        //TODO agregar un OnItemClickListener -->abra un Intent que abre la URL
        //Uri.parse
        //Intent Intent.ACTION_VIEW Uri






    }
}
