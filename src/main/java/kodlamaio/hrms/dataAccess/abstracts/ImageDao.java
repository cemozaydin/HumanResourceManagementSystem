package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {
        List<Image> findAll();
        List<Image> getAllByUserId(int userId);


}
