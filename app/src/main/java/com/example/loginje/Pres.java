package com.example.loginje;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pres  extends AppCompatActivity {

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setContentView(R.layout.activity_pres);

    }


    private void performNextActivity () {

        Toast.makeText(this, "Realizando Cadastro", Toast.LENGTH_SHORT).show();


    }}