package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.CreditCard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepo {
    List<CreditCard> findAll();
    CreditCard findCreditCardById(Long id);
    CreditCard saveCreditCard(CreditCard creditCard);
    void deleteCreditCard(CreditCard creditCard);
}
