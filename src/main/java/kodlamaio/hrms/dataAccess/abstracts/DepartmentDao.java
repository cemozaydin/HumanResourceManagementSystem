package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
    List<Department> findAll();
    List<Department> findAllByDepartmentNameContains(String departmentName);
}
