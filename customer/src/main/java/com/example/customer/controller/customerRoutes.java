package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.repository.bookedRepository;
import com.example.customer.repository.customerRepository;

// import java.util.ArrayList;

import com.example.customer.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class infoRoute{
@GetMapping("actuator/info")
String infoHome(){
    return "Info Home Page"; 
}
}
@RequestMapping("/customer")
public class customerRoutes {

    @Autowired
    private customerRepository cust;

    @Autowired
    private bookedRepository book;
    @GetMapping("/showall")
    public @ResponseBody Iterable<Customer> showall() {
        Iterable<Customer> cc = cust.findAll();
        cc.forEach((item) -> {
            System.out.println(item.getCustName());
        });

        return cust.findAll();
    }

    @GetMapping("/insert")
    public String insertNewCustomer(@RequestParam String name) {
        Customer c = new Customer();
        c.setCustName(name);
        cust.save(c);
        return "new Customer added !!";
    }

    @GetMapping("/showBooking")
    public @ResponseBody Iterable<Booking> showBooking(@RequestParam int custId) {
        return book.findBycustId(custId);

    }

    @GetMapping("/booking")
    public String insertNewCustomer(@RequestParam int hotelId, @RequestParam int custId, @RequestParam int numRooms) {
        Booking b = new Booking();
        b.setCustId(custId);
        b.setHotelId(hotelId);
        b.setNumRooms(numRooms);
        book.save(b);
        return "booking complete !!";
    }

}
