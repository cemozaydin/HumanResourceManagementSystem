package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    //User getById(int id);
    List<User> findAll();
    User findUserById(int id);
    User getUserById(int id);
}
