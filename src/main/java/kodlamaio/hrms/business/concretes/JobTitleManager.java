package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //Bu class service görevini görecek demek
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Ünvanlar Listelendi");
    }

    @Override
    public DataResult<List<JobTitle>> getAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"title");
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(sort),"A-Z'ye göre Listendi.");
    }

    @Override
    public DataResult<List<JobTitle>> getAllSortedDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"title");
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(sort),"Z-A'ya göre Listendi.");
    }

    @Override
    public Result add(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Ünvan eklendi");
    }

    @Override
    public DataResult<JobTitle> getByTitle(String title) {
        return new SuccessDataResult<JobTitle>(this.jobTitleDao.getByTitle(title),"Ünvan Listelendi");
    }

    @Override
    public DataResult<List<JobTitle>> getByTitleStartsWith(String title) {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.getByTitleStartsWith(title));
    }

}
