package com.whut.cailiao.ms.impl.utils.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gammaniu on 16/4/26.
 */
public class EmailUtil {

    public final static Executor executor = Executors.newFixedThreadPool(4);

    public static void sendEmail(Mail mail) {
        executor.execute(() -> {
            Email email = new SimpleEmail();
            String fromEmail = "";
            String password = "";
            email.setHostName("smtp.163.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(fromEmail, password));
            email.setSSLOnConnect(true);
            try {
                email.setFrom(fromEmail);
                email.setSubject(mail.getTitle());
                email.setMsg(mail.getContent());
                email.addTo(mail.getToWho());
                email.send();
            } catch (EmailException e) {
                e.printStackTrace();
            }
        });

    }
}
