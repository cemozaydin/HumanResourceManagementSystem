package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.abstracts.CheckMernisService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
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

    @Autowired
    public CandidateManager(CandidateDao candidateDao, @Qualifier("checkMernisAdapter") CheckMernisService checkMernisService, EmailCheckService emailCheckService) {
        super();
        this.candidateDao = candidateDao;
        this.checkMernisService = checkMernisService;
        this.emailCheckService = emailCheckService;
    }

    @Override
    public Result register(Candidate candidate, String passwordConfirm) {

        if(Objects.isNull(candidate.getFirstName())){
            return new ErrorResult("İsim alanı boş bırakılamaz.");
        }else if(Objects.isNull(candidate.getLastName())){
            return new ErrorResult("Soyisim alanı boş bırakılamaz.");
        }else if(Objects.isNull(candidate.getEmail())) {
            return new ErrorResult("E-mail alanı boş bırakılamaz.");
        }else if(Objects.isNull(candidate.getIdentityNumber())) {
            return new ErrorResult("Kimlik Numarası alanı boş bırakılamaz.");
        }else if(Objects.isNull(candidate.getBirthDate())) {
            return new ErrorResult("Doğum Tarihi alanı boş bırakılamaz.");
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

        this.candidateDao.save(candidate);
        return new SuccessResult("<<< Kayıt Başarılı >>>");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
    }

    public boolean isEmailUsed(String email){
        List<Candidate> emailList = this.candidateDao.findAllByEmail(email);
        if(emailList.size()>0){
            return false;
        }
        return true;
    }

    public boolean isIdentityNumberUsed(String identityNumber){
        List<Candidate> identityList = this.candidateDao.findAllByEmailOrIdentityNumber(null,identityNumber);
        if(identityList.size()>0){
            return  false;
        }
        return true;
    }

}
