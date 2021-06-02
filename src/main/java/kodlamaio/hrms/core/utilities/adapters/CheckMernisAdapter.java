package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.core.abstracts.CheckMernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernisService.AOBKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class CheckMernisAdapter implements CheckMernisService {
    @Override
    public boolean checkIfRealPerson(Candidate candidate) {

        AOBKPSPublicSoap aobkpsPublicSoap = new AOBKPSPublicSoap();

        boolean result = false;

        try {
            result = aobkpsPublicSoap.TCKimlikNoDogrula(
                    Long.parseLong(candidate.getIdentityNumber()),
                    candidate.getFirstName().toUpperCase(),
                    candidate.getLastName().toUpperCase(),
                    candidate.getBirthDate().getYear());

        }catch (Exception e){
            System.out.println("Not a valid person");
        }
        return result;
    }
}
