package services;

import Database.RoomsDatabase;
import hotel.HotelInterface;
import room.OneSeaterRoom;
import room.RoomInterface;
import room.TwoSeaterRoom;

public class BookRoom {

    private String hotelId;
    private int seater;

    public BookRoom(String hotelId , int seater) {
        this.hotelId = hotelId;
        this.seater = seater;
    }

    public Boolean bookRoom() {
        FindHotel findHotel = new FindHotel(hotelId);
        HotelInterface hotel = findHotel.findHotel();
        if(hotel != null) {
            RoomInterface room = null;
            if(seater == 1) {
                room = new OneSeaterRoom();
                room.hotelId(hotelId);
            }
            else if(seater == 2) {
                room = new TwoSeaterRoom();
                room.hotelId(hotelId);

            }
            else {
                System.out.println("not more than two seater room avilable");
            }
            //finally adding the room in database
            if(room!=null) {
                RoomsDatabase.addRoom(room);
                return true;
            }
        }
        else {
            System.out.println("there is no hotel present");
        }
        return false;
    }
}
