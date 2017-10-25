package com.itazbuka.announcement.mail.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.bind.JsonTreeReader;
import com.itazbuka.announcement.mail.model.Reciver;
import com.itazbuka.announcement.mail.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by djordje.colovic on 25-Oct-17.
 */
@RestController
public class RegistrationController {

    private Logger logger = Logger.getLogger(RequestMapping.class);

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/signup")
    public String signup(){
        return "Please sign up for our service!";
    }
    @RequestMapping("/signup-success")
    public String signupSuccess(){
        List<String> success = new ArrayList<>();
        List<String> fail = new ArrayList<>();

        try {
            Gson gson = new Gson();


            JsonParser parser = new JsonParser();
            FileReader reader = new FileReader(new File("C:/Users/djordje.colovic/IdeaProjects/mail/src/main/resources/recivers.json"));
            JsonElement recivers = parser.parse(reader);
//             = gson.toJsonTree();
            System.out.println(recivers.getAsJsonObject().get("mails"));
            JsonElement mails = recivers.getAsJsonObject().get("mails");
            for (JsonElement je: mails.getAsJsonArray()) {
                System.out.println(je.getAsString());
                try {
                    notificationService.sentNotification(je.getAsString());
                    success.add(je.getAsString());
                }catch (MailException e){
                    fail.add(je.getAsString());
                    logger.info("what heppend");
                    e.printStackTrace();
                }
            }
//            System.out.println(recivers.getAsJsonArray().size());

            //notificationService.sentNotification();
        }catch (MailException e){
            logger.info("what heppend");
            e.printStackTrace();
            return "FUCK UP!";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //send email
        return "Thank you for registration. success " + success.size() + " fall " + fail.size();
    }
}
