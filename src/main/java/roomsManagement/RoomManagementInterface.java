package roomsManagement;


import room.RoomInterface;

import java.util.ArrayList;

//this interface will use to track the total rooms
//rooms avilable .
//rooms booked list
//book a room
//delete a room
public interface RoomManagementInterface {

    public void totalRooms(int totalRooms);
    public int avialbleRooms(String hotelId);
    public void bookARoom(String hotelId , int seater);
    public void removeRoom(String hotelId , int seater);


}
