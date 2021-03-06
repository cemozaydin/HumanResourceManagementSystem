package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkplaceType;

import java.util.List;

public interface WorkplaceTypeService {
    DataResult<List<WorkplaceType>> getAll();
}
