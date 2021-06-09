package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ComputerAndTechnologySkillService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ComputerAndTechnologySkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/computerandtechnologyskills")
public class ComputerAndTechnologySkillsController {
    private ComputerAndTechnologySkillService computerAndTechnologySkillService;

    @Autowired
    public ComputerAndTechnologySkillsController(ComputerAndTechnologySkillService computerAndTechnologySkillService) {
        this.computerAndTechnologySkillService = computerAndTechnologySkillService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ComputerAndTechnologySkill computerAndTechnologySkill){
        return this.computerAndTechnologySkillService.add(computerAndTechnologySkill);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.computerAndTechnologySkillService.getAll();
    }

}
