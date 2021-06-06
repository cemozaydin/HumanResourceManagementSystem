package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CurrencyService;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currencies")
public class CurrenciesController {
    private CurrencyService currencyService;

    @Autowired
    public CurrenciesController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/getall")
    public Result getAll(){
        return  this.currencyService.getAll();
    }

    @GetMapping("getCurrencyByCurrencyCode")
    public Result getCurrencyByCurrencyCode(String currencyCode){
        return this.currencyService.getCurrencyByCurrencyCode(currencyCode);
    }

    @GetMapping("getCurrencyByCurrencyNameContains")
    public Result getCurrencyByCurrencyNameContains(String currencyName){
        return  this.currencyService.getCurrencyByCurrencyNameContains(currencyName);
    }
}
