package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface HotelRepo {
    List<Hotel> findAll();
    Hotel findHotelById(Long id);
    int saveHotel(Hotel hotel);
    int deleteHotel(Long id);
}
