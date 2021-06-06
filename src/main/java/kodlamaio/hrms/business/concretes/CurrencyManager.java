package kodlamaio.hrms.business.concretes;

import antlr.StringUtils;
import kodlamaio.hrms.business.abstracts.CurrencyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CurrencyDao;
import kodlamaio.hrms.entities.concretes.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.util.StringUtils.capitalize;

import java.util.List;
@Service
public class CurrencyManager implements CurrencyService {
    private CurrencyDao currencyDao;

    @Autowired
    public CurrencyManager(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public DataResult<List<Currency>> getAll() {
        return new SuccessDataResult<List<Currency>>(this.currencyDao.findAll());
    }

    @Override
    public DataResult<Currency> getCurrencyByCurrencyCode(String currencyCode) {
        return new SuccessDataResult<Currency>(this.currencyDao.findCurrencyByCurrencyCode(currencyCode.toUpperCase()));
    }


    @Override
    public DataResult<List<Currency>> getCurrencyByCurrencyNameContains(String currencyName) {
        return new SuccessDataResult<List<Currency>>(this.currencyDao.findCurrencyByCurrencyNameContains(capitalize(currencyName.toLowerCase())));
    }
}
