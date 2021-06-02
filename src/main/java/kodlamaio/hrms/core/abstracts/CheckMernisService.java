package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CheckMernisService {

    boolean checkIfRealPerson(Candidate candidate);

}
