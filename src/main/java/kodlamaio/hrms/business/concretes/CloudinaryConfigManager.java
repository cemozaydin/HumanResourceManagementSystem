package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CloudinaryConfigService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CloudinaryConfigDao;
import kodlamaio.hrms.entities.concretes.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudinaryConfigManager implements CloudinaryConfigService {
    private CloudinaryConfigDao cloudinaryConfigDao;

    @Autowired
    public CloudinaryConfigManager(CloudinaryConfigDao cloudinaryConfigDao) {
        this.cloudinaryConfigDao = cloudinaryConfigDao;
    }

    @Override
    public DataResult<CloudinaryConfig> getById(int id) {
        return new SuccessDataResult<CloudinaryConfig>(this.cloudinaryConfigDao.findById(id));
    }
}
