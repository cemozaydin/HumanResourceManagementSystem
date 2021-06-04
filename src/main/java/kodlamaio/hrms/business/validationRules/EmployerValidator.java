package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.Objects;

public class EmployerValidator {

    public static Result employerValidator(Employer employer){

        if(Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getEmail()) ||
                Objects.isNull(employer.getWebAddress()) || Objects.isNull(employer.getPhoneNumber()) ||
                    Objects.isNull(employer.getPassword()))
        {
            return new ErrorResult("Alanlar boş bırakılamaz.");
        } else if(!emailCompareWithDomain(employer).isSuccess()){
                return new ErrorResult("Şirket Maili ile Web Adresiniz eşleşmiyor.");
        }
        return new SuccessResult();
    }

    private static Result emailCompareWithDomain(Employer employer){
        String domain = employer.getEmail().substring(employer.getEmail().indexOf("@")+1);

        if(!employer.getWebAddress().contains(domain))
        {
            return new ErrorResult();
        }
        return new SuccessResult();
    }

}
