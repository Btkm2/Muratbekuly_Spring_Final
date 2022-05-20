package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.TourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TourRepoImpl implements TourRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tour> findAll() {
        return jdbcTemplate.query("SELECT * FROM tours", new BeanPropertyRowMapper<>(Tour.class));
    }

    @Override
    public Tour findTourById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tours WHERE id = ?",(rs, rowNum) -> new Tour((long) rs.getInt("id"),rs.getObject("country_id", Country.class),rs.getString("duration"),rs.getObject("flight_id", Flight.class),rs.getObject("hotel_id",Hotel.class),rs.getInt("tour_price")));
    }

    @Override
    public int saveTour(Tour tour) {
        return jdbcTemplate.update("INSERT INTO tours(country_id,duration,flight_id,hotel_id,tour_price) values (?,?,?,?,?)",tour.getCountry_id(),tour.getDuration(),tour.getFlight_id(),tour.getHotel_id(),tour.getTour_price());
    }

    @Override
    public int deleteTour(Long id) {
        return jdbcTemplate.update("DELETE FROM tours WHERE id = ?",id);
    }
}
