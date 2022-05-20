package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Country;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.CountryRepo;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.CountryRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements CountryRepo {
    private final CountryRepoImpl countryRepoimpl;

    @Autowired
    public CountryService(CountryRepoImpl countryRepoimpl) {
        this.countryRepoimpl = countryRepoimpl;
    }

    @Override
    public List<Country> findAll() {
        return countryRepoimpl.findAll();
    }

    @Override
    public Country findCountryById(Long id) {
        return countryRepoimpl.findCountryById(id);
    }

    @Override
    public int saveCountry(Country country) {
        return countryRepoimpl.saveCountry(country);
    }

    @Override
    public int deleteCountry(Long id) {
        return countryRepoimpl.deleteCountry(id);
    }
}
