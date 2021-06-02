package services;

import database.RoomsDatabase;

public class DeleteRoom {

    private int seater;
    private int hotelId;

    public DeleteRoom(int hotelId , int seater) {
        this.hotelId = hotelId;
        this.seater = seater;
    }

    public Boolean deleteRoom() {

        return RoomsDatabase.deleteRoom(hotelId , seater);

    }


}