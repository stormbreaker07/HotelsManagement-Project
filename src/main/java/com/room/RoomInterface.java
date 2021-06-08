package com.room;


import java.io.Serializable;

public interface RoomInterface extends Serializable {

    public void hotelId(int hotelId);
    public int getHotelId();
    public void roomDescription();
    public void roomService();
    public void numberOfPeopleStaying();
    public void food();
    public int seater();

}
