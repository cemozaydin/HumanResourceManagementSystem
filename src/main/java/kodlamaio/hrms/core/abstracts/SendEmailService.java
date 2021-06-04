package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface SendEmailService {
    Result sendSimpleMessage(String to, String subject, String text);
}
