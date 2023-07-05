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
        if (isRequired()) {
            Toast.makeText(this, "Informação obrigatória", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Vídeo", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Habilidade.this, Video.class);
        startActivity(intent);
    }

    private boolean isRequired() {
        return false; // Você pode implementar sua própria lógica para verificar se alguma informação é obrigatória
    }
}
