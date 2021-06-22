package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
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

    @PostMapping("/updateJobPostingIsActiveStatus")
    public Result updateJobPostingIsActiveStatus(@RequestParam int jobPostingId, boolean status){
        return this.jobPostingService.updateJobPostingIsActiveStatus(jobPostingId, status);
    }

    @PostMapping("/updateJobPostingAdminConfirmStatus")
    public Result updateJobPostingAdminConfirmStatus(@RequestParam int jobPostingId, boolean status){
        return this.jobPostingService.updateJobPostingAdminConfirmStatus(jobPostingId,status);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosting>> getAll(){
        return this.jobPostingService.getAll();
    }

    @GetMapping("/getAllByIsActiveAndPendingApproval")
    public DataResult<List<JobPosting>> getAllByIsActiveAndPendingApproval(){
        return this.jobPostingService.getAllByIsActiveAndPendingApproval();
    }

    @GetMapping("/getAllByIsActiveAndAdminApproved")
    public DataResult<List<JobPosting>> getAllByIsActiveAndAdminApproved(){
        return this.jobPostingService.getAllByIsActiveAndAdminApproved();
    }

    @GetMapping("/getAllByIsActiveFalse")
    public DataResult<List<JobPosting>> getAllByIsActiveFalse(){
        return this.jobPostingService.getAllByIsActiveFalse();
    }

    @GetMapping("/getAllByIsActiveAndPendingApprovalOrderByDeadlineDesc")
    public DataResult<List<JobPosting>> getAllByIsActiveAndPendingApprovalOrderByDeadlineDesc(){
        return this.jobPostingService.getAllByIsActiveAndPendingApprovalOrderByDeadlineDesc();
    }

    @GetMapping("/getAllByIsActiveAndAdminConfirmAndEmployerId")
    public DataResult<List<JobPosting>> getAllByIsActiveAndAdminConfirmAndEmployerId(@RequestParam int employerId){
        return this.jobPostingService.getAllByIsActiveAndAdminConfirmAndEmployerId(employerId);
    }

    @GetMapping("/getAllByIsActiveAndPendingApprovalAndEmployerId")
    public DataResult<List<JobPosting>> getAllByIsActiveAndPendingApprovalAndEmployerId(@RequestParam int employerId){
        return this.jobPostingService.getAllByIsActiveAndPendingApprovalAndEmployerId(employerId);
    }

    @GetMapping("/getJobPostingById")
    public DataResult<JobPosting> getJobPostingById(@RequestParam int id){
        return this.jobPostingService.getJobPostingById(id);
    }


}
