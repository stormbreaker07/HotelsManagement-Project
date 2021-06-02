package Database;

import hotel.Hotel;
import hotel.HotelInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelDatabase {

    private static Map<String , HotelInterface> data = null;

    private HotelDatabase() {}


    public static void initiateDatabase() {
        if(data == null) {
            data = new HashMap<>();
        }
    }


    public static void addData(String hash , HotelInterface newHotel) {
        data.put(hash , newHotel);
    }


    public static void removeData(String hash) {
        data.remove(hash);
    }


    public static void updateData(String preHash ,String newHash ,  HotelInterface newHotel) {
        data.remove(preHash);
        data.put(newHash , newHotel);
    }

    public static Hotel search(String hash) {
        return  (Hotel) data.get(hash);
    }



    public static Map<String , HotelInterface> wholeData() {

        return data;
    }

}
