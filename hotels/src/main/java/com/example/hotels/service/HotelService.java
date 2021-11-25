package com.example.hotels.service;

import com.example.hotels.model.Hotel;
import com.example.hotels.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllhotels() {
        return hotelRepository.findAll();
    }

    public Hotel gethotel(String hotelID) {
        return hotelRepository.findById(hotelID).orElse(null);
    }


    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void delete(String hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    public Hotel update(Hotel hotel, String hotelId) {
        Hotel hotel1 = hotelRepository.findById(hotelId).get();
        hotel1.setHname(hotel.getHname());
        hotel1.setOname(hotel.getOname());
        hotel1.setAddress(hotel.getAddress());
        hotel1.setNumRooms(hotel.getNumRooms());
        hotelRepository.save(hotel1);
        return hotel1;
    }

    public void deleteAll() {
        hotelRepository.deleteAll();
    }
}
