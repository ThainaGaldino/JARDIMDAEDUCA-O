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

public class Habilidadeumpredois extends AppCompatActivity {

    private AppCompatButton mButtonIniciarpre2;
    private AppCompatButton mButtonBloqueado2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidadeumpredois);

        mButtonIniciarpre2 = findViewById(R.id.button_iniciarpre2);
        mButtonBloqueado2 = findViewById(R.id.button_bloqueado2);

        mButtonIniciarpre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Habilidadeumpredois.this, Videoumpredois.class);
                it.putExtra("videoEscolhido", "");
                startActivity(it);
            }
        });

    }
}