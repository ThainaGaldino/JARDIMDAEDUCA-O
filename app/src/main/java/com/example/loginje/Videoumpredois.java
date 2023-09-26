package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class Videoumpredois extends AppCompatActivity {

    private AppCompatTextView txtClique;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videopredois);

        txtClique = findViewById(R.id.textView_clique); // Substitua com o ID correto do seu botão
        txtClique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // URL do vídeo do YouTube que você deseja abrir
                String urlDoVideo = "https://youtu.be/9XQGMArPCPU";

                // Cria uma intenção para abrir o link no aplicativo padrão do navegador
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDoVideo));

                // Inicia a intenção
                startActivity(intent);
            }
        });
    }
}
