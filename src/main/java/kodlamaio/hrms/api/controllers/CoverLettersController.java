package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coverletterscontroller")
@CrossOrigin
public class CoverLettersController {
    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CoverLetter coverLetter){
        return this.coverLetterService.add(coverLetter);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.coverLetterService.getAll();
    }

}
