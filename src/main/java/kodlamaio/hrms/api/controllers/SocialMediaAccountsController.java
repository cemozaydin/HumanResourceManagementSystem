package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SocialMediaAccountService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMediaAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidatesocialmediaaccounts")
@CrossOrigin
public class SocialMediaAccountsController {
    private SocialMediaAccountService socialMediaAccountService;

    @Autowired
    public SocialMediaAccountsController(SocialMediaAccountService socialMediaAccountService) {
        this.socialMediaAccountService = socialMediaAccountService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody SocialMediaAccount socialMediaAccount){
        return this.socialMediaAccountService.add(socialMediaAccount);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.socialMediaAccountService.getAll();
    }
}
