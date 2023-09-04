package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Habilidade extends AppCompatActivity {

    private AppCompatButton mButtonIniciar;
    private AppCompatButton mButtonBloqueado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidade);

        mButtonIniciar = findViewById(R.id.button_iniciar);
        mButtonBloqueado = findViewById(R.id.button_Bloqueado);

        mButtonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Habilidade.this, Video.class);
                startActivity(it);
            }
        });

    }
}