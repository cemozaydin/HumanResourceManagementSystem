package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
import kodlamaio.hrms.entities.dtos.CandidateExperienceDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidateexperiences")
public class CandidateExperiencesController {
    private CandidateExperienceService candidateExperienceService;

    @Autowired
    public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
        this.candidateExperienceService = candidateExperienceService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.candidateExperienceService.getAll();
    }

    @GetMapping("/getAllCandidateExperienceDetails")
    public Result getAllCandidateExperienceDetails(){
        return this.candidateExperienceService.getAllCandidateExperienceDetails();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateExperience candidateExperience){
        return this.candidateExperienceService.add(candidateExperience);
    }

}
