package com.services;

import com.exceptions.HotelNotRegisteredException;
import com.hotel.Hotel;
import com.database.HotelDatabase;

/**
 * findHotel service find the hotel in the registered hotel in the app if find hotel then
 * return the reference to the hotel object other wise it throws exception
 */
public class FindHotel {

    private int hotelId;

    public FindHotel(int hotelId)  {
        this.hotelId = hotelId;
    }

    public Hotel findHotel() {
        try {
            return HotelDatabase.search(this.hotelId);
        }
        catch (HotelNotRegisteredException e) {
            System.out.println(e);
        }
        return null;
        }


}
