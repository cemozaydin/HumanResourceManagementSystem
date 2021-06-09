package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {

    List<CandidateLanguage> findAll();

    boolean existsCandidateLanguageByLanguageId(int languageId);

    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.CandidateLanguageDetailDto" +
            "(cl.id, ca.id, lng.name, cl.level) " +
            "FROM Candidate ca " +
            "INNER JOIN ca.candidateLanguages cl " +
            "INNER JOIN Language lng ON cl.languageId = lng.id")
    List<CandidateLanguageDetailDto> getAllCandidateLanguageDetails();

}
