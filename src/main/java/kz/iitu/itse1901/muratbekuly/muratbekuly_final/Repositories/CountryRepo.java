package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo {
    List<Country> findAll();
    Country findCountryById(Long id);
    Country saveCountry(Country country);
    void deleteCountry(Country country);
}
