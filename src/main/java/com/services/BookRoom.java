package com.services;

import com.database.RoomsDatabase;
import com.exceptions.HotelIdNotExistException;
import com.exceptions.HotelNotRegisteredException;
import com.hotel.HotelInterface;
import com.room.OneSeaterRoom;
import com.room.RoomInterface;
import com.room.TwoSeaterRoom;

public class BookRoom {

    private int hotelId;
    private int seater;
    private FindHotel findHotel;
    private RoomInterface room;

    public BookRoom(int hotelId , int seater) {
        this.hotelId = hotelId;
        this.seater = seater;
        this.findHotel = null;
        this.room = null;
    }

    public Boolean bookRoom() {
        findHotel = new FindHotel(hotelId);
        HotelInterface hotel = findHotel.findHotel();
        if(hotel != null) {
            room = null;
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
                try {
                    RoomsDatabase.addRoom(room);
                    return true;
                }
                catch(HotelIdNotExistException e) {
                    System.out.println(e);
                }
            }
        }
        else {
            System.out.println("there is no hotel present");
        }
        return false;
    }
}
