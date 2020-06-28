package com.example.terrappclase;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TerremotoAdapter extends ArrayAdapter<Terremoto> {

    private final static String SEPARADOR_LUGAR = " of ";


    public TerremotoAdapter( Context context, List<Terremoto> Terremotos) {
        super(context, 0, Terremotos);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ItemLista = convertView;
        if(ItemLista == null){
            ItemLista = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.terremoto_item_lista,parent,false);
        }

        Terremoto terremotoActual = getItem(position);



        ///--------------------------------seccion de parseo ---------------------------------


        //TIEMPO Y HORA

        //objetivo tiempo y hora en formato humano


        Date tiempoObj = new Date(terremotoActual.getmTiempo());

        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.getDefault());

        String fechaFormateada = dateFormat.format(tiempoObj);
        String horaFormateada = timeFormat.format(tiempoObj);


        //MAGNITUD

        Double magnitudActual = terremotoActual.getmMagnitud();
        DecimalFormat formatoDecimal = new DecimalFormat("0.0");
        String magnitudFormateada = formatoDecimal.format(magnitudActual);


        //PARSEO DE LUGAR

        String lugarCompleto = terremotoActual.getmLugar();
        String lugar;
        String distancia;

        if(lugarCompleto.contains(SEPARADOR_LUGAR)){

            String[] partes = lugarCompleto.split(SEPARADOR_LUGAR);
            distancia = partes[0];
            lugar = partes[1];

        }else{
            lugar = lugarCompleto;
            distancia = getContext().getString(R.string.cerca_de);
        }





        TextView magnitudTV = ItemLista.findViewById(R.id.magnitudTV);
        TextView fechaTV = ItemLista.findViewById(R.id.fechaTV);
        TextView distanciaTV = ItemLista.findViewById(R.id.distanciaTV);
        TextView lugarTV = ItemLista.findViewById(R.id.lugarTV);
        TextView horaTV = ItemLista.findViewById(R.id.horaTV);

        magnitudTV.setText(magnitudFormateada);
        fechaTV.setText(fechaFormateada);
        lugarTV.setText(lugar);
        distanciaTV.setText(distancia);
        horaTV.setText(horaFormateada);


        //Circulo
        GradientDrawable circuloMagnitud = (GradientDrawable) magnitudTV.getBackground();
        int colorMagnitud = getColorMagnitud(terremotoActual.getmMagnitud());

        circuloMagnitud.setColor(colorMagnitud);



        return ItemLista;

    }

    private int getColorMagnitud(Double Magnitud) {
        int colorIDMagnitud;
        int magnitudFloor = (int) Math.floor(Magnitud);

        switch (magnitudFloor) {
            case 0:
            case 1:
                colorIDMagnitud = R.color.magnitud1;
                break;
            case 2:
                colorIDMagnitud = R.color.magnitud2;
                break;
            case 3:
                colorIDMagnitud = R.color.magnitud3;
                break;
            case 4:
                colorIDMagnitud = R.color.magnitud4;
                break;
            case 5:
                colorIDMagnitud = R.color.magnitud5;
                break;
            case 6:
                colorIDMagnitud = R.color.magnitud6;
                break;
            case 7:
                colorIDMagnitud = R.color.magnitud7;
                break;
            case 8:
                colorIDMagnitud = R.color.magnitud8;
                break;
            case 9:
                colorIDMagnitud = R.color.magnitud9;
                break;
            default:
                colorIDMagnitud = R.color.magnitud10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), colorIDMagnitud);



    }




}
