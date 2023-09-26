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

public class Habilidadeumpretres extends AppCompatActivity {

    private AppCompatButton mButtonIniciarpre3;
    private AppCompatButton mButtonBloqueado3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidadeumpretres);

        mButtonIniciarpre3 = findViewById(R.id.button_iniciarpre3);
        mButtonBloqueado3 = findViewById(R.id.button_bloqueado3);

        mButtonIniciarpre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Habilidadeumpretres.this, Videoumpretres.class);
                it.putExtra("videoEscolhido", "");
                startActivity(it);
            }
        });

    }
}