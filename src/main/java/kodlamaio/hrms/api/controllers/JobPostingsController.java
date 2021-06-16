package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
@CrossOrigin
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting){
        return this.jobPostingService.add(jobPosting);
    }

    @PostMapping("/changeJobPostingStatus")
    public Result changeJobPostingStatus(@RequestBody int jobPostingId, boolean status){
        return this.jobPostingService.changeJobPostingStatus(jobPostingId, status);
    }

    @GetMapping("/getJobPostingDetails")
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetails(){
        return this.jobPostingService.getJobPostingDetails();
    }

    @GetMapping("/getJobPostingDetailsOrderByPostingReleaseDate")
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetailsOrderByPostingReleaseDate(){
        return this.jobPostingService.getJobPostingDetailsOrderByPostingReleaseDate();
    }

    @GetMapping("/getJobPostingDetailsByEmployerId")
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getJobPostingDetailsByEmployerId(int employerId){
        return this.jobPostingService.getJobPostingDetailsByEmployerId(employerId);
    }

}
