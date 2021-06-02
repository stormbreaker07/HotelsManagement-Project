package services;

import Database.RoomsDatabase;

public class DeleteRoom {

    private int seater;
    private String hotelId;

    public DeleteRoom(String hotelId , int seater) {
        this.hotelId = hotelId;
        this.seater = seater;
    }

    public Boolean deleteRoom() {

        return RoomsDatabase.deleteRoom(hotelId , seater);

    }


}