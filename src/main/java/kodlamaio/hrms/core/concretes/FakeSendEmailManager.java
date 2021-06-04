package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.SendEmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

@Component(value = "fakeSendEmailManager")
public class FakeSendEmailManager implements SendEmailService {

    @Autowired
    public FakeSendEmailManager() {
    }

    @Override
    public Result sendSimpleMessage(String to, String subject, String mailBodyMessage) {

        String mailTo = to;
        String mailSubject = subject;
        String mailText = mailBodyMessage;

        System.out.println(String.format("Kime : %s \nKonu başlığı %s. \nMail Gövdesi: %s",to,subject,mailBodyMessage));
        return new SuccessResult();
    }
}
