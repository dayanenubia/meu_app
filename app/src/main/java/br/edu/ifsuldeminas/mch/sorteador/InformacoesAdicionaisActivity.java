package br.edu.ifsuldeminas.mch.sorteador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformacoesAdicionaisActivity extends AppCompatActivity {

    private TextView textViewQtd;
    private TextView textViewValores;
    private TextView textViewData;
    private TextView textViewHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_adicionais);

        textViewQtd = findViewById(R.id.textViewQtd);
        textViewValores = findViewById(R.id.textViewValores);

        Button buttonAbrirInformacoes = findViewById(R.id.buttonAbrirInformacoes);
        buttonAbrirInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtdSorteio();
                valoresSorteio();
            }
        });


    }

    private void qtdSorteio() {
        Intent intent = getIntent();
        if (intent.hasExtra("contador")) {
            int contador = intent.getIntExtra("contador", 0);
            textViewQtd.setText("A quantidade de números sorteados foi: " + contador);
        }
    }

    private void valoresSorteio(){
        Intent intent = getIntent();
        if (intent.hasExtra("valorMaximo") && intent.hasExtra("valorMinimo")) {
            int valorMaximo = intent.getIntExtra("valorMaximo", 0);
            int valorMinimo = intent.getIntExtra("valorMinimo", 0);
            textViewValores.setText("Sorteio entre: " + valorMinimo + " e " + valorMaximo);
        }
    }

    private void dataHora(){
        Intent intent = getIntent();
        if (intent.hasExtra("data") && intent.hasExtra("hora")) {
            String data = intent.getStringExtra("data");
            String hora = intent.getStringExtra("hora");
            // Exibir a data e a hora nos TextViews
            textViewData.setText("Data: " + data);
            textViewHora.setText("Hora: " + hora);
        }
    }
}
