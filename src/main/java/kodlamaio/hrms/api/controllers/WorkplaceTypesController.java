package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkplaceTypeService;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workplacetypes")
public class WorkplaceTypesController {
    private WorkplaceTypeService workplaceTypeService;

    public WorkplaceTypesController(WorkplaceTypeService workplaceTypeService) {
        this.workplaceTypeService = workplaceTypeService;
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.workplaceTypeService.getAll();
    }
}
