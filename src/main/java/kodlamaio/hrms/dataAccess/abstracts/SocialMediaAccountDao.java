package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialMediaAccountDao extends JpaRepository<SocialMediaAccount, Integer> {

    List<SocialMediaAccount> findAll();
}
