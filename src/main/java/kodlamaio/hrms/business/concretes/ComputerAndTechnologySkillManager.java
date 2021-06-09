package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ComputerAndTechnologySkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ComputerAndTechnologySkillDao;
import kodlamaio.hrms.entities.concretes.ComputerAndTechnologySkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerAndTechnologySkillManager implements ComputerAndTechnologySkillService {
    private ComputerAndTechnologySkillDao computerAndTechnologySkillDao;

    @Autowired
    public ComputerAndTechnologySkillManager(ComputerAndTechnologySkillDao computerAndTechnologySkillDao) {
        this.computerAndTechnologySkillDao = computerAndTechnologySkillDao;
    }

    @Override
    public Result add(ComputerAndTechnologySkill computerAndTechnologySkill) {
        this.computerAndTechnologySkillDao.save(computerAndTechnologySkill);
        return new SuccessResult("Bilgisayar ve Teknoloji yeteneği eklendi.");
    }

    @Override
    public Result delete(int skillId) {
        return null;
    }

    @Override
    public Result update(ComputerAndTechnologySkill computerAndTechnologySkill) {
        return null;
    }

    @Override
    public DataResult<List<ComputerAndTechnologySkill>> getAll() {
        return new SuccessDataResult<List<ComputerAndTechnologySkill>>(this.computerAndTechnologySkillDao.findAll());
    }
}
