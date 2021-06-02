package services;

import exceptions.HotelAlreadyRegisteredException;
import exceptions.HotelNotRegisteredException;
import hotel.Hotel;
import hotel.HotelInterface;
import database.HotelDatabase;

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
