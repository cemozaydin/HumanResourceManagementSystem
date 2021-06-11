package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateExperience;
import kodlamaio.hrms.entities.dtos.CandidateExperienceDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer> {

    List<CandidateExperience> findAll();

    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.CandidateExperienceDetailsDto" +
            "(ce.id, ca.id, ca.firstName, ca.lastName, ce.workplace, ce.jobTitle,ct.cityName,ce.startingDate, ce.endingDate) " +
            "FROM Candidate ca " +
            "INNER JOIN ca.candidateExperiences ce " +
            "INNER JOIN City ct ON ce.cityId = ct.id " +
            "ORDER BY ce.endingDate DESC")
    List<CandidateExperienceDetailsDto> getAllCandidateExperienceDetails();

    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.CandidateExperienceDetailsDto" +
            "(ce.id, ca.id, ca.firstName, ca.lastName, ce.workplace, ce.jobTitle,ct.cityName,ce.startingDate, ce.endingDate) " +
            "FROM Candidate ca " +
            "INNER JOIN ca.candidateExperiences ce " +
            "INNER JOIN City ct ON ce.cityId = ct.id " +
            "WHERE ca.id =:id " +
            "ORDER BY ce.endingDate DESC")
    List<CandidateExperienceDetailsDto> getCandidateExperienceDetailsByCandidateId(int id);

}
