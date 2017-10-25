package com.itazbuka.announcement.mail.model;

/**
 * Created by djordje.colovic on 25-Oct-17.
 */
public class Reciver {
    private String eMail;


    public Reciver(String eMail) {
        this.eMail = eMail;
    }


    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
