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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int contador = 0;
    int valorMaximo = 0;
    int valorMinimo = 0;
    Calendar calendar = Calendar.getInstance();
    Date date = calendar.getTime();

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    String dataFormatada = dateFormat.format(date);
    String horaFormatada = timeFormat.format(date);

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
                intent.putExtra("valorMaximo", valorMaximo);
                intent.putExtra("valorMinimo", valorMinimo);
                intent.putExtra("data", dataFormatada);
                intent.putExtra("hora", horaFormatada);
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

        valorMaximo = Integer.parseInt(textInputEditTextValorMaximo.getText().toString());
        valorMinimo = Integer.parseInt(textInputEditTextValorMinimo.getText().toString());


        Random random = new Random();

        int numero = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;


        if(textInputEditTextValorMaximo.equals("") || textInputEditTextValorMinimo.equals("")) {
            Toast.makeText(MainActivity.this, "Preencha os campos acima!", Toast.LENGTH_SHORT).show();
        } else {
            textViewValorSorteado.setText("Número sorteado foi: " + numero + "Contado: " + contador);
            contador++;
        }

    }
}