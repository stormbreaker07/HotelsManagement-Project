package com.room;

public class TwoSeaterRoom extends GeneralRoom {

    public static final int seater = 2;

    @Override
    public void roomDescription() {
        System.out.println("its a two seater room with attachBathrooms ");
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

    public int seater() {
        return this.seater;
    }

}
