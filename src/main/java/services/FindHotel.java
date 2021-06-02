package services;

import hotel.Hotel;
import Database.HotelDatabase;

public class FindHotel {

    private String hotelId;

    public FindHotel(String hotelId)  {
        this.hotelId = hotelId;
    }

    public Hotel findHotel() {
        return HotelDatabase.search(this.hotelId);
    }


}
