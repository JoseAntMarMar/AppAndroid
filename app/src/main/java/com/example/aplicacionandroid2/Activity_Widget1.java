package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.Serializable;

public class Activity_Widget1 extends AppCompatActivity {

    private Button boton_aceptar;
    Button boton_salir;
    private CheckBox Checkbox_Empleado;
    private CheckBox Checkbox_Paro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget1);

        Usuario usu;
        usu = (Usuario) getIntent().getSerializableExtra("objeto");

        Checkbox_Empleado = (CheckBox) findViewById(R.id.checkBoxEmpleado);
        Checkbox_Paro = (CheckBox) findViewById(R.id.checkBoxParo);
        boton_aceptar = (Button) findViewById(R.id.buttonAceptarW1);
        boton_salir =  (Button) findViewById(R.id.buttonSalirW1);
        boton_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Checkbox_Empleado.isChecked())
                {
                    usu.setEmpleado();
                }

                if(Checkbox_Paro.isChecked())
                {
                    usu.setParo();
                }

                Intent intent = new Intent(Activity_Widget1.this, MainActivity.class);
                intent.putExtra("objeto", (Serializable) usu);
                startActivity(intent);

            }
        });

        boton_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Widget1.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}