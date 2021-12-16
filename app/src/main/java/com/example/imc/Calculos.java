package com.example.imc;

import android.widget.EditText;
import android.widget.TextView;

public class Calculos {


    public double caucular(double altura, double peso)
    {
        double imc = (peso / (altura * altura));
        return imc;
    }

    public String classificar(double imc)
    {

        String classificacao = "";

        if (imc < 18.5) {
            classificacao = "Magreza\n";
        } else if (imc >= 18.5 && imc <= 24.9) {
            classificacao = "Normal\n";
        } else if (imc >= 25 && imc <= 29.9) {
            classificacao = "Sobrepeso, 1° grau\n";
        } else if (imc >= 30 && imc <= 39.9) {
            classificacao = "Obesidade, 2° grau\n";
        } else if (imc >= 40) {
            classificacao = "Obesidade grave, 3° grau\n";
        }

        return classificacao;
    }

    public Double paraNormal(double imc)
    {
        double normal =  0.0;

        if ( imc < 18.5){
            normal = imc - 18.5;
            normal = normal * -1;
        } else if (imc >= 25){
            normal = imc - 24.9;
            normal = normal * -1;
        }

        return normal;
    }

}
