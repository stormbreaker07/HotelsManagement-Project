package hotelsManager;


import Database.EmptyRooms;
import Database.HotelDatabase;
import hotel.Hotel;
import hotel.HotelInterface;
import services.AddHotel;
import services.FindHotel;
import services.RemoveHotel;
import services.UpdateHotel;

import java.util.Map;
import java.util.UUID;

import static Database.HotelDatabase.wholeData;

//it mainly create hotel from the data extracted from the database about the hotel
public class HotelsManager implements HotelsManagerInterface{



    @Override
    public String registerHotel(String hotelName , String location, int star , int totalRooms) {
        AddHotel addHotel = new AddHotel(hotelName , location , star , totalRooms);
        String result = addHotel.add();
        EmptyRooms.initializeRoom(result , totalRooms);
        return result;
    }

    @Override
    public void removeHotel(String hotelId) {
        RemoveHotel removeHotel = new RemoveHotel(hotelId);
        removeHotel.removeHotel();

    }

    public void allHotel() {
        Map<String , HotelInterface> allHotels = HotelDatabase.wholeData();
        if(allHotels.size() == 0) {
            System.out.println("no hotel is registered till now");
            return ;}
        for(Map.Entry<String , HotelInterface> eachHotel : allHotels.entrySet()) {
            System.out.println( "{ hotel ID : "  +eachHotel.getKey() + " , hotelName : " + eachHotel.getValue().getName() + " }" );
        }
    }

    @Override
    public Hotel getMyHotel(String hotelId) {
        UUID.randomUUID();
        FindHotel findHotel = new FindHotel(hotelId);
        return findHotel.findHotel();
    }


    public String updateHotel(String preHotelId , HotelInterface newHotel) {
        UpdateHotel updateHotel = new UpdateHotel(preHotelId , newHotel);
        return updateHotel.updateHotel();
    }
}
