package com.roomsManagement;

import com.services.BookRoom;
import com.services.DeleteRoom;

public class RoomManagement implements RoomManagementInterface{

    private String hotelId = null;
    private int totalRoom;
    private int seaterRoom;

    public RoomManagement(String hotelId , int seaterRooms) {
        this.hotelId = hotelId;
        this.seaterRoom = seaterRooms;
    }


    @Override
    public void totalRooms(int totalRoom) {
        this.totalRoom = totalRoom;
    }



    @Override
    public int avialbleRooms(int hotelId)
    {

        return  0;//EmptyRooms.emptyRoom(hotelId);
    }


    @Override
    public void bookARoom(int hotelId , int seater ) {
            BookRoom bookRoom = new BookRoom(hotelId, seater);
            Boolean temp = bookRoom.bookRoom();
            if (temp == true) {
                //EmptyRooms.decreaseEmptyRoom(hotelId);
                System.out.println("Room booked");
            }
            else {
            System.out.println("NO rooms avilable in this hotel");
        }
    }

    @Override
    public void removeRoom(int hotelId , int seater) {
        DeleteRoom deleteRoom = new DeleteRoom(hotelId , seater );
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
