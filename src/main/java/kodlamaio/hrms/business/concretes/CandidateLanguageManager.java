package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private CandidateLanguageDao candidateLanguageDao;

    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
        this.candidateLanguageDao = candidateLanguageDao;
    }

    @Override
    public Result add(CandidateLanguage candidateLanguage) {

        if(candidateLanguage.getLevel()<1 || candidateLanguage.getLevel()>5){
            return new ErrorResult("Dil Seviyesi 1-5 arasında girilmelidir.");
        }


        if(this.candidateLanguageDao.existsCandidateLanguageByLanguageId(candidateLanguage.getLanguageId())){
            return new ErrorResult("Eklemeye çalıştığınız yabancı dil daha önce eklenmiş.");
        }
        this.candidateLanguageDao.save(candidateLanguage);
        return new SuccessResult("Yabancı Dil bilgisi eklendi.");
    }

    @Override
    public Result delete(int languageId) {
        this.candidateLanguageDao.deleteById(languageId);
        return null;
    }

    @Override
    public Result update(int languageId) {
        return null;
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAll() {
        return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll());
    }

    @Override
    public DataResult<List<CandidateLanguageDetailDto>> getAllCandidateLanguageDetails() {
        return new SuccessDataResult<List<CandidateLanguageDetailDto>>(this.candidateLanguageDao.getAllCandidateLanguageDetails());
    }
}
