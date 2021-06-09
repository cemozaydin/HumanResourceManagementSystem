package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer> {
    List<CandidateSchool> findAll();
    List<CandidateSchool> findAllByCandidate_id(int candidateId);

    @Query(value = "FROM CandidateSchool cs Where cs.candidate.id=:candidateId ORDER BY cs.graduatedDate DESC")
    List<CandidateSchool> findAllByCandidate_idOrderByDesc(int candidateId);

    @Query(value = "SELECT new kodlamaio.hrms.entities.dtos.CandidateSchoolDetailDto" +
            "(cs.id, ca.id, ca.firstName, ca.lastName, " +
            "u.universityName, f.facultyName, d.departmentName, cs.startingDate, cs.graduatedDate) " +
            "FROM Candidate ca " +
            "INNER JOIN ca.candidateSchools cs " +
            "INNER JOIN University u ON cs.universityId = u.id " +
            "INNER JOIN Faculty f ON cs.facultyId = f.id " +
            "INNER JOIN Department d ON cs.departmentId = d.id " +
            "ORDER BY cs.graduatedDate DESC")
    List<CandidateSchoolDetailDto> getAllCandidateSchoolDetails();



}
