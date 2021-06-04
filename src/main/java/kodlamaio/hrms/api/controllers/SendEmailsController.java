package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.core.abstracts.SendEmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendemails")
public class SendEmailsController {

    private SendEmailService sendEmailService;

    @Autowired
    public SendEmailsController(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    @GetMapping("/send")
    public Result sendEmail(String to, String subject, String text){
        return this.sendEmailService.sendSimpleMessage(to, subject, text);
    }
}
