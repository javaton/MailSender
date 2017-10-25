package com.itazbuka.announcement.mail.service;

import com.itazbuka.announcement.mail.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by djordje.colovic on 25-Oct-17.
 */
@Service
public class NotificationService {


    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;
    }

    public void sentNotification(String reciverMail){
        //sent mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(reciverMail);
        mail.setFrom("djordje.colovic@it-azbuka.com");
        mail.setSubject("Promo radionica test");
        mail.setText(MailUtil.getMailText());

        javaMailSender.send(mail);
    }
}
