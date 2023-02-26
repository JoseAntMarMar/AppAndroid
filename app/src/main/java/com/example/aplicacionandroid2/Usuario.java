package com.example.aplicacionandroid2;

import android.os.Build;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Usuario implements Serializable {

    private String nombre,mail,pais;
    private int edad,empleo,genero;

    public Usuario(String nombre, String mail, int edad) {
        this.nombre = nombre;
        this.mail = mail;
        this.edad=edad;
        this.empleo=0;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEmpleo() {
        return empleo;
    }

    public void setEmpleado()
    {
        this.empleo=1;
    }

    public int getGenero() {
        return genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setParo(){
        this.empleo=2;
    }

    public void setFemenino(){this.genero=1;}

    public void setMasculino(){this.genero=2;}

    public void setOtro(){this.genero=3;}
}


