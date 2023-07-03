package com.example.loginje;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Habilidadeumpredois extends AppCompatActivity {

    private Button mButtoniniciarpre2, mButtonbloq;

    //responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
    private void performNextActivity() {
        {
            Toast.makeText(this, "Habilidade um pre um", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Habilidadeumpredois.this, Pres.class));
        }
    }

    class ClickButtonIiniciarpre2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
    class ClickButtonBloq implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
}



