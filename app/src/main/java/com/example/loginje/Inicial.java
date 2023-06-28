package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Inicial extends AppCompatActivity {

    private TextView mTextViewinicial;
    private Button mButtoncadastrar, mButtonentrar;
    private boolean required;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);


        mButtoncadastrar = findViewById(R.id.button_cadastrar);
        mButtoncadastrar.setOnClickListener(new ClickButtonCadastrar());

        mButtonentrar = findViewById(R.id.button_entrar);
        mButtonentrar.setOnClickListener(new ClickButtonEntrar());

        //responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
        {
            if (isRequired()) {
                Toast.makeText(this, "Inicial", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Inicial.this, MainActivity.class));
            }
        }
        class ClickButtonCadastrar implements View.OnClickListener {
            @Override
            public void onClick(View v) {

            }
        }

}

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public class ClickButtonCadastrar implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    public class ClickButtonEntrar implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
}
