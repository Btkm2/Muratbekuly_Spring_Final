package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Country;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Flight;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Hotel;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Tour;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRepoImpl implements HotelRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HotelRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hotel> findAll() {
        return jdbcTemplate.query("SELECT * FROM hotel", new BeanPropertyRowMapper<>(Hotel.class));
    }

    @Override
    public Hotel findHotelById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM hotel WHERE id = ?",(rs, rowNum) -> new Hotel((long) rs.getInt("id"),rs.getString("hotel_name"),rs.getInt("room_number"),rs.getInt("price"),rs.getInt("number_of_beds")));
    }

    @Override
    public int saveHotel(Hotel hotel) {
        return jdbcTemplate.update("INSERT INTO hotel(hotel_name,room_number,price,number_of_beds) values (?,?,?,?)",hotel.getHotel_name(),hotel.getRoom_number(),hotel.getPrice(),hotel.getNumber_of_beds());
    }

    @Override
    public int deleteHotel(Long id) {
        return jdbcTemplate.update("DELETE FROM hotel WHERE id = ?",id);
    }
}
