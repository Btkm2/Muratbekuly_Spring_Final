package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
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

//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getLastname() {
//        return lastname;
//    }
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public String getPhone_number() {
//        return phone_number;
//    }
//    public void setPhone_number(String phone_number) {
//        this.phone_number = phone_number;
//    }
//
//    public User(String name, String lastname, String email, String phone_number) {
//        this.name = name;
//        this.lastname = lastname;
//        this.email = email;
//        this.phone_number = phone_number;
//    }

}
