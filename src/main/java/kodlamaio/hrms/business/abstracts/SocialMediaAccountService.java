package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMediaAccount;

import java.util.List;

public interface SocialMediaAccountService {
    Result add(SocialMediaAccount socialMediaAccount);
    DataResult<List<SocialMediaAccount>> getAll();
}
