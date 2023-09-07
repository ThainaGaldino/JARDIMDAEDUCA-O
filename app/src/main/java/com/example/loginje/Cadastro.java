package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Cadastro extends AppCompatActivity {

    private TextView mTextViewserie, mTextViewcadastro;
    private AppCompatEditText mEditTextdatadenascimento, mEditTextemaildoresponsavel, mEditTextnomealuno, mEditTextsenha;
    private Button mButtonconcluir;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mEditTextnomealuno = findViewById(R.id.editText_nome_aluno);
        mEditTextdatadenascimento = findViewById(R.id.editText_data_de_nascimento);
        mEditTextemaildoresponsavel = findViewById(R.id.editText_email_do_responsavel);
        mEditTextsenha = findViewById(R.id.editText_senha);

        mButtonconcluir = findViewById(R.id.button_concluir);
        mButtonconcluir.setOnClickListener(new ClickButtonConcluir());

    }

    //campo é obrigatório e não pode ser deixado em branco ou vazio
    private boolean isRequired() {
        if (TextUtils.isEmpty(mEditTextnomealuno.getText()) ||
                TextUtils.isEmpty(mEditTextdatadenascimento.getText()) ||
                TextUtils.isEmpty(mEditTextemaildoresponsavel.getText())) {
            return true;
        } else {
        }
        return false;
    }

    //responsável por iniciar ou executar a próxima atividade (activity) no fluxo de um aplicativo Android.
    private void performNextActivity() {
        if (isRequired()) {
            Toast.makeText(this, "Cadastro", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Cadastro.this, MainActivity.class));
        }
    }

    public class ClickButtonConcluir implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mEditTextnomealuno = findViewById(R.id.editText_nome_aluno);
            mEditTextdatadenascimento = findViewById(R.id.editText_data_de_nascimento);
            mEditTextemaildoresponsavel = findViewById(R.id.editText_email_do_responsavel);
            mEditTextsenha = findViewById(R.id.editText_senha);

            String mEmail = mEditTextemaildoresponsavel.getText().toString();
            String mSenha = mEditTextsenha.getText().toString();
            String mNome = mEditTextnomealuno.getText().toString();
            String mDatanasc = mEditTextdatadenascimento.getText().toString();




            class Datanasc {
                public void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Digite sua data de nascimento (formato: dd/mm/aaaa): ");
                    String Datanasc = scanner.nextLine();

                    // Dividir a string em dia, mês e ano
                    String[] partes = Datanasc.split("/");

                    if (partes.length == 3) {
                        int dia = Integer.parseInt(partes[0]);
                        int mes = Integer.parseInt(partes[1]);
                        int ano = Integer.parseInt(partes[2]);

                        // Validar a data (isso é um exemplo simples, você pode adicionar mais validações)
                        if (validarData(dia, mes, ano)) {
                            System.out.println("Data de nascimento válida: " + Datanasc);
                        } else {
                            System.out.println("Data de nascimento inválida.");
                        }
                    } else {
                        System.out.println("Formato da data de nascimento inválido.");
                    }

                    scanner.close();
                }

                // Função para validar a data
                public boolean validarData(int dia, int mes, int ano) {
                    // Adicione suas regras de validação aqui
                    // Por exemplo, verifique se o ano é válido, se o mês está entre 1 e 12, etc.
                    // Este é apenas um exemplo simples.

                    return ano >= 1900 && ano <= 2023 && mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31;
                }
            }
            Intent it = new Intent(Cadastro.this, MainActivity.class);
            startActivity(it);
        }
    }
}



//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date dataNasc;
//
//            int resultado = 0;
//            String ajustada = mDatanasc.substring(6,10) + "-" + mDatanasc.substring(3,5) + "-"
//                    + mDatanasc.substring(0,2);
//            resultado = UserDao.insertUser(mNome, mEmail, mSenha, ajustada, getApplicationContext());
//            if(resultado==1){


//    public class EditTextAction implements TextView.OnEditorActionListener {
//        @Override
//        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                performNextActivity();
//            }


//            return false;
//        }
//
//
//    }

//    private ChipGroup mChipGroupOption;
//    private Chip mChip0, mChip1, mChip2;

//    int vChipValue;
//    String mMessage;
//
//    // funcionalidade para cancelar
//    private void executeCancel() {
//        Intent mIntentResponse = new Intent();
//        setResult(RESULT_CANCELED, mIntentResponse);
//        finish();
//    }

    // ouvinte do clique para cancelar
//    public class ClickMyCancel implements View
//
//            .OnClickListener {
//        @Override
//        public void onClick(View v) {
//            executeCancel();
//        }
//    }


//    private boolean isInputInvalid() {
//        if (TextUtils.isEmpty(mEditTextnomealuno.getText()) ||
//                TextUtils.isEmpty(mEditTextdatadenascimento.getText()) ||
//                TextUtils.isEmpty(mEditTextemaildoresponsavel.getText()) ||
//                vChipValue == 0) {
//        } else {
//        }


        //        if(vChipValue == 0){
//            return  true;
//        } else {
//            return false;
//        }
//
//        if(TextUtils.isEmpty(mEditTextName.getText())){
//            return  true;
//        } else {
//            return false;
//        }
//
//        if(TextUtils.isEmpty(mEditTextPrice.getText())){
//            return  true;
//        } else {
//            return false;
//        }


//        return false;
//    }
//
    // funcionalidade para retornar com os dados
    // para a atividade anterior INSERT/UPDATE  modo ADD/EDIT
//    private void saveCadastro() {
//        if (isInputInvalid()) {
//            mMessage = "Nome do Aluno, E-mail do responsavel e  Data de nascimento - sao obrigatorios";
//            Toast.makeText(getApplicationContext(), mMessage, Toast.LENGTH_SHORT).show();
//            return;
//        }

//        Object mMode = "ADD";
//        Intent mIntentResponse = new Intent();
//        int vId = getIntent().getIntExtra("EXTRA_ID", -1);
//        if (vId != -1) {
//            mMode = "EDIT";
//            mIntentResponse.putExtra("EXTRA_ID", vId);
//        }
//
//    }

//    public class ClickMyButtonConcluir implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            saveCadastro();
//        }
//    }

//    public class ChipGroupMySelectionChip implements ChipGroup.OnCheckedStateChangeListener {
//        @Override
//        public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
////            switch (group.getCheckedChipId()) {
////                case R.id.chip_consumption_cycle_0:
////                    vChipValue = 0;
////                    break;
////                case R.id.chip_consumption_cycle_1:
////                    vChipValue = 1;
////                    break;
////                case R.id.chip_consumption_cycle_2:
////                    vChipValue = 2;
////                    break;
////                default:
////                    vChipValue = 0;
////
////
////            }
//        }
//    }


//    private void setChipNumber(int vChipValue) {
//        switch (vChipValue) {
//            case 0:
//                mChip0.setChecked(true);
//                break;
//            case 1:
//                mChip1.setChecked(true);
//                break;
//            case 2:
//                mChip2.setChecked(true);
//                break;
//
//        }
//    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//
//        setContentView(R.layout.activity_main);
//
//    }


