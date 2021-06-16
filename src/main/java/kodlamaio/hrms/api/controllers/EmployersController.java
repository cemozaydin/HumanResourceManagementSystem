package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employers")
@CrossOrigin
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Employer employer, String passwordConfirm){
        return this.employerService.register(employer,passwordConfirm);
    }

    @GetMapping("/getall")
    public Result getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/getByEmail")
    public Result getByEmail(String email){
        return this.employerService.getAllByEmail(email);
    }
}
