package hotelsManager;

import hotel.Hotel;
import hotel.HotelInterface;

public interface HotelsManagerInterface {

    public String registerHotel(String hotelName , String location, int star , int totalRooms);
    public void removeHotel(String hash);
    public Hotel getMyHotel(String hotelName);
    public String updateHotel(String preHotelId , HotelInterface newHotel);
    public void allHotel();

}
