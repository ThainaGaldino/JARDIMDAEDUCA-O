package com.example.loginje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pres  extends AppCompatActivity {

    private TextView mTextViewpre1, mTextViewpre2, mTextViewpre3;

    @Override
protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    setContentView(R.layout.activity_pres);

        class TextViewpre1 implements View.OnClickListener {
            @Override
            public void onClick(View view) {
                //trocar de janela (tela de cadastro) //
                Intent it= new Intent(Pres.this, Habilidade.class);
                startActivity(it);
            }
        }




}

}
