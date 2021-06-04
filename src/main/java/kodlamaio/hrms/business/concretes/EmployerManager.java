package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.core.abstracts.SendEmailService;
import kodlamaio.hrms.core.utilities.generator.Genarator;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private SendEmailService sendEmailService;

    @Autowired
    public EmployerManager(
            EmployerDao employerDao,
            @Qualifier("fakeSendEmailManager") SendEmailService sendEmailService
    ) {
        this.employerDao = employerDao;
        this.sendEmailService=sendEmailService;
    }

    @Override
    public Result register(Employer employer, String passwordConfirm) {
        Result result = EmployerValidator.employerValidator(employer);

        if(!result.isSuccess())
        {
            return result;
        }

        if(!Objects.equals(employer.getPassword(),passwordConfirm)){
            return new ErrorResult("Şİfre eşleşmedi. Kayıt Başarısız...");
        }

        String genarator = Genarator.generateString();
        String mailBodyMessage = String.format("Kayıt işleminin tamamlanabilmesi için gerekli kod : %s " ,genarator);

        this.employerDao.save(employer);
        this.sendEmailService.sendSimpleMessage(employer.getEmail(),"Kayıt Onaylama Hk.", mailBodyMessage);
        return new SuccessResult("İşveren başarıyla kayıt edildi.");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler Listelendi.");
    }

    @Override
    public DataResult<Employer> getAllByEmail(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getAllByEmail(email));
    }
}
