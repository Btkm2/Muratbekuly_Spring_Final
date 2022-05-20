package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    private Long id;
    private Country country_id;
    private String duration;
    private Flight flight_id;
    private Hotel hotel_id;
    private Integer tour_price;
}
