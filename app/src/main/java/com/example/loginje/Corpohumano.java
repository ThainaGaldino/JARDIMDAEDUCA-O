package com.example.loginje;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Corpohumano extends AppCompatActivity {

    private TextView mTextViewcorpohumano;

    //responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
    private void performNextActivity() {
        if (isRequired()) {
            Toast.makeText(this, "Mandatory information", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Corpohumano.this, MainActivity.class));
        }
    }

    private boolean isRequired() {
        return false;
    }


}
