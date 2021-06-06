package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyDao extends JpaRepository<Currency, Integer> {
    List<Currency> findAll();
    Currency findCurrencyByCurrencyCode(String currencyCode);
    List<Currency> findCurrencyByCurrencyNameContains(String currencyName);

}
