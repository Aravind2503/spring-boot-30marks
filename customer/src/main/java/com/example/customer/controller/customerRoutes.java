package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.repository.bookedRepository;
import com.example.customer.repository.customerRepository;

import java.util.Collections;

// import java.util.ArrayList;

import com.example.customer.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/")
@RestController
class infoRoute {
    @GetMapping("actuator/info")
    String infoHome() {
        return "Info Home Page";
    }
}

@RestController
@RequestMapping("/customer")
public class customerRoutes {

    private final RestTemplate restTemplate;

    public customerRoutes(RestTemplateBuilder rTemplateBuilder) {
        this.restTemplate = rTemplateBuilder.build();
    }

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
        try {

            Booking b = new Booking();
            int availableRooms = getHotelList(Integer.toString(hotelId)).getNumRooms();
            if (numRooms <= availableRooms) {
                b.setCustId(custId);
                b.setHotelId(hotelId);
                b.setNumRooms(numRooms);
                book.save(b);
                // HotelSerialize h =
                // getHotelList(Integer.toString(hotelId)).setNumRooms(availableRooms-numRooms);
                updatePost(Integer.toString(hotelId), availableRooms - numRooms);
                return "booking complete !!";

            }
            return "rooms not available";
        } catch (Exception e) {
            e.printStackTrace();
            // return "error";
            return e.getLocalizedMessage();
        }
    }

    public HotelSerialize getHotelList(String hotelId) {
        String url = "http://localhost:3002/hotel/get/{hotelId}";
        return this.restTemplate.getForObject(url, HotelSerialize.class, hotelId);
    }

    @GetMapping("/gethotels")
    public String gethotel() {

        System.out.println(getHotelList("1").getNumRooms());
        return "ok";
    }

    public void updatePost(String hotelId, int remainingRooms) {
        String url = "http://localhost:3002/hotel/updatehotel/{hotelId}";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a post object
        HotelSerialize post = new HotelSerialize(getHotelList(hotelId).getHname(),
                getHotelList(hotelId).getOname(), getHotelList(hotelId).getAddress(), remainingRooms);

        // build the request
        HttpEntity<HotelSerialize> entity = new HttpEntity<>(post, headers);

        // send PUT request to update post with `id` 10
        this.restTemplate.put(url, entity, hotelId);
    }

}
