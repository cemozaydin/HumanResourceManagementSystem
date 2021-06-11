package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCVDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    Candidate findByIdentityNumber(String identityNumber);
    List<Candidate> findAllByEmail(String email);
    Candidate findById(int id);

    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.CandidateCVDetailsDto(c) " +
            "FROM Candidate c WHERE c.id=:id")
    CandidateCVDetailsDto findCandidateCVDetailsByCandidateId(int id);



}
