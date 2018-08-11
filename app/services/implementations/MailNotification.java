package services.implementations;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.IMail;

/**
 * @author Dheeraj Reddy
 */

@Singleton
public class MailNotification implements IMail {

    Logger logger = LoggerFactory.getLogger(MailNotification.class);

    private Config config;
    private Email simpleEmail;
    private String hostname;
    private int smtpPort;
    private String username;
    private String password;
    private boolean ssl;

    @Inject
    public MailNotification(Config config) {
        this.config = config;
        this.hostname = config.getString("email.hostname");
        this.smtpPort = config.getInt("email.port");
        this.username = config.getString("email.username");
        this.password = config.getString("email.password");
        this.ssl = config.getBoolean("email.ssl");

        Preconditions.checkNotNull(this.hostname, "EMAIL_HOSTNAME cannot be null");
        Preconditions.checkNotNull(this.smtpPort, "EMAIL_SMTP_PORT cannot be null");
        Preconditions.checkNotNull(this.username, "EMAIL_USERNAME cannot be null");
        Preconditions.checkNotNull(this.password, "EMAIL_PASSWORD cannot be null");
        Preconditions.checkNotNull(this.ssl, "EMAIL_SSL cannot be null");
    }

    @Override
    public void sendSimpleMail() {
        try {
            simpleEmail = sendSimpleEmail();
            simpleEmail.setFrom("ekartv2.play@gmail.com","Ekartv2 Admin");
            simpleEmail.setSubject("TestMail");
            simpleEmail.setMsg("This is a test mail ... :-)");
            simpleEmail.addTo("kdheeraj4995@gmail.com","Dheeraj Reddy");
            String a = simpleEmail.send();
            logger.info("Mail Sent"+a);
        } catch (EmailException e) {
            logger.error(e.getMessage());
        }

    }

    private Email sendSimpleEmail(){
        Email email = new SimpleEmail();
        email.setAuthentication(username, password);
        email.setHostName(hostname);
        email.setSmtpPort(smtpPort);
        email.setSSLOnConnect(ssl);
        return email;
    }

}
