package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    private Long id;
    private String hotel_name;
    private Integer room_number;
    private Integer price;
    private Integer number_of_beds;
}
