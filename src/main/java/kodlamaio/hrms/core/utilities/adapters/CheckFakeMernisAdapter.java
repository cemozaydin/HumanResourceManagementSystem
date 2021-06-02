package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.core.abstracts.CheckMernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class CheckFakeMernisAdapter implements CheckMernisService {
    @Override
    public boolean checkIfRealPerson(Candidate candidate) {
        return true;
    }
}
