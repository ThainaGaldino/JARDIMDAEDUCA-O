package com.example.loginje;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Habilidadeumpretres  extends AppCompatActivity {

    private Button mButtoniniciarpre3, mButtonbloque;

    //responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
    private void performNextActivity() {
        {
            Toast.makeText(this, "Habilidade um pre um", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Habilidadeumpretres.this, Pres.class));
        }
    }

    class ClickButtonIiniciarpre3 implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
    class ClickButtonBloque implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }






}
