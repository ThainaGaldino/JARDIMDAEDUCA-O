package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class Videoumpretres extends AppCompatActivity {


    private AppCompatTextView txtAssistir;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videopretres);

        txtAssistir = findViewById(R.id.textView_assistir); // Substitua com o ID correto do seu botão
        txtAssistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // URL do vídeo do YouTube que você deseja abrir
                String urlDoVideo = "https://youtu.be/bF27ZucAoWs";

                // Cria uma intenção para abrir o link no aplicativo padrão do navegador
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDoVideo));

                // Inicia a intenção
                startActivity(intent);
            }
        });
    }
}
