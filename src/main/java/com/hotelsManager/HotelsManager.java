package com.hotelsManager;


import com.database.HotelDatabase;
import com.hotel.Hotel;
import com.hotel.HotelInterface;
import com.services.AddHotel;
import com.services.FindHotel;
import com.services.RemoveHotel;
import com.services.UpdateHotel;

import java.util.Map;

//it mainly create hotel from the data extracted from the database about the hotel
public class HotelsManager implements HotelsManagerInterface {



    @Override
    public int registerHotel(String hotelName , String location, int star , int totalRooms , int oneSeaterRoomCost , int twoSeaterRoomCost) {
        Hotel hotel = new Hotel(hotelName , location , star , totalRooms , oneSeaterRoomCost , twoSeaterRoomCost);
        AddHotel addHotel = new AddHotel(hotel);
        int hotelId = addHotel.add();

        //EmptyRooms.initializeRoom(result , totalRooms);
        return hotelId;
    }

    @Override
    public void removeHotel(int hotelId) {
        RemoveHotel removeHotel = new RemoveHotel(hotelId);
        removeHotel.removeHotel();

    }

    public void allHotel() {
        Map<Integer , HotelInterface> allHotels = HotelDatabase.wholeData();
        if(allHotels.size() == 0) {
            System.out.println("no hotel is registered till now");
            return ;}
        for(Map.Entry<Integer , HotelInterface> eachHotel : allHotels.entrySet()) {
            System.out.println( "{ hotel ID : "  +eachHotel.getKey() + " , hotelName : " + eachHotel.getValue().getName() + " }" );
        }
    }

    @Override
    public Hotel getMyHotel(int hotelId) {
        FindHotel findHotel = new FindHotel(hotelId);
        return findHotel.findHotel();
    }

    @Override
    public void updateHotel(int preHotelId , HotelInterface newHotel) {
        UpdateHotel updateHotel = new UpdateHotel(preHotelId , newHotel);
        updateHotel.updateHotel();
    }
}
