package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.CreditCard;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.CreditCardRepo;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.CreditCardRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService implements CreditCardRepo {
    private final CreditCardRepoImpl creditCardRepoimpl;

    @Autowired
    public CreditCardService(CreditCardRepoImpl creditCardRepoimpl) {
        this.creditCardRepoimpl = creditCardRepoimpl;
    }

    @Override
    public List<CreditCard> findAll() {
        return creditCardRepoimpl.findAll();
    }

    @Override
    public CreditCard findCreditCardById(Long id) {
        return creditCardRepoimpl.findCreditCardById(id);
    }

    @Override
    public int saveCreditCard(CreditCard creditCard) {
        return creditCardRepoimpl.saveCreditCard(creditCard);
    }

    @Override
    public int deleteCreditCard(Long id) {
        return creditCardRepoimpl.deleteCreditCard(id);
    }
}
