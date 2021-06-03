package com.roomsManagement;


//this interface will use to track the total rooms
//rooms avilable .
//rooms booked list
//book a room
//delete a room
public interface RoomManagementInterface {

    public void bookARoom(int hotelId , int seater);
    public void removeRoom(int hotelId , int seater);



}
