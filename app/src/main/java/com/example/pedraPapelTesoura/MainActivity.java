package com.example.pedraPapelTesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgPedra;
    ImageView imgPapel;
    ImageView imgTesoura;
    ImageView imgDefault;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPedra = findViewById(R.id.img_pedra);
        imgPapel = findViewById(R.id.img_papel);
        imgTesoura = findViewById(R.id.img_tesoura);
        imgDefault = findViewById(R.id.img_default);
        tvResultado = findViewById(R.id.tv_resultado);

        imgPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoSelecionada(EnumOptions.PEDRA.toString());
            }
        });

        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoSelecionada(EnumOptions.PAPEL.toString());
            }
        });

        imgTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoSelecionada(EnumOptions.TESOURA.toString());
            }
        });
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        String[] jokenpo = {
                EnumOptions.PEDRA.toString(),
                EnumOptions.PAPEL.toString(),
                EnumOptions.TESOURA.toString()
        };

        int jogadaApp = new Random().nextInt(3);

        String opcaoApp =  jokenpo[jogadaApp];
        String resultado = "Empate";

        switch (EnumOptions.valueOf(opcaoApp)) {
            case PEDRA:
                imgDefault.setImageResource(R.drawable.pedra);
                break;
            case TESOURA:
                imgDefault.setImageResource(R.drawable.tesoura);
                break;
            case PAPEL:
                imgDefault.setImageResource(R.drawable.papel);
                break;
            default:
        }

        if(
                (opcaoSelecionada.equals(EnumOptions.PEDRA.toString()) && opcaoApp.equals(EnumOptions.TESOURA.toString())) ||
                (opcaoSelecionada.equals(EnumOptions.TESOURA.toString()) && opcaoApp.equals(EnumOptions.PAPEL.toString())) ||
                (opcaoSelecionada.equals(EnumOptions.PAPEL.toString()) && opcaoApp.equals(EnumOptions.PEDRA.toString()))
        ) {
            resultado = "Você ganhou";
        } else if(
                (opcaoApp.equals(EnumOptions.PEDRA.toString()) && opcaoSelecionada.equals(EnumOptions.TESOURA.toString())) ||
                (opcaoApp.equals(EnumOptions.TESOURA.toString()) && opcaoSelecionada.equals(EnumOptions.PAPEL.toString())) ||
                (opcaoApp.equals(EnumOptions.PAPEL.toString()) && opcaoSelecionada.equals(EnumOptions.PEDRA.toString()))
        ) {
            resultado = "App ganhou";
        }

        tvResultado.setText(resultado);
    }
}
