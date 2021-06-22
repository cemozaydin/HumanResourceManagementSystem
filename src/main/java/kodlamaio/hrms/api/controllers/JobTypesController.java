package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobtypes")
public class JobTypesController {
    private JobTypeService jobTypeService;

    public JobTypesController(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.jobTypeService.getAll();
    }
}
