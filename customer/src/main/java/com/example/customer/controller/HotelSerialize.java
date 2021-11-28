package com.example.customer.controller;

import java.io.Serializable;

public class HotelSerialize implements Serializable {

    private String hotelId;

    private String hname;

    private String oname;

    private String address;

    private Integer numRooms;

    public HotelSerialize() {
    }

    public HotelSerialize(String hotelId, String hname, String oname, String address, Integer numRooms) {
        this.hotelId = hotelId;
        this.hname = hname;
        this.oname = oname;
        this.address = address;
        this.numRooms = numRooms;
    }

    public HotelSerialize(String hname, String oname, String address, Integer numRooms) {

        this.hname = hname;
        this.oname = oname;
        this.address = address;
        this.numRooms = numRooms;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

}
