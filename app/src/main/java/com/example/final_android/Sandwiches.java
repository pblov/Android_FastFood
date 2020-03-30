package com.example.final_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Sandwiches extends AppCompatActivity {


    LinearLayout contenedor;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwiches);
        getSupportActionBar().setTitle("Sandwiches");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        contenedor = findViewById(R.id.contenido);

        //Variables de string.xml

        String  desBarros = getString(R.string.descripBarros),
                desChacarero = getString(R.string.descripChacarero),
                desChurrasco = getString(R.string.descripChurrasco),
                desItaliano = getString(R.string.descripItaliano),
                desMechada = getString(R.string.descripMechada),
                preBarros = getString(R.string.preBarros),
                preChacarero = getString(R.string.preChacarero),
                preItaliano = getString(R.string.preItaliano),
                preChurrasco = getString(R.string.preChurrasco),
                preMechada = getString(R.string.preMechada);


        //Creacion de un linear layout para posterior modificación en estilos.
        LinearLayout.LayoutParams pp = new LinearLayout.LayoutParams(950,240);
        pp.setMargins(70,75,0,15);





        //Creaciòn del array.
        ArrayList<Sandwich> tipo_sandwich = new ArrayList<Sandwich>();



        tipo_sandwich.add(new Sandwich(0,"BARROS LUCO", desBarros, preBarros ));
        tipo_sandwich.add(new Sandwich(1,"CHACARERO", desChacarero, preChacarero));
        tipo_sandwich.add(new Sandwich(2,"CHURRASCO", desChurrasco, preChurrasco));
        tipo_sandwich.add(new Sandwich(3,"ITALIANO", desItaliano, preItaliano));
        tipo_sandwich.add(new Sandwich(4,"MECHADO", desMechada,preMechada));




        //For each que recorre y crea los botones con los nombres de los sandwichs y todos sus datos.
        for (final Sandwich s:tipo_sandwich){

            int colorRojo = Color.parseColor("#B71C1C"),
                colorNaranjo = Color.parseColor("#FF9800");

            //Cambio tipo del letra.
            Typeface typeface = ResourcesCompat.getFont(this, R.font.bree_serif),
                     bold = Typeface.defaultFromStyle(Typeface.BOLD);

            final Button b = new Button(getApplicationContext());

            //Estilos para la vista de Sandwiches.
            b.setText(s.nombre);
            b.setId(s.id_imagen);
            b.setTextSize(30);
            b.setTypeface(bold);
            b.setTypeface(typeface);
            b.setBackgroundColor(colorRojo);
            b.setTextColor(colorNaranjo);
            b.setGravity(Gravity.CENTER);
            b.setLayoutParams(pp);
            contenedor.addView(b);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intentDetalle = new Intent(Sandwiches.this,Detalle_Sandwich.class);

                    intentDetalle.putExtra("id", s.id_imagen);
                    intentDetalle.putExtra("nombre", s.nombre);
                    intentDetalle.putExtra("descripcion", s.descripcion);
                    intentDetalle.putExtra("precio", s.precio);
                    startActivity(intentDetalle);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                }
            });
        }

    }

    class Sandwich{

        public int id_imagen;

        public String nombre,
                      precio,
                      descripcion;

        public Sandwich(int id_imagen, String nombre, String descripcion, String precio) {
            this.id_imagen = id_imagen;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
        }


    }



}
