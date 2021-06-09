package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityDao extends JpaRepository<University, Integer> {
    List<University> findAll();
}
