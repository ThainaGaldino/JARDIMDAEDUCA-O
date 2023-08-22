package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;


public class Cadastro extends AppCompatActivity {

    private TextView mTextViewserie, mTextViewcadastro;
    private EditText mEditTextdatadenascimento, mEditTextemaildoresponsavel, mEditTextnomealuno;
    private Button mButtonconcluir;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mEditTextnomealuno = findViewById(R.id.editText_nome_aluno);
        mEditTextdatadenascimento = findViewById(R.id.editText_data_de_nascimento);
        mEditTextemaildoresponsavel = findViewById(R.id.editText_email_do_responsavel);

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
            Toast.makeText(this, "Mandatory information", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Cadastro.this, MainActivity.class));
        }
    }

    public String getnome() {
        return null;
    }

    public String getemail() {
        return null;
    }

    public String getpassword() {
        return null;
    }

    public String getnivel() {
        return null;
    }

    public String getId() {
        return null;
    }

    public String getname() {
        return null;
    }

    public class ClickButtonConcluir implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    public class EditTextAction implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                performNextActivity();
            }


            return false;
        }


    }

    private ChipGroup mChipGroupOption;
    private Chip mChip0, mChip1, mChip2;

    int vChipValue;
    String mMessage;

    // funcionalidade para cancelar
    private void executeCancel() {
        Intent mIntentResponse = new Intent();
        setResult(RESULT_CANCELED, mIntentResponse);
        finish();
    }

    // ouvinte do clique para cancelar
    public class ClickMyCancel implements View

            .OnClickListener {
        @Override
        public void onClick(View v) {
            executeCancel();
        }
    }

    // regra de negocio: obrigatorio - nome, preco e frequencia
    private boolean isInputInvalid() {
        if (TextUtils.isEmpty(mEditTextnomealuno.getText()) ||
                TextUtils.isEmpty(mEditTextdatadenascimento.getText()) ||
                TextUtils.isEmpty(mEditTextemaildoresponsavel.getText()) ||
                vChipValue == 0) {
        } else {
        }


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


        return false;
    }

    // funcionalidade para retornar com os dados
    // para a atividade anterior INSERT/UPDATE  modo ADD/EDIT
    private void saveCadastro() {
        if (isInputInvalid()) {
            mMessage = "Nome do Aluno, E-mail do responsavel e  Data de nascimento - sao obrigatorios";
            Toast.makeText(getApplicationContext(), mMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        Object mMode = "ADD";
        Intent mIntentResponse = new Intent();
        int vId = getIntent().getIntExtra("EXTRA_ID", -1);
        if (vId != -1) {
            mMode = "EDIT";
            mIntentResponse.putExtra("EXTRA_ID", vId);
        }

    }

    public class ClickMyButtonConcluir implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            saveCadastro();
        }
    }

    public class ChipGroupMySelectionChip implements ChipGroup.OnCheckedStateChangeListener {
        @Override
        public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
            switch (group.getCheckedChipId()) {
                case R.id.chip_consumption_cycle_0:
                    vChipValue = 0;
                    break;
                case R.id.chip_consumption_cycle_1:
                    vChipValue = 1;
                    break;
                case R.id.chip_consumption_cycle_2:
                    vChipValue = 2;
                    break;
                default:
                    vChipValue = 0;


            }
        }
    }


    private void setChipNumber(int vChipValue) {
        switch (vChipValue) {
            case 0:
                mChip0.setChecked(true);
                break;
            case 1:
                mChip1.setChecked(true);
                break;
            case 2:
                mChip2.setChecked(true);
                break;

        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_main);

    }


}