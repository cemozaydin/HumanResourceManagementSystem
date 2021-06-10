package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CloudinaryConfig;

public interface CloudinaryConfigService {

    DataResult<CloudinaryConfig> getById(int id);
}
