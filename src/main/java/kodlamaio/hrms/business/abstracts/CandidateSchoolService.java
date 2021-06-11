package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDetailsDto;

import java.util.List;

public interface CandidateSchoolService {
    Result add(CandidateSchool candidateSchool);
    Result update(CandidateSchool candidateSchool);
    Result delete(int id);

    DataResult<List<CandidateSchool>> getAll();
    DataResult<List<CandidateSchool>> getAllByCandidate_id(int candidateId);
    DataResult<List<CandidateSchool>> getAllByCandidate_idOrderByDesc(int candidateId);
    DataResult<List<CandidateSchoolDetailsDto>> getAllCandidateSchoolDetails();
    DataResult<List<CandidateSchoolDetailsDto>> getCandidateSchoolDetailsByCandidateId(int id);

}
