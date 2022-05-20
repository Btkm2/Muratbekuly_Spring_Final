package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit_card")
public class CreditCard {
    @Id
    private Long id;
    private String currency;
    private Integer amount;
}
