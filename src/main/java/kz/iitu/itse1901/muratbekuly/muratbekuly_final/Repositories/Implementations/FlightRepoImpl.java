package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepoImpl implements FlightRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FlightRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Flight> findAll() {
        return jdbcTemplate.query("SELECT * FROM flight", new BeanPropertyRowMapper<>(Flight.class));
    }

    @Override
    public Flight findFlightById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM flight WHERE id = ?",(rs, rowNum) -> new Flight((long) rs.getInt("id"),rs.getInt("flight_number"),rs.getObject("country",Country.class)));
    }

    @Override
    public int saveFlight(Flight flight) {
        return jdbcTemplate.update("INSERT INTO flight(flight_number,country) values (?,?)",flight.getFlight_number(),flight.getCountry());
    }

    @Override
    public int deleteFlight(Long id) {
        return jdbcTemplate.update("DELETE FROM flight WHERE id = ?",id);
    }
}
