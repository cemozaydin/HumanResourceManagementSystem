package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSchoolManager implements CandidateSchoolService {
    private CandidateSchoolDao candidateSchoolDao;

    @Autowired
    public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao) {
        this.candidateSchoolDao = candidateSchoolDao;
    }

    @Override
    public Result add(CandidateSchool candidateSchool) {
        this.candidateSchoolDao.save(candidateSchool);
        return new SuccessResult("Eğitim Bilgisi Eklendi.");
    }

    @Override
    public Result update(CandidateSchool candidateSchool) {
        this.candidateSchoolDao.save(candidateSchool);
        return new SuccessResult("Eğitim Bilgisi Güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.candidateSchoolDao.deleteById(id);
        return new SuccessResult("Eğitim Bilgisi Silindi.");
    }

    @Override
    public DataResult<List<CandidateSchool>> getAll() {
        return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAll());
    }

    @Override
    public DataResult<List<CandidateSchool>> getAllByCandidate_id(int candidateId) {
        return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAllByCandidate_id(candidateId));
    }

    @Override
    public DataResult<List<CandidateSchool>> getAllByCandidate_idOrderByDesc(int candidateId) {
        return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAllByCandidate_idOrderByDesc(candidateId));
    }

    @Override
    public DataResult<List<CandidateSchoolDetailDto>> getAllCandidateSchoolDetails() {
        return new SuccessDataResult<List<CandidateSchoolDetailDto>>(this.candidateSchoolDao.getAllCandidateSchoolDetails());
    }
}
