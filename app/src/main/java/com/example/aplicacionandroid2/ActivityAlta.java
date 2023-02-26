package com.example.aplicacionandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ActivityAlta extends AppCompatActivity {
    Button boton_cancelar;
    Button boton_aceptar;
    EditText EDnombre;
    EditText EDMail;
    EditText EDFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        boton_cancelar = (Button) findViewById(R.id.buttonCancelar);
        boton_aceptar= (Button) findViewById(R.id.buttonAceptar);
        EDnombre= (EditText) findViewById(R.id.nombre);
        EDMail= (EditText) findViewById(R.id.mail);
        EDFecha = (EditText) findViewById(R.id.fecha);


        boton_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityAlta.this,MainActivity.class);
                startActivity(intent);

            }
        });





        boton_aceptar.setOnClickListener(v ->{

            String nombre = EDnombre.getText().toString();
            String mail = EDMail.getText().toString();
            String fecha=EDFecha.getText().toString();
            int edad=calcularEdad(fecha);

            Usuario usu=new Usuario(nombre,mail,edad);
            Intent intent = new Intent(ActivityAlta.this, MainActivity.class);
            intent.putExtra("objeto", (Serializable) usu);
            startActivity(intent);

        });

    }

    public int calcularEdad(String fecha)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        System.out.println(formatter.format(date));


        Date startdate = null;
        Date enddate = new Date();
        try {
            startdate = formatter.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startdate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(enddate);

        int monthCount = 0;
        int firstDayInFirstMonth = startCalendar.get(Calendar.DAY_OF_MONTH);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        endCalendar.add(Calendar.DAY_OF_YEAR, -firstDayInFirstMonth + 1);

        while (!startCalendar.after(endCalendar)) {
            startCalendar.add(Calendar.MONTH, 1);
            ++monthCount;
        }

        startCalendar.add(Calendar.MONTH, -1);
        --monthCount;
        int remainingDays = 0;
        while (!startCalendar.after(endCalendar)) {
            startCalendar.add(Calendar.DAY_OF_YEAR, 1);
            ++remainingDays;
        }

        startCalendar.add(Calendar.DAY_OF_YEAR, -1);
        --remainingDays;

        int lastMonthMaxDays = endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (remainingDays >= lastMonthMaxDays) {
            ++monthCount;
            remainingDays -= lastMonthMaxDays;
        }


        int diffYear = monthCount / 12;

        return diffYear;
    }

}



