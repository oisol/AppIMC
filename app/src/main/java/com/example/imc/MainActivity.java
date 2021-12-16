package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPeso, edtAltura;
    private TextView txtResultado, txtResultado2, txtClassificacao;
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
        txtClassificacao = findViewById(R.id.txtClassificacao);

        btnCalcular = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(this);
        txtResultado2.setVisibility(View.INVISIBLE);
        txtClassificacao.setVisibility(View.INVISIBLE);
        edtAltura.requestFocus();


    }

    @Override
    public void onClick(View evento) {
        // Fomatador
        DecimalFormat format = new DecimalFormat("00.00");

        if(evento.getId() == R.id.btnCalcular){

            // validações
            // Verificar se campos não estão vazios

            if ( edtAltura.getText().toString().equals("")){

                Toast.makeText(this, "Preencha o campo de altura", Toast.LENGTH_SHORT).show();
                edtAltura.requestFocus();

            } else if ( edtPeso.getText().toString().equals("")) {

                Toast.makeText(this, "Preencha o campo de peso", Toast.LENGTH_SHORT).show();
                edtPeso.requestFocus();

            } else {

                // Substituindo virgulas por pontos

                double peso = Double.parseDouble(edtPeso.getText().toString()
                        .replace(",", "."));

                double altura = Double.parseDouble(edtAltura.getText().toString()
                        .replace(",", "."));


                String msg = "";

                if (altura <= 0 || altura > 3){

                    msg = "Digte uma altura entre 0 e 3 metros";
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    edtAltura.requestFocus();

                } else if (peso > 500 || peso <= 0) {

                    msg = "Digite um peso entre 0 e 500";
                    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                    edtPeso.requestFocus();

                } else {

                    txtResultado2.setVisibility(View.VISIBLE);
                    txtClassificacao.setVisibility(View.VISIBLE);

                    // Chamando metodos da classe
                    Calculos calculos = new Calculos();
                    double imc = calculos.caucular(altura, peso);
                    String classificacao  = calculos.classificar(imc);
                    double paraNormal = calculos.paraNormal(imc);

                    txtResultado.setText(String.valueOf(format.format(imc)));

                    if (paraNormal == 0){
                        txtClassificacao.setText(new StringBuilder().append(classificacao)
                                .append("Você está no peso ideal"));
                    } else {
                        txtClassificacao.setText(new StringBuilder().append(classificacao).append("Faltam ")
                                .append(String.valueOf(format.format(paraNormal))).append(" para o peso ideal.").toString());
                    }


                }
            }



        }

    }



}