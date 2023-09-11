package com.example.loginje;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class Video extends AppCompatActivity {

    private Button mButtonIniciarAtividade;
    private AppCompatTextView txtAssistir;

    String videoEscolhido = "";

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent it = getIntent();
        videoEscolhido = it.getStringExtra("videoEscolhido");

        mButtonIniciarAtividade = findViewById(R.id.button_iniciar_atividade);
        txtAssistir = findViewById(R.id.textView_assistir);

        txtAssistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirVideo(videoEscolhido);
            }
        });

    }

    private void abrirVideo(String videoEscolhido) {

        // TODO - trazer vídeo escolhido do banco de dados
        VideoSql videoSql = VideoDao.listOneVideo(getApplicationContext(), videoEscolhido);

        Uri uri = Uri.parse(videoSql.getmLink());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void performNextActivity() {
        if (isRequired()) {
            Toast.makeText(this, "Mandatory information", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Video.this, Habilidade.class);
        startActivity(intent);
    }

    private boolean isRequired() {
        return false;
    }

    public String getnome() {
        return null;
    }

    public String getId() {
        return null;
    }

    public String getlink() {
        return null;
    }
}