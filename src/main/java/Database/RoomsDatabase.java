package Database;

import room.RoomInterface;

import java.util.HashMap;
import java.util.Map;


//singleton design pattern
public class RoomsDatabase {

    //create private constructor so no object can be created
    private RoomsDatabase() {}

    //map store key value
    private static Map<String , RoomInterface> roomsData= null;

    //one time object initialization
    public static void initiate() {
        if(roomsData == null) {
            roomsData = new HashMap<>();
        }
    }


    //add room in the database
    public static void addRoom(RoomInterface room) {
        roomsData.put( String.valueOf(room.hashCode()) , room );
    }


    //remove the room from database
    public static Boolean deleteRoom(String hotelId , int seater) {

        for( Map.Entry<String , RoomInterface> room : roomsData.entrySet()) {
            if(room.getValue().seater()==seater && room.getValue().getHotelId().equals(hotelId) ) {
                roomsData.remove(room.getKey());
                return true;
            }
        }
        return false;
    }


}
