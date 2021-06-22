package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkplaceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkplaceTypeDao extends JpaRepository<WorkplaceType, Integer> {
    List<WorkplaceType> findAll();
}
