package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
import kodlamaio.hrms.entities.dtos.CandidateExperienceDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {
    private CandidateExperienceDao candidateExperienceDao;

    @Autowired
    public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
        this.candidateExperienceDao = candidateExperienceDao;
    }

    @Override
    public Result add(CandidateExperience candidateExperience) {
        this.candidateExperienceDao.save(candidateExperience);
        return new SuccessResult("İş deneyimi eklendi.");
    }

    @Override
    public Result update(CandidateExperience candidateExperience) {
        return null;
    }

    @Override
    public Result delete(CandidateExperience candidateExperience) {
        return null;
    }

    @Override
    public DataResult<List<CandidateExperience>> getAll() {
        return new SuccessDataResult<List<CandidateExperience>>(
                this.candidateExperienceDao.findAll());
    }

    @Override
    public DataResult<List<CandidateExperienceDetailsDto>> getAllCandidateExperienceDetails() {
        return new SuccessDataResult<List<CandidateExperienceDetailsDto>>(
                this.candidateExperienceDao.getAllCandidateExperienceDetails());
    }

    @Override
    public DataResult<List<CandidateExperienceDetailsDto>> getCandidateExperienceDetailsByCandidateId(int id) {
        return new SuccessDataResult<List<CandidateExperienceDetailsDto>>(
                this.candidateExperienceDao.getCandidateExperienceDetailsByCandidateId(id));
    }
}
