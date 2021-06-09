package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {
    DataResult<List<Department>> getAll();
    DataResult<List<Department>> getAllByDepartmentNameContains(String departmentName);
}
