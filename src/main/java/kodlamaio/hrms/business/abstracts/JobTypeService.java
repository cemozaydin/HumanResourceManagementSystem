package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobType;

import java.util.List;

public interface JobTypeService {
    DataResult<List<JobType>> getAll();
}
