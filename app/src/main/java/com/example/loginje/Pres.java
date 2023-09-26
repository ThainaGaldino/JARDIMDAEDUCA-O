package com.example.loginje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pres extends AppCompatActivity {

    private Button mButtonpre1, mButtonpre2, mButtonpre3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pres);

        mButtonpre1 = findViewById(R.id.button_pre1);
        mButtonpre2 = findViewById(R.id.button_pre2);
        mButtonpre3 = findViewById(R.id.button_pre3);

        mButtonpre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNextActivity(Habilidade.class);
            }
        });

        mButtonpre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNextActivity(Habilidadeumpredois.class);
            }
        });

        mButtonpre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNextActivity(Habilidadeumpretres.class); // Substitua "OutraTela" pelo nome da sua terceira tela.
            }
        });
    }

    private void performNextActivity(Class<?> activityClass) {
        if (isRequired()) {
            Toast.makeText(this, "Seja bem-vindo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Habilidade", Toast.LENGTH_SHORT).show();
        }
        // Trocar de tela para a atividade especificada
        Intent it = new Intent(Pres.this, activityClass);
        startActivity(it);
    }

    private boolean isRequired() {
        // Lógica para verificar se é necessário mostrar a mensagem de "Seja bem-vindo"
        return false;
    }
}
