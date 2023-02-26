package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Activity_Widget3 extends AppCompatActivity{
    Button boton_salir;
    Button boton_aceptar;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget3);
        boton_salir =  (Button) findViewById(R.id.buttonSalirW3);
        boton_aceptar=(Button) findViewById(R.id.buttonAceptarW3);
        spin=findViewById(R.id.spinner_pais);
        Usuario usu;
        usu = (Usuario) getIntent().getSerializableExtra("objeto");


        ArrayList<String> arrayPaises= new ArrayList<String>();
        arrayPaises.add("España");
        arrayPaises.add("Portugal");
        arrayPaises.add("Marruecos");
        arrayPaises.add("Italia");
        arrayPaises.add("Francia");

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrayPaises);
        spin.setAdapter(adapter);



        boton_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pais= (String) spin.getItemAtPosition(spin.getSelectedItemPosition());
                 usu.setPais(pais);
                Intent intent = new Intent(Activity_Widget3.this, MainActivity.class);
                intent.putExtra("objeto", (Serializable) usu);
                startActivity(intent);
            }
        });

        boton_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Widget3.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }


}