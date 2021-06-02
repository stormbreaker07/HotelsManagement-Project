package com.database;

import com.room.RoomInterface;

import java.util.HashMap;
import java.util.Map;


//singleton design pattern
// added comments
public class RoomsDatabase {

    //create private constructor so no object can be created
    private RoomsDatabase() {}

    //map store key value
    private static int id;
    private static Map<Integer , RoomInterface> roomsData= null;

    //one time object initialization
    public static void initiate() {
        if(roomsData == null) {
            roomsData = new HashMap<>();
            id = 1;
        }
    }


    //add room in the database
    public static void addRoom(RoomInterface room) {

        roomsData.put( id,room);
        int hotelId = room.getHotelId();
        HotelDatabase.decreaseAvailableRooms(hotelId);

    }


    //remove the room from database
    public static Boolean deleteRoom(int hotelId , int seater) {

        for( Map.Entry<Integer , RoomInterface> room : roomsData.entrySet()) {
            if(room.getValue().seater()==seater && room.getValue().getHotelId() == hotelId ) {
                roomsData.remove(room.getKey());
                return true;
            }
        }
        return false;
    }


}
