package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidateexperiences")
@CrossOrigin
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

    @GetMapping("/getCandidateExperienceDetailsByCandidateId")
    public Result getCandidateExperienceDetailsByCandidateId(@RequestParam int id){
        return this.candidateExperienceService.getCandidateExperienceDetailsByCandidateId(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody CandidateExperience candidateExperience){
        return this.candidateExperienceService.add(candidateExperience);
    }

}
