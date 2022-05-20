package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone_number;
    private Tour tour_id;
    private CreditCard creditCard_id;

}
