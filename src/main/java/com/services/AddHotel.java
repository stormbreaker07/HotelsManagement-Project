package com.services;

import com.exceptions.HotelAlreadyRegisteredException;
import com.hotel.Hotel;
import com.hotel.HotelInterface;
import com.database.HotelDatabase;

/**
 * service use to add hotel object in the database
 * if hotel object is already exist it throws exception
 * wiht a message (hotel already registered)
 */
public class AddHotel{

    HotelInterface newHotel = null;

    public AddHotel(Hotel hotel) {
     newHotel = hotel;
    }

   public int add() {
        try {
            int id = HotelDatabase.addData(newHotel);
            return id;
        }
        catch(HotelAlreadyRegisteredException e) {
            System.out.println(e);
        }
        return -1;
    }
}
