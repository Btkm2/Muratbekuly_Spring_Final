package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services;

import jdk.jfr.Enabled;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Hotel;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.HotelRepo;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.HotelRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class HotelService implements HotelRepo {
    private final HotelRepoImpl hotelRepoimpl;

    @Autowired
    public HotelService(HotelRepoImpl hotelRepoimpl) {
        this.hotelRepoimpl = hotelRepoimpl;
    }

    @Override
    @Scheduled(fixedDelay = 10)
    public List<Hotel> findAll() {
        return hotelRepoimpl.findAll();
    }

    @Override
    public Hotel findHotelById(Long id) {
        return hotelRepoimpl.findHotelById(id);
    }

    @Override
    public int saveHotel(Hotel hotel) {
        return hotelRepoimpl.saveHotel(hotel);
    }

    @Override
    public int deleteHotel(Long id) {
        return hotelRepoimpl.deleteHotel(id);
    }
}
