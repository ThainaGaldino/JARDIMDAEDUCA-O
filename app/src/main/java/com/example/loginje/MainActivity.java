package com.example.loginje;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.annotation.SuppressLint;
=======
>>>>>>> b0d4214 (primeiro commit Thaina)
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

<<<<<<< HEAD
public class cadastro extends AppCompatActivity {}

        private TextView mTextViewserie, mTextViewcadastro ;
        private EditText mEditTextdatadenascimento, mEditTextemaildoresponsavel, mEditTextnomealuno ;
        private Button mButtoncadastro;

        //campo é obrigatório e não pode ser deixado em branco ou vazio
        private boolean isRequired(){
            if(TextUtils.isEmpty(mEditTextnomealuno.getText()) ||
                    TextUtils.isEmpty(mEditTextdatadenascimento.getText()) ||
                    TextUtils.isEmpty(mEditTextemaildoresponsavel.getText()) ) {
                return true;
            } else {}
            return false;
        }
        //responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
        private void performNextActivity(){
            if(isRequired()){
                Toast.makeText(this,"Mandatory information", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, presactivity.class));
            }
        }

        public static class ClickButtonEntrar implements View

        .OnClickListener{
            @Override
            public void onClick(View v) {

            }
        }

            public class EditTextAction implements TextView.OnEditorActionListener{
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                    if (actionId == EditorInfo.IME_ACTION_DONE){
                        performNextActivity();
                    }


                    return false;
                }
            }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mEditTextnomealuno=findViewById(R.id.editText_nome_aluno);
        mEditTextdatadenascimento=findViewById(R.id.editText_data_de_nascimento);
        mEditTextemaildoresponsavel=findViewById(R.id.editText_email_do_responsavel);

        mButtoncadastro=findViewById(R.id.button_cadastro);
        mButtoncadastro.setOnClickListener(new ClickButtonEntrar());

=======

    private EditText mEditextCredentials , mEdittextPassword ;
    private TextView mButtonSignUp;
    private Button mButtonSignIn  ;


    private boolean isRequired(){
        if (TextUtils.isEmpty(mEditextCredentials.getText()) ||
        TextUtils.isEmpty(mEdittextPassword.getText())) {
            return true;

        } else {
            return false;
        }
    }


    private void performNextActivity (){
        if (isRequired()){
            Toast.makeText(this,"Mandatory information", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"trocar de janela",Toast.LENGTH_SHORT).show();

     //trocar de janela (tela de pres) //

    }
    private void performNextActivity2 (){

        Toast.makeText(this,"Realizando Cadastro",Toast.LENGTH_SHORT).show();

        //trocar de janela (tela de pres) //
        Intent it= new Intent(MainActivity.this , RedefinirActivity.class);
        startActivity(it);

    }
    public class ClickButtonSiggnIn implements View
    .OnClickListener{
        @Override
        public void onClick(View view) {
            performNextActivity();
        }
    }
    public class ClickButtonSiggnUp implements View
            .OnClickListener{
        @Override
        public void onClick(View view) {
            performNextActivity2();
        }
    }

   public class EditTextAction implements TextView.OnEditorActionListener{
       @Override
       public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {

           if(actionID == EditorInfo.IME_ACTION_DONE){
               performNextActivity();
           }


           return false;
       }
   }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditextCredentials = findViewById(R.id.editText_credentials) ;
        mEdittextPassword = findViewById(R.id.editText_password);
        mEdittextPassword.setOnEditorActionListener(new EditTextAction());
        mButtonSignIn = findViewById(R.id.btn_sign_in);
        mButtonSignIn.setOnClickListener(new ClickButtonSiggnIn());

        mButtonSignUp = findViewById(R.id.btn_forgot_password);
        mButtonSignUp.setOnClickListener(new ClickButtonSiggnUp());
>>>>>>> b0d4214 (primeiro commit Thaina)

    }
}