package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();
    DataResult<List<JobTitle>> getAllSortedAsc();
    DataResult<List<JobTitle>> getAllSortedDesc();
    DataResult<JobTitle> getByTitle(String title);
    DataResult<List<JobTitle>> getByTitleStartsWith(String title);
    Result add(JobTitle jobTitle);




}
