package com.room;


public class OneSeaterRoom extends GeneralRoom {

    private int hotelId;
    public static final int seater = 1;
    private String description ;



    @Override
    public void hotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int getHotelId() {
        return this.hotelId;
    }

    @Override
    public void roomDescription() {
        System.out.println("its a single seater room with one bedroom and attach bathroom");
    }

    @Override
    public void roomService() {
        //by comnbining builder and abstract factory design pattern
        System.out.println("you can call for room service from here");
    }



    @Override
    public void numberOfPeopleStaying() {
        System.out.println("number of people staying in that room");
    }

    @Override
    public void food() {
        //can be designed by combining builder and template design pattern
        System.out.println("call for food service from here");
    }

    @Override
    public int seater() {
        return this.seater;
    }
}
