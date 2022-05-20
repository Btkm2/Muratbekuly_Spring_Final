package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.CreditCard;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Tour;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.User;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",(rs, rowNum) -> new User((long) rs.getInt("id"),rs.getString("name"),rs.getString("lastname"),rs.getString("email"),rs.getString("phone_number"),rs.getObject("tour_id", Tour.class),rs.getObject("creditCard_id", CreditCard.class)));
    }

    @Override
    public int saveUser(User user) {
        return jdbcTemplate.update("INSERT INTO users(name,lastname,email,phone_number,tour_id,creditCard_id) values (?,?,?,?,?,?)",user.getName(),user.getLastname(),user.getEmail(),user.getPhone_number(),user.getTour_id(),user.getCreditCard_id());
    }

    @Override
    public int deleteUser(Long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?",id);
    }
}
