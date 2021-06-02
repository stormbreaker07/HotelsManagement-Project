package hotelsManager;

import hotel.Hotel;
import hotel.HotelInterface;

public interface HotelsManagerInterface {

    public int registerHotel(String hotelName , String location, int star , int totalRooms);
    public void removeHotel(int hash);
    public Hotel getMyHotel(int hotelName);
    public void updateHotel(int preHotelId , HotelInterface newHotel);
    public void allHotel();

}
