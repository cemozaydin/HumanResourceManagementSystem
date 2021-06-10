package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CloudinaryConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudinaryConfigDao extends JpaRepository<CloudinaryConfig, Integer> {

    CloudinaryConfig findById(int id);
}
