// package com.example.hotelCrud.controller;

// import com.example.hotelCrud.model.hotel;
// import com.example.hotelCrud.service.hotelService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

package com.example.hotels.controller;

import com.example.hotels.model.Hotel;
import com.example.hotels.service.HotelService;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/reservationForm")
    public String reservationForm(Model model) {
        model.addAttribute("reservationForm", new Hotel());
        return "reservationForm";
    }

    @GetMapping("/getAllhotels")
    public List<Hotel> getAllhotels() {
        return hotelService.getAllhotels();
    }

    @GetMapping("/get/{hotelId}")
    public Hotel gethotel(@PathVariable String hotelId) {
        return hotelService.gethotel(hotelId);
    }

    @PostMapping("/createhotel")
    public Hotel createhotel(@RequestBody Hotel hotel) {
        return hotelService.create(hotel);
    }

    @DeleteMapping("/deletehotel/{hotelId}")
    public String deletehotel(@PathVariable String hotelId) {
        hotelService.delete(hotelId);
        return "hotel Deleted";
    }

    @PutMapping("/updatehotel/{hotelId}")
    public Hotel updatehotel(@RequestBody Hotel hotel, @PathVariable String hotelId) {
        return hotelService.update(hotel, hotelId);
    }

    @DeleteMapping("/deleteAll")
    public String deletehotels() {
        hotelService.deleteAll();
        return "All hotels data deleted";
    }
}
