package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyDao extends JpaRepository<Faculty,Integer> {
    List<Faculty> findAll();
    List<Faculty> findFacultyByFacultyNameContains(String facultyName);
}
