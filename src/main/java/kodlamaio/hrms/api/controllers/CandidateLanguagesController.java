package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidatelanguages")
public class CandidateLanguagesController {
    private CandidateLanguageService candidateLanguageService;

    @Autowired
    public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
        this.candidateLanguageService = candidateLanguageService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.candidateLanguageService.getAll();
    }

    @GetMapping("/getAllCandidateLanguageDetails")
    public Result getAllCandidateLanguageDetails(){
        return this.candidateLanguageService.getAllCandidateLanguageDetails();
    }

    @GetMapping("/getCandidateLanguageDetailsByCandidateId")
    public Result getCandidateLanguageDetailsByCandidateId(int id){
        return this.candidateLanguageService.getCandidateLanguageDetailsByCandidateId(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody CandidateLanguage candidateLanguage){
        return this.candidateLanguageService.add(candidateLanguage);
    }


}
