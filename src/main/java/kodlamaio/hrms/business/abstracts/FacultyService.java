package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Faculty;

import java.util.List;

public interface FacultyService {
    DataResult<List<Faculty>> getAll();
    DataResult<List<Faculty>> getFacultyByFacultyNameContains(String facultyName);
}
