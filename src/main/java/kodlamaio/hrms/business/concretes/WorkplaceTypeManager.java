package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkplaceTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkplaceTypeDao;
import kodlamaio.hrms.entities.concretes.WorkplaceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceTypeManager implements WorkplaceTypeService {
    private WorkplaceTypeDao workplaceTypeDao;

    @Autowired
    public WorkplaceTypeManager(WorkplaceTypeDao workplaceTypeDao) {
        this.workplaceTypeDao = workplaceTypeDao;
    }

    @Override
    public DataResult<List<WorkplaceType>> getAll() {
        return new SuccessDataResult<List<WorkplaceType>>(this.workplaceTypeDao.findAll());
    }
}
