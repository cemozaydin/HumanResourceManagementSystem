package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;

public interface UserService {
    Result add(User user);
}
