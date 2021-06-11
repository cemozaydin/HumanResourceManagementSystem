package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.abstracts.CheckMernisService;
import kodlamaio.hrms.core.abstracts.SendEmailService;
import kodlamaio.hrms.core.utilities.generator.Genarator;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCVDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private CheckMernisService checkMernisService;
    private EmailCheckService emailCheckService;
    private SendEmailService sendEmailService;

    @Autowired
    public CandidateManager(
            CandidateDao candidateDao,
            @Qualifier("checkFakeMernisAdapter") CheckMernisService checkMernisService,
            EmailCheckService emailCheckService,
            @Qualifier("sendEmailManager") SendEmailService sendEmailService
    ) {
        super();
        this.candidateDao = candidateDao;
        this.checkMernisService = checkMernisService;
        this.emailCheckService = emailCheckService;
        this.sendEmailService = sendEmailService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findById(id));
    }

    @Override
    public DataResult<CandidateCVDetailsDto> getCandidateCVDetailsByCandidateId(int id) {
        return new SuccessDataResult<CandidateCVDetailsDto>(this.candidateDao.findCandidateCVDetailsByCandidateId(id));
    }

    @Override
    public Result register(Candidate candidate, String passwordConfirm) {

        var result = CandidateValidator.validatorForCandidate(candidate);

        if(!result.isSuccess())
        {
            return result;
        }

        if(!this.emailCheckService.emailCheck(candidate.getEmail()))
        {
            return new ErrorResult("E-Mail geçersiz. Lütfen geçerli bir mail adresi giriniz.");
        }

        if(!this.checkMernisService.checkIfRealPerson(candidate)){
            return new ErrorResult("Kimlik Bilgisi Doğrulanamadı. Kayıt Başarısız...");
        }

        if(!isEmailUsed(candidate.getEmail())){
            return new ErrorResult("E-Mail sistemde mevcut. Kayıt Başarısız...");
        }

        if(!isIdentityNumberUsed(candidate.getIdentityNumber())){
            return new ErrorResult("Kimlik Numarası sistemde mevcut. Kayıt Başarısız...");
        }

        if(!Objects.equals(candidate.getPassword(),passwordConfirm)){
        return new ErrorResult("Şİfre eşleşmedi. Kayıt Başarısız...");
        }

    String genarator = Genarator.generateString();
    String mailBodyMessage = String.format("Kayıt işleminin tamamlanabilmesi için gerekli kod : %s " ,genarator);

    this.candidateDao.save(candidate);
    this.sendEmailService.sendSimpleMessage(candidate.getEmail(),"Kayıt Onaylama Hk.", mailBodyMessage);
        return new SuccessResult("<<< Kayıt Başarılı. Kullanıcıya mail gönderildi. >>>");
}

    public boolean isEmailUsed(String email){
        List<Candidate> emailList = this.candidateDao.findAllByEmail(email);
        if(emailList.size()>0){
            return false;
        }
        return true;
    }

    public boolean isIdentityNumberUsed(String identityNumber){
        Candidate result = this.candidateDao.findByIdentityNumber(identityNumber);
        if(result!=null){
            return  false;
        }
        return true;
    }

}
