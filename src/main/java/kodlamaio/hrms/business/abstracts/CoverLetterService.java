package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService {
    Result add(CoverLetter coverLetter);
    Result update(CoverLetter coverLetter);
    Result delete(int coverLetterId);

    DataResult<List<CoverLetter>> getAll();
}
