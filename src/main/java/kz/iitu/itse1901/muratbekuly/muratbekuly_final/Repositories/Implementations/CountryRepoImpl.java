package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CountryRepoImpl implements CountryRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query("SELECT * FROM country", new BeanPropertyRowMapper<>(Country.class));
    }

    @Override
    public Country findCountryById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM country WHERE id = ?",(rs, rowNum) -> new Country((long) rs.getInt("id"),rs.getString("name"),rs.getString("capital")));
    }

    @Override
    public int saveCountry(Country country) {
        return jdbcTemplate.update("INSERT INTO country(name,capital) values (?,?)",country.getName(),country.getCapital());
    }

    @Override
    public int deleteCountry(Long id) {
        return jdbcTemplate.update("DELETE FROM country WHERE id = ?",id);
    }
}
