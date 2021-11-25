package com.example.hotels.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class Hotel {
    @Id
    private String id;
    @Column
    private String hname;
    @Column
    private String oname;
    @Column
    private String address;
    @Column
    private int numRooms;
	public Hotel()
	{
		
	}
    public Hotel(String string, String string2, String string3) {
        id=string;
		hname=string2;
		oname=string3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }


}

