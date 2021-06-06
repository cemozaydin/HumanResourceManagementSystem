package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Currency;

import java.util.List;

public interface CurrencyService {
    DataResult<List<Currency>> getAll();
    DataResult<Currency> getCurrencyByCurrencyCode(String currencyCode);
    DataResult<List<Currency>> getCurrencyByCurrencyNameContains(String currencyName);


}
