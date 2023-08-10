package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Habilidade extends AppCompatActivity {

    private Button mButtonIniciar;
    private Button mButtonBloqueado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mButtonIniciar = findViewById(R.id.button_iniciar);
        mButtonBloqueado = findViewById(R.id.button_bloqueado);

        mButtonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNextActivity();
            }
        });

        mButtonBloqueado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para o clique do botão bloqueado
            }
        });

    }

    private void performNextActivity() {
    }
}