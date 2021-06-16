package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.FacultyService;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin
public class FacultiesController {
    private FacultyService facultyService;

    @Autowired
    public FacultiesController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.facultyService.getAll();
    }

    @GetMapping("/getFacultyByFacultyNameContains")
    public Result getFacultyByFacultyNameContains(String facultyName){
        return this.facultyService.getFacultyByFacultyNameContains(facultyName);
    }

}
