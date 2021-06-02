package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Sen bir controllersın demek
@RequestMapping("/api/jobtitles")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll(){
        return this.jobTitleService.getAll();
    }

    @GetMapping("/getAllSortedAsc")
    public DataResult<List<JobTitle>> getAllSortedAsc(){
        return this.jobTitleService.getAllSortedAsc();
    }

    @GetMapping("/getAllSortedDesc")
    public DataResult<List<JobTitle>> getAllSortedDesc(){
        return this.jobTitleService.getAllSortedDesc();
    }

    @GetMapping("/getByTitle")
    public DataResult<JobTitle> getByTitle(@RequestParam String title){
        return this.jobTitleService.getByTitle(title);
    }

    @GetMapping("/getByTitleStartsWith")
    public DataResult<List<JobTitle>> getByTitleStartsWith(@RequestParam String title){
        return this.jobTitleService.getByTitleStartsWith(title);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.add(jobTitle);
    }
}
