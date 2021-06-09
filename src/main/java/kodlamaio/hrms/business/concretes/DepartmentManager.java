package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.apache.commons.text.WordUtils.*;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {
    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<List<Department>>(this.departmentDao.findAll());
    }

    @Override
    public DataResult<List<Department>> getAllByDepartmentNameContains(String departmentName) {
        return new SuccessDataResult<List<Department>>(this.departmentDao.findAllByDepartmentNameContains(capitalizeFully(departmentName.toLowerCase())));
    }
}
