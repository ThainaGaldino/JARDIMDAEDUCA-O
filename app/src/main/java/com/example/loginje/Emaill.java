package com.example.loginje;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginje.R;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emaill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    public void buttonIniciarAtividade(View view) {

        final String senderEmail = "jardimdaeducacao01@gmail.com";
        final String receiverEmail = "sarahingridcustodio2@gmail.com";
        final String password = "JD1234567"; // Defina a senha corretamente aqui
        final String host = "smtp.gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("Atividade Conhecendo o Corpo Humano");
            message.setText("Segue o anexo abaixo:");

            Transport.send(message);

            // Email enviado com sucesso
        } catch (MessagingException e) {
            e.printStackTrace();
            // Trate os erros de envio de email aqui
        }
    }
}
