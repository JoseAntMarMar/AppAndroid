package com.example.aplicacionandroid2;

import android.os.Build;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Herramientas {
    public static int calculateAge(LocalDate birthDate) {

        DateTimeFormatter dtf = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        }
        LocalDate localDate = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            localDate = LocalDate.now();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            System.out.println(dtf.format(localDate));
        }

        if ((birthDate != null) && (localDate != null)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                System.out.println(Period.between(birthDate, localDate).getYears());
                return Period.between(birthDate, localDate).getYears();
            }
        }
            return 0;

    }

}
