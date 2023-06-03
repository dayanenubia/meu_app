package br.edu.ifsuldeminas.mch.sorteador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformacoesAdicionaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_adicionais);

        TextView textViewQtd;
        textViewQtd = findViewById(R.id.textViewQtd);

        Intent intent = getIntent();
        if (intent.hasExtra("contador")) {
            // Obter a variável da Intent
            String contador = intent.getStringExtra("contador");

            textViewQtd.setText("A quantidade de numeros sorteados foi: " + contador);
        }
    }

}
