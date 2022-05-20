package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight")
public class Flight {
    @Id
    private Long id;
    private Integer flight_number;
    private Country country;
}
