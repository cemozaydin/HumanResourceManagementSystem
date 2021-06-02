package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Candidate candidate, String passwordConfirm){
        return this.candidateService.register(candidate, passwordConfirm);
    }

    @GetMapping("/getall")
    public Result getAll(){
        return this.candidateService.getAll();
    }
}
