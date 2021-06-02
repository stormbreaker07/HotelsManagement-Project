package services;

import hotel.Hotel;
import database.HotelDatabase;

public class FindHotel {

    private int hotelId;

    public FindHotel(int hotelId)  {
        this.hotelId = hotelId;
    }

    public Hotel findHotel() {
        return HotelDatabase.search(this.hotelId);
    }


}
