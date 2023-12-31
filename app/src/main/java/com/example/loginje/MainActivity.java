package com.example.loginje;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditextCredentials, mEdittextPassword;
    private TextView mButtonSignUp, mButtonCadastro;
    private Button mButtonSignIn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditextCredentials = findViewById(R.id.editText_credentials);
        mEdittextPassword = findViewById(R.id.editText_password);
        mEdittextPassword.setOnEditorActionListener(new EditTextAction());
        mButtonSignIn = findViewById(R.id.btn_sign_in);
        mButtonSignIn.setOnClickListener(new ClickButtonSignIn());

        mButtonSignUp = findViewById(R.id.btn_forgot_password);
        mButtonSignUp.setOnClickListener(new ClickButtonSignUp());

        mButtonCadastro = findViewById(R.id.btn_cadastro);
        mButtonCadastro.setOnClickListener(new ClickButtonCadastrar());


    }


    private boolean isRequired() {
        if (TextUtils.isEmpty(mEditextCredentials.getText()) ||
                TextUtils.isEmpty(mEdittextPassword.getText())) {
            return true;

        } else {
            return false;
        }
    }


    private void performNextActivity() {
        if (isRequired()) {
            Toast.makeText(this, "Faça seu login", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = new User();
        user.setmEmail(mEditextCredentials.getText().toString());
        user.setmPassword(mEdittextPassword.getText().toString());
        int resultado = UserDao.authenticateUser(user, getApplicationContext());
        if (resultado == 1) {
            Toast.makeText(this, "SEJA BEM - VINDO", Toast.LENGTH_SHORT).show();

            //trocar de janela (tela de pres) //
            Intent it = new Intent(MainActivity.this, Pres.class);
            startActivity(it);
        }else{
            Toast.makeText(this, "E-MAIL OU SENHA INVÁLIDOS", Toast.LENGTH_SHORT).show();

        }


    }

    private void performNextActivity2() {

        Toast.makeText(this, "Redefinir senha", Toast.LENGTH_SHORT).show();

        //trocar de janela (tela de pres) //
        Intent it = new Intent(MainActivity.this, RedefinirActivity.class);
        startActivity(it);

    }

    public class ClickButtonSignIn implements View
            .OnClickListener {
        @Override
        public void onClick(View view) {
            performNextActivity();
        }
    }

    public class ClickButtonSignUp implements View
            .OnClickListener {
        @Override
        public void onClick(View view) {
            performNextActivity2();
        }
    }

    public class EditTextAction implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {

            if (actionID == EditorInfo.IME_ACTION_DONE) {
                performNextActivity();
            }


            return false;
        }
    }


    public class ClickButtonCadastrar implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //trocar de janela (tela de cadastro) //
            Intent it = new Intent(MainActivity.this, Cadastro.class);
            startActivity(it);
        }
    }
}
