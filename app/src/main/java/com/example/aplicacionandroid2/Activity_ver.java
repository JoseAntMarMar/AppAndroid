package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class Activity_ver extends AppCompatActivity {


    EditText TextNombre;
    EditText TextMail;
    EditText TextPais;
    EditText TextEdad;
    EditText TextTrabajo;
    EditText TextGenero;
    Button boton_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);
        TextNombre = (EditText) findViewById(R.id.nombre1);
        TextEdad = (EditText) findViewById(R.id.edad1);
        TextMail = (EditText) findViewById(R.id.mail1);
        TextTrabajo = (EditText) findViewById(R.id.empleo);
        TextGenero = (EditText) findViewById(R.id.genero);
        TextPais = (EditText) findViewById(R.id.pais);



        boton_salir = (Button) findViewById(R.id.buttonSalirVer);

        Usuario usu;
        usu = (Usuario) getIntent().getSerializableExtra("objeto");
        TextNombre.setText(usu.getNombre(),TextView.BufferType.EDITABLE);
        TextEdad.setText(String.valueOf(usu.getEdad()),TextView.BufferType.EDITABLE);
        TextMail.setText(usu.getMail(),TextView.BufferType.EDITABLE);
        TextPais.setText(usu.getPais(),TextView.BufferType.EDITABLE);



        int empleo=usu.getEmpleo();

        if(empleo==1)
        {

            TextTrabajo.setText("Empleado",TextView.BufferType.EDITABLE);
        }
        if(empleo==2)
        {
            TextTrabajo.setText("En paro",TextView.BufferType.EDITABLE);
        }

        int genero=usu.getGenero();

        if(genero==1)
        {

            TextGenero.setText("Femenino",TextView.BufferType.EDITABLE);
        }
        if(genero==2)
        {
            TextGenero.setText("Masculino",TextView.BufferType.EDITABLE);
        }

        if(genero==3)
        {
            TextGenero.setText("Otro",TextView.BufferType.EDITABLE);
        }



        boton_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_ver.this,MainActivity.class);
                intent.putExtra("objeto", (Serializable) usu);
                startActivity(intent);

            }
        });


    }
}