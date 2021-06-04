package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.abstracts.CheckMernisService;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.Objects;

public class CandidateValidator {

    public static Result validatorForCandidate(Candidate candidate){

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
        return new SuccessResult();
    }
}
