package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.Serializable;

public class Activity_Widget2 extends AppCompatActivity {
  Button boton_salir;
  Button boton_reset;
  RadioGroup radio_group;
  RadioButton radio_fem;
  RadioButton radio_masc;
  RadioButton radio_otro;
  Button boton_aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget2);
        boton_aceptar= (Button) findViewById(R.id.buttonAceptarW2);
        boton_salir =  (Button) findViewById(R.id.buttonSalirW2);
        boton_reset = (Button) findViewById(R.id.buttonResetGroup);
        radio_group = (RadioGroup) findViewById(R.id.radioGroup);
        radio_fem = (RadioButton) findViewById(R.id.radioButton);
        radio_masc = (RadioButton) findViewById(R.id.radioButton2);
        radio_otro = (RadioButton) findViewById(R.id.radioButton3);
        Usuario usu;
        usu = (Usuario) getIntent().getSerializableExtra("objeto");

        boton_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_fem.isChecked())
                {
                    usu.setFemenino();
                }

                if(radio_masc.isChecked())
                {
                    usu.setMasculino();
                }

                if(radio_otro.isChecked())
                {
                    usu.setOtro();
                }

                Intent intent = new Intent(Activity_Widget2.this, MainActivity.class);
                intent.putExtra("objeto", (Serializable) usu);
                startActivity(intent);

            }
        });

        boton_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radio_group.clearCheck();
            }
        });

        boton_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Widget2.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}