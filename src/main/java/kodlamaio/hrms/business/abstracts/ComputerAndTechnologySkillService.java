package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ComputerAndTechnologySkill;

import java.util.List;

public interface ComputerAndTechnologySkillService {
    Result add(ComputerAndTechnologySkill computerAndTechnologySkill);
    Result delete(int skillId);
    Result update(ComputerAndTechnologySkill computerAndTechnologySkill);

    DataResult<List<ComputerAndTechnologySkill>> getAll();
}
