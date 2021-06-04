package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.SendEmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

@Primary
@Component(value = "sendEmailManager")
public class SendEmailManager implements SendEmailService {
    private JavaMailSender emailSender;

    @Autowired
    public SendEmailManager(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public Result sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
        return new SuccessResult("Email Gönderimi Başarılı...");
    }
}
