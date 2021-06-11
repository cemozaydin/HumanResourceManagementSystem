package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CandidateLanguageDetailsDto;

import java.util.List;

public interface CandidateLanguageService {
    Result add(CandidateLanguage candidateLanguage);
    Result delete(int languageId);
    Result update(int languageId);

    DataResult<List<CandidateLanguage>> getAll();
    DataResult<List<CandidateLanguageDetailsDto>> getAllCandidateLanguageDetails();
    DataResult<List<CandidateLanguageDetailsDto>> getCandidateLanguageDetailsByCandidateId(int id);


}
