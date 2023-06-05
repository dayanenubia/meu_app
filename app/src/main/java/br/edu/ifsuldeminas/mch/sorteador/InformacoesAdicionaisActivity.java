package br.edu.ifsuldeminas.mch.sorteador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformacoesAdicionaisActivity extends AppCompatActivity {

    private TextView textViewQtd;
    private TextView textViewValores;
    private TextView textViewData;
    private int valorMaximo;
    private int valorMinimo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_adicionais);
        Switch switchMostra = findViewById(R.id.switchMostra);

        textViewQtd = findViewById(R.id.textViewQtd);
        textViewValores = findViewById(R.id.textViewValores);
        textViewData = findViewById(R.id.textViewData);

        // Carregar os valores salvos
        SharedPreferences sharedPreferences = getSharedPreferences("SorteadorPrefs", MODE_PRIVATE);
        valorMaximo = sharedPreferences.getInt("valorMaximo", 0);
        valorMinimo = sharedPreferences.getInt("valorMinimo", 0);

        // Atualizar os campos de exibição com os valores carregados
        //textViewValores.setText("Sorteio entre: " + valorMinimo + " e " + valorMaximo);

        switchMostra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Executar ações com base no estado do Switch
                if (isChecked) {
                    // O Switch está ativado
                    qtdSorteio();
                    valoresSorteio();
                    dataHora();
                }
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
            textViewData.setText("O sorteio foi realizado em: " + data + " ás: " + hora);
        }
    }
}
