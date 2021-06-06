package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;

import java.util.List;

public interface JobPostingService {

    Result add(JobPosting jobPosting);
    Result changeJobPostingStatus(int jobPostingId, boolean status);

    DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetails();
    DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetailsOrderByPostingReleaseDate();
    DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetailsByEmployerId(int employerId);

}
