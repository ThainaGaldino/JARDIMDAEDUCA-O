package com.example.loginje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pres extends AppCompatActivity {

    private Button mButtonpre1, mButtonpre2, mButtonpre3;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setContentView(R.layout.activity_pres);

        mButtonpre1 = findViewById(R.id.button_pre1);
        mButtonpre1.setOnClickListener(new ClickButtonPre1() {
            @Override
            public void onClick(View v) {
                performNextActivity();
            }
        });

        mButtonpre2 = findViewById(R.id.button_pre2);
        mButtonpre2.setOnClickListener(new ClickButtonPre2() {
            @Override
            public void onClick(View v) {
                performNextActivity();
            }
        });

        mButtonpre3 = findViewById(R.id.button_pre3);
        mButtonpre3.setOnClickListener(new ClickButtonPre3() {
            @Override
            public void onClick(View v) {
                performNextActivity();
            }
        });
    }

    // Método responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
    private void performNextActivity() {
        if (isRequired()) {
            Toast.makeText(this, "Mandatory information", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Pres.this, Habilidade.class));
        }
    }

    private boolean isRequired() {
        return false;
    }

    public class ClickButtonPre1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    public class ClickButtonPre2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    public class ClickButtonPre3 implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
}




