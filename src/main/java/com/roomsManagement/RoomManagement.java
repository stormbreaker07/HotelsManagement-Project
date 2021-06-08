package com.roomsManagement;

import com.services.BookRoom;
import com.services.DeleteRoom;

public class RoomManagement implements RoomManagementInterface{

    private BookRoom bookRoom;
    DeleteRoom deleteRoom;

    public RoomManagement() {
        this.bookRoom = null;
        this.deleteRoom = null;
    }


    @Override
    public void bookARoom(int hotelId , int seater ) {
            bookRoom = new BookRoom(hotelId, seater);
            Boolean result = bookRoom.bookRoom();
            if (result == true) {
                //EmptyRooms.decreaseEmptyRoom(hotelId);
                System.out.println("Room booked");
            }
            else {
            System.out.println("NO rooms avilable in this hotel");
        }
    }

    @Override
    public void removeRoom(int hotelId , int seater) {
        deleteRoom = new DeleteRoom(hotelId , seater );
        Boolean result = deleteRoom.deleteRoom();
        if(result) {
            //EmptyRooms.increaseRoom(hotelId);
            System.out.println("the customer is checked out the room");
        }
        else {
            System.out.println("no room of that specific is avilable to be checked out");
        }
    }
}
