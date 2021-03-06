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
            @Qualifier("fakeSendEmailManager") SendEmailService sendEmailService
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
            return new ErrorResult("E-Mail ge??ersiz. L??tfen ge??erli bir mail adresi giriniz.");
        }

        if(!this.checkMernisService.checkIfRealPerson(candidate)){
            return new ErrorResult("Kimlik Bilgisi Do??rulanamad??. Kay??t Ba??ar??s??z...");
        }

        if(!isEmailUsed(candidate.getEmail())){
            return new ErrorResult("E-Mail sistemde mevcut. Kay??t Ba??ar??s??z...");
        }

        if(!isIdentityNumberUsed(candidate.getIdentityNumber())){
            return new ErrorResult("Kimlik Numaras?? sistemde mevcut. Kay??t Ba??ar??s??z...");
        }

        if(!Objects.equals(candidate.getPassword(),passwordConfirm)){
        return new ErrorResult("????fre e??le??medi. Kay??t Ba??ar??s??z...");
        }

    String genarator = Genarator.generateString();
    String mailBodyMessage = String.format("Kay??t i??leminin tamamlanabilmesi i??in gerekli kod : %s " ,genarator);

    this.candidateDao.save(candidate);
    this.sendEmailService.sendSimpleMessage(candidate.getEmail(),"Kay??t Onaylama Hk.", mailBodyMessage);
        return new SuccessResult("<<< Kay??t Ba??ar??l??. Kullan??c??ya mail g??nderildi. >>>");
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
