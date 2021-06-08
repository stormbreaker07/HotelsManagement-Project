package com.hotelsManager;


import com.database.HotelDatabase;
import com.hotel.Hotel;
import com.hotel.HotelInterface;
import com.services.AddHotel;
import com.services.FindHotel;
import com.services.RemoveHotel;
import com.services.UpdateHotel;

import java.util.Map;

/**
 * hotelsmanager class handles all operation related to hotels management
 * like register a hotel,
 * update data of a hotel
 * delete the hotel from database of app
 * search for a hotel
 */
public class HotelsManager implements HotelsManagerInterface {

    private Hotel hotel;
    private AddHotel addHotel;
    private RemoveHotel removeHotel;
    private FindHotel findHotel;

    public HotelsManager() {
        hotel = null;
        addHotel = null;
        removeHotel = null;
        findHotel = null;
    }


    /**
     * resitering the hotel means storing the Hotel object in the database(HotelDatabase file)
     * @param hotelName
     * @param location
     * @param star
     * @param totalRooms
     * @param oneSeaterRoomCost
     * @param twoSeaterRoomCost
     * @return (hotel_Id)
     */
    @Override
    public int registerHotel(String hotelName , String location, int star , int totalRooms , int oneSeaterRoomCost , int twoSeaterRoomCost) {
        hotel = new Hotel(hotelName , location , star , totalRooms , oneSeaterRoomCost , twoSeaterRoomCost);
        addHotel = new AddHotel(hotel);
        int hotelId = addHotel.add();

        //EmptyRooms.initializeRoom(result , totalRooms);
        return hotelId;
    }

    /**
     * remove a hotel data from the database or say unregister a hotel from the app
     * @param hotelId
     */
    @Override
    public void removeHotel(int hotelId) {
        removeHotel = new RemoveHotel(hotelId);
        removeHotel.removeHotel();

    }

    /**
     * it prints all the hotel present in the app with a short description with it
     */
    public void allHotel() {
        Map<Integer , HotelInterface> allHotels = HotelDatabase.wholeData();
        if(allHotels.size() == 0) {
            System.out.println("no hotel is registered till now");
            return ;}
        for(Map.Entry<Integer , HotelInterface> eachHotel : allHotels.entrySet()) {
            System.out.println( "{ hotel ID : "  +eachHotel.getKey() + " , hotelName : " + eachHotel.getValue().getName() + " }" );
        }
    }


    /**
     * return the hotel object reference with respect to the given hotelId
     * @param hotelId
     * @return hotel object reference
     */
    @Override
    public Hotel getMyHotel(int hotelId) {
        findHotel = new FindHotel(hotelId);
        return findHotel.findHotel();
    }


    /**
     * update the fields of the hotel.
     * if the updated field is empty then no change take place in the hotel object field but if parameter have
     * non empty value then its data will be updated in the hotel object.
     * @param preHotelId
     * @param hotelName
     * @param hotelLocation
     * @param rating
     * @param totalRooms
     * @param oneSeaterRoomCost
     * @param twoSeaterRoomCost
     */
    @Override
    public void updateHotel(int preHotelId ,String hotelName, String hotelLocation,String rating
            ,String totalRooms,String oneSeaterRoomCost,String twoSeaterRoomCost) {
        findHotel = new FindHotel(preHotelId);
            hotel = findHotel.findHotel();
        if(!hotelName.equals("")) {
            hotel.setHotelName(hotelName);
        }

        if(!hotelLocation.equals("")) {
            hotel.setLocation(hotelLocation);
        }

        if(!rating.equals("")) {
            hotel.setRating(Integer.parseInt(rating));
        }

        if(!totalRooms.equals("")) {
            int allRooms = hotel.getTotalRooms();
            hotel.setTotalRooms(Integer.parseInt(totalRooms));
            //change available rooms
            int availableRooms = hotel.getEmptyRooms();
            int bookedRooms = allRooms - availableRooms;
            hotel.setEmptyRooms(Integer.parseInt(totalRooms)-bookedRooms);
        }

        if(!oneSeaterRoomCost.equals("")) {
            hotel.setOneSeaterRoomPrice(Integer.parseInt(oneSeaterRoomCost));
        }

        if(!twoSeaterRoomCost.equals("")) {
            hotel.setTwoSeaterRoomPrice(Integer.parseInt(twoSeaterRoomCost));
        }

        UpdateHotel updateHotel = new UpdateHotel(preHotelId , hotel);
        updateHotel.updateHotel();
    }
}
