package com.database;

import com.customer.Customer;
import com.exceptions.HotelIdNotExistException;
import com.exceptions.HotelNotRegisteredException;
import com.exceptions.NoSuchRoomBookedException;
import com.hotel.HotelInterface;
import com.room.RoomInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *singleton design pattern
 *  added comments
 */
public class RoomsDatabase implements Serializable {

    /**
     *map store key value
     */
    private static int id;
    private static Map<Integer , RoomInterface> roomsData= null;
    private static RoomsDatabase instance = null;

    /**
     * create private constructor so no object can be created
     */
    private RoomsDatabase() {
        initiate();
    }


    public static RoomsDatabase getInstance() {
        if(instance == null) {
            instance = new RoomsDatabase();
        }
        return instance;
    }


    public static void initiateDatabase(Map<Integer , RoomInterface> newData) {
        roomsData = newData;
    }

    /**
     * one time HashMap initialization
     */
    public static void initiate() {
        if(roomsData == null) {
            roomsData = new HashMap<>();
            id = 1;
        }
    }

    public static void updateId() {
        id = roomsData.size()+1;
    }

    /**
     * add room in the database
     * @param room
     */
    public static void addRoom(RoomInterface room) throws HotelIdNotExistException {

        roomsData.put( id,room);
        int hotelId = room.getHotelId();
            HotelDatabase.decreaseAvailableRooms(hotelId);
            id++;
    }


    /**
     * remove the room from database
     * Boolean return type
     */
    public static Boolean deleteRoom(int hotelId , int seater) throws NoSuchRoomBookedException {

        try {
            for (Map.Entry<Integer, RoomInterface> room : roomsData.entrySet()) {
                if (room.getValue().seater() == seater && room.getValue().getHotelId() == hotelId) {
                    roomsData.remove(room.getKey());
                    HotelDatabase.increaseAvailableRooms(hotelId);
                    return true;
                }
            }
            }catch(HotelIdNotExistException e) {
            throw new NoSuchRoomBookedException("check your room credentials and then try again");
        }
        return false;
    }

    public static Map<Integer , RoomInterface> wholeData() {

        return roomsData;
    }

}
