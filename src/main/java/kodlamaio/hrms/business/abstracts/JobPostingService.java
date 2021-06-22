package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDetailsDto;

import java.util.List;

public interface JobPostingService {

    Result add(JobPosting jobPosting);
    Result updateJobPostingIsActiveStatus(int jobPostingId, boolean status);
    Result updateJobPostingAdminConfirmStatus(int jobPostingId, boolean status);

    DataResult<JobPosting> getJobPostingById(int id);

    DataResult<List<JobPosting>> getAll();
    DataResult<List<JobPosting>> getAllByIsActiveAndPendingApproval();
    DataResult<List<JobPosting>> getAllByIsActiveAndAdminApproved();
    DataResult<List<JobPosting>> getAllByIsActiveFalse();
    DataResult<List<JobPosting>> getAllByIsActiveAndPendingApprovalOrderByDeadlineDesc();
    DataResult<List<JobPosting>> getAllByIsActiveAndAdminConfirmAndEmployerId(int employerId);
    DataResult<List<JobPosting>> getAllByIsActiveAndPendingApprovalAndEmployerId(int employerId);

}
