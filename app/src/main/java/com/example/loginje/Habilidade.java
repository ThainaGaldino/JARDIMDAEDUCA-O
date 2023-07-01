package com.example.loginje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Habilidade extends AppCompatActivity {

    private Button mButtoniiniciar, mButtonbloqueado;

    //responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
    private void performNextActivity() {
       {
            Toast.makeText(this, "Habilidade um pre um", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Habilidade.this, Pres.class));
        }
    }

        class ClickButtonIiniciar implements View.OnClickListener {
            @Override
            public void onClick(View v) {

            }
        }
        class ClickButtonBloqueado implements View.OnClickListener {
            @Override
            public void onClick(View v) {

            }
        }
    }



