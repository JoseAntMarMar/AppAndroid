package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Activity_Widget4 extends AppCompatActivity {
    Button boton_salir;
    Button boton_aceptar;
    EditText opinion;
    RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget4);
        boton_salir =  (Button) findViewById(R.id.buttonSalirW4);
        boton_aceptar = (Button) findViewById(R.id.buttonAceptarW4);
        rating = (RatingBar) findViewById(R.id.ratingEstrellas);
        opinion=(EditText) findViewById(R.id.opinion);

        boton_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rat = rating.getRating();

                if (rat == 0) {
                    opinion.setText("El usuario no ha dado nota");
                } else if (rat == 0.5 || rat == 1.0) {
                    opinion.setText("La aplicación es muy mala");
                } else if (rat == 1.5 || rat == 2.0) {
                    opinion.setText("La aplicación es mala");
                } else if (rat == 2.5 || rat == 3.0) {
                    opinion.setText("La aplicación es buena");
                } else if (rat == 3.5 || rat == 4.0) {
                    opinion.setText("La aplicación es muy buena");
                } else
                    opinion.setText("La aplicación es excelente ");
            }


        });




        boton_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Widget4.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }
}