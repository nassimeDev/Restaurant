package dev.nassime.restaurant1.services;

import dev.nassime.restaurant1.entities.EmailVerificationToken;
import dev.nassime.restaurant1.exception.EmailFailureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender mailSender;
    @Value("${mail.from.address}")
    private String fromAddress;
    @Value("${url}")
    private String url;

    //--------- dependency injection------------------
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public SimpleMailMessage mailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress);
        return message;
    }

    public void sendVerificationEmail(EmailVerificationToken emailVerificationToken) throws EmailFailureException {
        SimpleMailMessage message = mailMessage();
        message.setTo(emailVerificationToken.getClient().getEmail());
        message.setSubject("Verification Email");
        message.setText("follow the link below to verify your email to activate your account.\n"
                + url+"/client/verify?token="+emailVerificationToken.getToken());

        try{
            mailSender.send(message);
        }catch(MailException e){
            throw new EmailFailureException();
        }
    }
}
