package br.edu.ifsuldeminas.mch.sorteador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonMaisInformacoes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InformacoesAdicionaisActivity.class);
                intent.putExtra("contador", contador);
                startActivity(intent);
            }
        });
    }

    public void jogar(View view){
        TextView textViewValorSorteado;
        TextInputEditText textInputEditTextValorMinimo;
        TextInputEditText textInputEditTextValorMaximo;

        textViewValorSorteado = findViewById(R.id.textViewValorSorteado);
        textInputEditTextValorMinimo = findViewById(R.id.textInputEditTextValorMinimo);
        textInputEditTextValorMaximo = findViewById(R.id.textInputEditTextValorMaximo);

        int valorMaximo = Integer.parseInt(textInputEditTextValorMaximo.getText().toString());
        int valorMinimo = Integer.parseInt(textInputEditTextValorMinimo.getText().toString());


        Random random = new Random();

        int numero = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;

        textViewValorSorteado.setText("Número sorteado foi: " + numero);
        Toast.makeText(MainActivity.this, "Seu número foi sorteado!", Toast.LENGTH_SHORT).show();
        contador++;
    }
}