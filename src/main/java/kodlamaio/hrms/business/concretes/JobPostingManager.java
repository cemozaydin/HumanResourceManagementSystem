package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {
    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public Result add(JobPosting jobPosting) {
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult();
    }

    @Override
    public Result changeJobPostingStatus(int jobPostingId, boolean status) {
        JobPosting jobPosting = this.jobPostingDao.findById(jobPostingId).get();
        jobPosting.setActive(status);
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult("İlan durumu değiştirildi.");
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetails() {
        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(this.jobPostingDao.getJobPostingWithEmployerAndJobTitleByisActive(true));
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetailsOrderByPostingReleaseDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"postingReleaseDate");
        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(this.jobPostingDao.getJobPostingWithEmployerAndJobTitleByisActive(true,sort));
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetailsByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(this.jobPostingDao.getJobPostingWithEmployerAndJobTitleByisActive(true,employerId));
    }
}
