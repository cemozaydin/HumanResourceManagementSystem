package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCVDetailsDto;

import java.util.List;

public interface CandidateService {
    Result register(Candidate candidate, String passwordConfirm);
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getById(int id);
    DataResult<CandidateCVDetailsDto> getCandidateCVDetailsByCandidateId(int id);

}
