package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

    JobTitle getByTitle(String title);
    List<JobTitle> getByTitleStartsWith(String title);
}
