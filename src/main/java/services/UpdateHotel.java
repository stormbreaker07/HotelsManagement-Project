package services;

import hotel.HotelInterface;
import Database.HotelDatabase;

public class UpdateHotel {

    private  String preHotelId;
    private HotelInterface hotel;

    public UpdateHotel(String preHotelId , HotelInterface hotel)  {
        this.preHotelId = preHotelId;
        this.hotel = hotel;
    }

    public String updateHotel() {
        String hash = String.valueOf(hotel.hashCode());
        HotelDatabase.updateData(preHotelId , hash , hotel);
        return hash;
    }
}
