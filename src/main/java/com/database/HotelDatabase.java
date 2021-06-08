package com.database;

import com.exceptions.HotelAlreadyRegisteredException;
import com.exceptions.HotelIdNotExistException;
import com.exceptions.HotelNotRegisteredException;
import com.hotel.Hotel;
import com.hotel.HotelInterface;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * singleton design pattern used to store hotel data or say hotel object
 */
public class HotelDatabase implements Serializable {

    private static int id;
    private static Map<Integer , HotelInterface> data = null;
    private static HotelDatabase instance;
    /**
     * private constructor so it cant be initialized from anywhere
     */
    private HotelDatabase() {
        initiateDatabase();
    }

    /**
     * call private constructor use to get class object instance
     * @return object of HotelDatabase
     */
    public static HotelDatabase getInstance() {
        if(instance == null) {
            instance = new HotelDatabase();
        }
        return instance;

    }


    /**
     * one time initialization of database
     */
    public static void initiateDatabase() {
        if(data == null) {
            data = new HashMap<>();
            id = 1;
        }
    }

    public static void initiateDatabase(Map<Integer , HotelInterface> newData) {
        data = newData;
    }

    /**
     * use to store the object of newly registered hotel
     * @param newHotel
     * @return the hotel id of newly added hotel
     * @throws HotelAlreadyRegisteredException
     */
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


    /**
     *remoce a hotel from the database
     * @param id
     */
    public static void removeData(int id) {
        data.remove(id);
    }


    /**
     * use to update the data of a hotel if some change occurs
     * @param id
     * @param newHotel
     */
    public static void updateData(int id ,HotelInterface newHotel) {
        data.put(id , newHotel);
    }

    public static void updateId() {
        id = data.size()+1;
    }
    /**
     * search for a hotel using the hotel id
     * @param id
     * @return hotel object if exist else throw exception
     * @throws HotelNotRegisteredException
     */
    public static Hotel search(int id) throws HotelNotRegisteredException {

        Hotel hotel = (Hotel) data.get(id);
        if(hotel != null) {
            return hotel;
        }
        else {
            throw new HotelNotRegisteredException("hotel doesnt exist in database");
        }
    }


    /**
     * return the whole database object
     * @return
     */
    public static Map<Integer , HotelInterface> wholeData() {

        return data;
    }

    /**
     * decrease the total number of available rooms by one
     * available room describe how many rooms can be booked
     * @param hotelId
     * @throws HotelNotRegisteredException
     */
    public static void decreaseAvailableRooms(int hotelId) throws HotelIdNotExistException {
        try {
            HotelInterface hotel = search(hotelId);
            hotel.setEmptyRooms(hotel.getEmptyRooms() - 1);
        }catch(HotelNotRegisteredException e) {
            throw new HotelIdNotExistException("check the hotel id again , no hotel with this id exist");
        }
    }

    /**
     *  increase the total number of available rooms by one
     * available room describe how many rooms can be booked
     * @param hotelId
     * @throws HotelNotRegisteredException
     */
    public static void increaseAvailableRooms(int hotelId) throws HotelIdNotExistException {

        try {
            HotelInterface hotel = search(hotelId);
            hotel.setEmptyRooms(hotel.getEmptyRooms() + 1);
        }
        catch(HotelNotRegisteredException e) {
            throw new HotelIdNotExistException("check the hotel id again , no hotel with this id exist");
        }
    }

    public static void deleteWholeDatbase() {
        data.clear();
    }
}
