package com.example.loginje;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class Numero extends AppCompatActivity {

    private Button mButtonConfirmar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero);

        mButtonConfirmar = findViewById(R.id.button_confirmar);

        mButtonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL do vídeo do YouTube que você deseja abrir
                String urlDoVideo = "https://linklist.bio/jardim_da_educacao";

                // Cria uma intenção para abrir o link no aplicativo padrão do navegador
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDoVideo));

                // Inicia a intenção
                startActivity(intent);
            }
        });
    }

    private void performNextActivity2() {
        //trocar de janela (tela de pres) //
        Intent it = new Intent(Numero.this, Numero.class);
        startActivity(it);

    }
}
