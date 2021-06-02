package com.database;

import com.exceptions.HotelAlreadyRegisteredException;
import com.hotel.Hotel;
import com.hotel.HotelInterface;

import java.util.HashMap;
import java.util.Map;

public class HotelDatabase {

    private static int id;
    private static Map<Integer , HotelInterface> data = null;

    private HotelDatabase() {}


    public static void initiateDatabase() {
        if(data == null) {
            data = new HashMap<>();
            id = 1;
        }
    }


    public static int addData(HotelInterface newHotel) throws HotelAlreadyRegisteredException {
        Hotel hotel = (Hotel) data.put(id, newHotel);
        if(hotel == null) {
            int curId = id;
            id++;
            return curId;
        }
        else {
            throw new HotelAlreadyRegisteredException("Hotel is already registered in the App");
        }

    }


    public static void removeData(int id) {
        data.remove(id);
    }


    public static void updateData(int id ,HotelInterface newHotel) {
        data.put(id , newHotel);
    }

    public static Hotel search(int id) {
        return  (Hotel) data.get(id);
    }



    public static Map<Integer , HotelInterface> wholeData() {

        return data;
    }

    public static void decreaseAvailableRooms(int hotelId) {
        HotelInterface hotel = search(hotelId);
        hotel.setEmptyRooms(hotel.getEmptyRooms()-1);
    }

    public static void increaseAvailableRooms(int hotelId) {
        HotelInterface hotel = search(hotelId);
        hotel.setEmptyRooms(hotel.getEmptyRooms()+1);
    }

}
