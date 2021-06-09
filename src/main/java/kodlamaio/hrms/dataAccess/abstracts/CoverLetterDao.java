package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
    List<CoverLetter> findAll();
}
