package com.itazbuka.announcement.mail;

/**
 * Created by djordje.colovic on 25-Oct-17.
 */
public class MailUtil {

    public static String getMailText(){
        String mail =  new String("Poštovani,\n" +
                "\n" +
                "Hvala na interesovanju koje ste pokazali za naše besplatne radionice.\n" +
                "\n" +
                "Vaše dete možete dovesti u subotu (28.10.2017.) od 17h na našu adresu Terazije 12(drugi sprat liftom ili treći sprat stepenicama). Trajanje radionice je 1h, o samoj školici i programu kursa moći ćete da se informišete posle radionice.\n" +
                "\n" +
                "Zamolio bih Vas da potvrdite da li Vam ovaj termin odgovara ili da pokušamo da nađemo novi.\n" +
                "\n" +
                "Pozdrav,\n" +
                "Đorđe Čolović\n" +
                "IT azbuka\n" +
                "0643655001\n" +
                "www.it-azbuka.com\n" +
                "www.facebook.com/azbuka.it/");
        return mail;
    }
}
