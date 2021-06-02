package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    List<Candidate> findAllByEmailOrIdentityNumber(String email, String identityNumber);
    List<Candidate> findAllByEmail(String email);
}
