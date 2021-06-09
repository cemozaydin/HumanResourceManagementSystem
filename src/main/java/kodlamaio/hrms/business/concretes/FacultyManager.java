package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.FacultyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.FacultyDao;
import kodlamaio.hrms.entities.concretes.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.util.StringUtils.capitalize;

import java.util.List;

@Service
public class FacultyManager implements FacultyService {
    private FacultyDao facultyDao;

    @Autowired
    public FacultyManager(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    @Override
    public DataResult<List<Faculty>> getAll() {
        return new SuccessDataResult<List<Faculty>>(this.facultyDao.findAll());
    }

    @Override
    public DataResult<List<Faculty>> getFacultyByFacultyNameContains(String facultyName) {
        return new SuccessDataResult<List<Faculty>>(this.facultyDao.findFacultyByFacultyNameContains(capitalize(facultyName.toLowerCase())));
    }
}
