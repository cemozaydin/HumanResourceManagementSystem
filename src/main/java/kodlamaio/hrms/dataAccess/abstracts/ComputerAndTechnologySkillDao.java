package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ComputerAndTechnologySkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerAndTechnologySkillDao extends JpaRepository<ComputerAndTechnologySkill, Integer> {
    List<ComputerAndTechnologySkill> findAll();
}
