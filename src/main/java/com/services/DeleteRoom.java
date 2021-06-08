package com.services;

import com.database.RoomsDatabase;
import com.exceptions.HotelIdNotExistException;
import com.exceptions.NoSuchRoomBookedException;

public class DeleteRoom {

    private int seater;
    private int hotelId;

    public DeleteRoom(int hotelId , int seater) {
        this.hotelId = hotelId;
        this.seater = seater;
    }

    public Boolean deleteRoom() {

        try {
        return RoomsDatabase.deleteRoom(hotelId, seater);
        }
        catch(NoSuchRoomBookedException e) {
            System.out.println(e);
        }
        return false;
    }


}