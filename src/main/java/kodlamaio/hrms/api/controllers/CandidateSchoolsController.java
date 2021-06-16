package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidateschools")
@CrossOrigin
public class CandidateSchoolsController {
    private CandidateSchoolService candidateSchoolService;

    @Autowired
    public CandidateSchoolsController(CandidateSchoolService candidateSchoolService) {
        this.candidateSchoolService = candidateSchoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateSchool candidateSchool){
       return this.candidateSchoolService.add(candidateSchool);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CandidateSchool candidateSchool){
        return this.candidateSchoolService.update(candidateSchool);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.candidateSchoolService.delete(id);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.candidateSchoolService.getAll();
    }

    @GetMapping("/getAllCandidateSchoolDetails")
    public Result getAllCandidateSchoolDetails(){
        return this.candidateSchoolService.getAllCandidateSchoolDetails();
    }

    @GetMapping("/getCandidateSchoolDetailsByCandidateId")
    public Result getCandidateSchoolDetailsByCandidateId(@RequestParam int id){
        return this.candidateSchoolService.getCandidateSchoolDetailsByCandidateId(id);
    }




    @GetMapping("/getAllByCandidate_idOrderByDesc")
    public Result getAllByCandidate_idOrderByDesc(int candidateId){
        return this.candidateSchoolService.getAllByCandidate_idOrderByDesc(candidateId);
    }
}
