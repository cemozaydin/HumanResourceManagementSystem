package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SocialMediaAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaAccountDao;
import kodlamaio.hrms.entities.concretes.SocialMediaAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaAccountManager implements SocialMediaAccountService {
    private SocialMediaAccountDao socialMediaAccountDao;

    @Autowired
    public SocialMediaAccountManager(SocialMediaAccountDao socialMediaAccountDao) {
        this.socialMediaAccountDao = socialMediaAccountDao;
    }

    @Override
    public Result add(SocialMediaAccount socialMediaAccount) {
        this.socialMediaAccountDao.save(socialMediaAccount);
        return new SuccessResult("Sosyal Medya bilgisi eklendi.");
    }

    @Override
    public DataResult<List<SocialMediaAccount>> getAll() {
        return new SuccessDataResult<List<SocialMediaAccount>>(this.socialMediaAccountDao.findAll());
    }
}
