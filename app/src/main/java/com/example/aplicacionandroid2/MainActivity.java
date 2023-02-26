package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
    Button boton_alta;
    Button boton_salir;
    Button boton_ver;
    Button boton_W1;
    Button boton_W2;
    Button boton_W3;
    Button boton_W4;

    TextView textoNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton_alta = (Button) findViewById(R.id.buttonAlta);
        boton_salir =  (Button) findViewById(R.id.buttonSalir);
        boton_ver= (Button) findViewById(R.id.buttonVer);
        boton_W1= (Button) findViewById(R.id.buttonW1);
        boton_W2= (Button) findViewById(R.id.buttonW2);
        boton_W3= (Button) findViewById(R.id.buttonW3);
        boton_W4= (Button) findViewById(R.id.buttonW4);
        Usuario usu;
        usu=(Usuario) getIntent().getSerializableExtra("objeto");

        boton_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
            }
        });

        boton_alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ActivityAlta.class);
                startActivity(intent);


            }
        });

        boton_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Activity_ver.class);
                    intent.putExtra("objeto", (Serializable) usu);
                    startActivity(intent);
                }catch (Exception e)
                {
                    System.out.println("No puedes ver");
                }

            }
        });

        boton_W1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Activity_Widget1.class);
                    intent.putExtra("objeto", (Serializable) usu);
                    startActivity(intent);
                }catch (Exception e)
                {
                    System.out.println("No puedes entrar al widget");
                }

            }
        });
        boton_W2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Activity_Widget2.class);
                    intent.putExtra("objeto", (Serializable) usu);
                    startActivity(intent);
                }catch (Exception e)
                {
                    System.out.println("No puedes entrar al widget");
                }

            }
        });

        boton_W3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Activity_Widget3.class);
                    intent.putExtra("objeto", (Serializable) usu);
                    startActivity(intent);
                }catch (Exception e)
                {
                    System.out.println("No puedes entrar al widget");
                }

            }
        });

        boton_W4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Activity_Widget4.class);
                    intent.putExtra("objeto", (Serializable) usu);
                    startActivity(intent);
                }catch (Exception e)
                {
                    System.out.println("No puedes entrar al widget");
                }

            }
        });

    }
}
