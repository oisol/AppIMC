package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPeso, edtAltura;
    private TextView txtResultado, txtResultado2;
    private Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atribuição

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);

        txtResultado = findViewById(R.id.txtResultado);
        txtResultado2 = findViewById(R.id.txtResultado2);

        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);
        txtResultado2.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View evento) {
        // Fomatador
        DecimalFormat format = new DecimalFormat("00.00");

        if(evento.getId() == R.id.btnCalcular){

            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());

            // calculo

            double imc = (peso / (altura * altura));

            txtResultado2.setVisibility(View.VISIBLE);
            txtResultado.setText(String.valueOf(format.format(imc)));

        }

    }
}