package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Country;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.CreditCard;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Flight;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CreditCardRepoImpl implements CreditCardRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CreditCardRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CreditCard> findAll() {
        return jdbcTemplate.query("SELECT * FROM credit_card", new BeanPropertyRowMapper<>(CreditCard.class));
    }

    @Override
    public CreditCard findCreditCardById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM credit_card WHERE id = ?",(rs, rowNum) -> new CreditCard((long) rs.getInt("id"),rs.getString("currency"),rs.getInt("amount")));
    }

    @Override
    public int saveCreditCard(CreditCard creditCard) {
        return jdbcTemplate.update("INSERT INTO credit_card(currency,amount) values (?,?)",creditCard.getCurrency(),creditCard.getAmount());
    }

    @Override
    public int deleteCreditCard(Long id) {
        return jdbcTemplate.update("DELETE FROM credit_card WHERE id = ?",id);
    }
}
