package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.University;

import java.util.List;

public interface UniversityService {
    DataResult<List<University>> getAll();
}
