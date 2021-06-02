package services;

import hotel.Hotel;
import hotel.HotelInterface;
import Database.HotelDatabase;

public class AddHotel{

    HotelInterface newHotel = null;

    public AddHotel(String hotelName , String location , int rating, int totalRooms ) {
        newHotel = new Hotel(hotelName , location , rating , totalRooms);
    }

   public String add() {
        String hash = String.valueOf(newHotel.hashCode());
        HotelDatabase.addData(hash , newHotel);
        return hash;
   }
}
