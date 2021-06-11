package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
import kodlamaio.hrms.entities.dtos.CandidateExperienceDetailsDto;

import java.util.List;

public interface CandidateExperienceService {
    Result add(CandidateExperience candidateExperience);
    Result update(CandidateExperience candidateExperience);
    Result delete(CandidateExperience candidateExperience);

    DataResult<List<CandidateExperience>> getAll();
    DataResult<List<CandidateExperienceDetailsDto>> getAllCandidateExperienceDetails();
    DataResult<List<CandidateExperienceDetailsDto>> getCandidateExperienceDetailsByCandidateId(int id);


}
