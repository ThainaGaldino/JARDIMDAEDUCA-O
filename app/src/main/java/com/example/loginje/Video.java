    package com.example.loginje;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.webkit.MimeTypeMap;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.AppCompatTextView;

    import java.util.Properties;

    import javax.mail.Authenticator;
    import javax.mail.Message;
    import javax.mail.MessagingException;
    import javax.mail.PasswordAuthentication;
    import javax.mail.Session;
    import javax.mail.Transport;
    import javax.mail.internet.AddressException;
    import javax.mail.internet.InternetAddress;
    import javax.mail.internet.MimeMessage;

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



        public void ButtonIniciarAtividade() throws AddressException {

            try {
                String stringSenderEmail = "jardimdaeducacao01@gmail.com";
                String stringReceiverEmail = "sarahingridcustodio2@gmail.com";
                String stringPasswordSenderEmail = "JD1234567";
                String stringhost = "smtp.gmail.com";

                Properties properties = System.getProperties();

                properties.put("mail.smtp.host", stringhost); // Correção aqui
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true"); // Correção aqui
                properties.put("mail.smtp.auth", "true");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail);
                    }
                });

                MimeMessage mimeMessage = new MimeMessage(session);
                mimeMessage.setFrom(new InternetAddress(stringSenderEmail)); // Defina o remetente
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stringReceiverEmail));
                mimeMessage.setSubject("Subject: Android App email");
                mimeMessage.setText("Hello Programmer \n\n teste \n\n Jardim");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Transport.send(mimeMessage);
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            } catch (AddressException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                // Se o e-mail for enviado com sucesso
                Toast.makeText(this, "Atividade encaminhada por e-mail cadastrado", Toast.LENGTH_SHORT).show();

            } finally {

            }

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