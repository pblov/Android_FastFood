package com.example.final_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle_Sandwich extends AppCompatActivity {

    private ImageView imagenSandwich;
    private TextView nombreSandwich,
                     descripcionSandwich,
                     precioSandwich;
    private String nombreSan,
                   nombreSan1,
                   descripcionSan,
                   precioSan;
    public int imagenSan;

    final int[] imagenes = {
            R.drawable.barros,
            R.drawable.chacarero,
            R.drawable.churrasco,
            R.drawable.italiano,
            R.drawable.mechada
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__sandwich);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent getSandwiches = getIntent();

        //Variable en Action Bar
        nombreSan = ("Detalle Sandwich ") + getSandwiches.getStringExtra("nombre");
        getSupportActionBar().setTitle(nombreSan);
        imagenSandwich = findViewById(R.id.imagenSandwich);
        nombreSandwich = findViewById(R.id.nombreSandwich);
        descripcionSandwich = findViewById(R.id.descripcionSandwich);
        precioSandwich = findViewById(R.id.precioSandwich);

        //Obtención de datos desde activity Sandwiches
        nombreSan1 = ("SANDWICH ") + getSandwiches.getStringExtra("nombre");
        descripcionSan = getSandwiches.getStringExtra("descripcion");
        precioSan = getSandwiches.getStringExtra("precio");
        imagenSan = getSandwiches.getIntExtra("id", 0);


        imagenSandwich.setImageResource(imagenes[imagenSan]);
        nombreSandwich.setText(nombreSan1);
        descripcionSandwich.setText(descripcionSan);
        precioSandwich.setText(precioSan);




    }
}
