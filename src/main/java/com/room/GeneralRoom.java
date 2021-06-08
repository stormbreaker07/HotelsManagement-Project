package com.room;

import java.io.Serializable;

public class GeneralRoom implements RoomInterface {

    protected int hotelId;

    @Override
    public void hotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int getHotelId() {
        return this.hotelId;
    }

    @Override
    public void roomDescription() { }

    @Override
    public void roomService() { }

    @Override
    public void numberOfPeopleStaying() { }

    @Override
    public void food() { }

    @Override
    public int seater() {
        return 0;
    }
}
