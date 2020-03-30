package com.example.final_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNosotros;
    private Button btnSandwichs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNosotros = findViewById(R.id.btnNosotros);
        btnSandwichs = findViewById(R.id.btnSandwich);
        Log.i("InfoAzul", "onCreate()");
    }

    public void vistaSobreNos(View view){

        Intent intentNos = new Intent(this, Main2Activity.class);
        startActivity(intentNos);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    }


    public void vistaSandwich(View view){

        Intent intentSan = new Intent(this, Sandwiches.class);
        startActivity(intentSan);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

    }




}
