package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Video extends AppCompatActivity {

    private Button mButtonIniciarAtividade;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mButtonIniciarAtividade = findViewById(R.id.button_iniciar_atividade);
        mButtonIniciarAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVideo();
            }
        });

    }

    private void abrirVideo() {
        Uri uri = Uri.parse("https://youtu.be/qelEiERtEUY");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void performNextActivity() {
        if (isRequired()) {
            Toast.makeText(this, "Mandatory information", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Video.this, Habilidade.class);
        startActivity(intent);
    }

    private boolean isRequired() {
        return false;
    }
}
