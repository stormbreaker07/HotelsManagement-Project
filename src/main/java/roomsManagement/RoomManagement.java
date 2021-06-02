package roomsManagement;

import Database.EmptyRooms;
import services.BookRoom;
import services.DeleteRoom;

import java.util.ArrayList;

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
    public int avialbleRooms(String hotelId)
    {

        return  EmptyRooms.emptyRoom(hotelId);
    }


    @Override
    public void bookARoom(String hotelId , int seater ) {
        if(EmptyRooms.emptyRoom(hotelId) > 0) {
            BookRoom bookRoom = new BookRoom(hotelId, seater);
            Boolean temp = bookRoom.bookRoom();
            if (temp == true) {
                EmptyRooms.decreaseEmptyRoom(hotelId);
                System.out.println("Room booked");
            }
        }
        else {
            System.out.println("NO rooms avilable in this hotel");
        }
    }

    @Override
    public void removeRoom(String hotelId , int seater) {
        DeleteRoom deleteRoom = new DeleteRoom(hotelId , seater );
        Boolean result = deleteRoom.deleteRoom();
        if(result) {
            EmptyRooms.increaseRoom(hotelId);
            System.out.println("the customer is checked out the room");
        }
        else {
            System.out.println("no room of that specific is avilable to be checked out");
        }
    }
}
