package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAlta extends AppCompatActivity {
    Button boton_cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        boton_cancelar = (Button) findViewById(R.id.buttonCancelar);
        boton_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityAlta.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

