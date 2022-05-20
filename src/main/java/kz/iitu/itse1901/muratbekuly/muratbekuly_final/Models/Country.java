package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country")
public class Country {
    @Id
    private Long id;
    private String name;
    private String capital;
}
