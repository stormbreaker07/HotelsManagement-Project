package Database;

import hotel.Hotel;
import hotel.HotelInterface;
import room.RoomInterface;

import java.util.*;

public class EmptyRooms {

    private EmptyRooms() {}

    private static Map<String, Integer> rooms = null;

    public static void initialize() {
        if(rooms == null) {
            rooms = new HashMap<>();
        }
    }

    public static void initializeRoom(String hotelId , int totalRooms) {
        System.out.println(totalRooms + " " + hotelId);
        rooms.put(hotelId , totalRooms);
    }

    public static Integer emptyRoom(String hotelId) {

        for(Map.Entry<String , Integer> s : rooms.entrySet()) {
            System.out.println(s.getValue());
        }
        Integer result = rooms.get(hotelId);
        System.out.println(result);
        return result;
    }

    public static void decreaseEmptyRoom(String hotelId) {
        Integer emptyRoom = rooms.get(hotelId);
        emptyRoom--;
        rooms.put(hotelId , emptyRoom);
    }

    public static void increaseRoom(String hotelId) {
        Integer emptyRoom = rooms.get(hotelId);
        emptyRoom++;
        rooms.put(hotelId , emptyRoom);
    }

}
