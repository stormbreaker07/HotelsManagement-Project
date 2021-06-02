package hotel;

/**
 *hotel class create a hotel object ,
 * a hotel object get hotelname , location , rating and totalrooms
 * it tracks the available rooms in the current hotel object
 * hotel prices are there
 */

public class Hotel implements HotelInterface{


    private int rating;
    private int totalRooms;
    private String hotelName;
    private String location;
    private int emptyRooms;
    private double oneSeaterRoomCost = 1000;
    private double twoSeaterRoomCost = 2000;


    //constructor
    public Hotel(String name , String location , int rating , int totalRooms) {
        this.hotelName = name;
        this.location = location;
        this.rating = rating;
        this.totalRooms = totalRooms;
        emptyRooms = totalRooms;
    }

    /**
     * set name of the hotel
     * @param name
     */
    @Override
    public void setHotelName(String name) {
        this.hotelName = name;
    }


    /**
     * setter for empty rooms as when a room is booked then it should be updated accordingly
     * @param rooms
     */
    @Override
    public void setEmptyRooms(int rooms) {
        this.emptyRooms = rooms;
    }


    /**
     * set the location of the hotel
     * @param location
     */
    @Override
    public void setLocation(String location) {
        this.location = location;
    }


    /**
     * set the rating of hoek
     * @param rating
     */
    @Override
    public void setRating(int rating) {
        this.rating = rating;
    }


    /**
     * set the total number of rooms hotel have
     * @param rooms
     */
    @Override
    public void setTotalRooms(int rooms) {
        this.totalRooms = rooms;
    }


    /**
     * return the rating of the hotel
     * @return
     */
    @Override
    public int getRating() {
        return this.rating;
    }

    /**
     * get the total number exist in a hotel
     * @return
     */
    @Override
    public int getTotalRooms() {
        return this.totalRooms;
    }

    /**
     * get the name of the hotel
     * @return
     */
    @Override
    public String getName() {
        return this.hotelName;
    }


    /**
     * get the location of the hotel
     * @return
     */
    @Override
    public String getLocation() {
        return this.location;
    }


    /**
     * return number of empty rooms present in a particular hotel
     * @return
     */
    @Override
    public int getEmptyRooms() {
        return this.emptyRooms;
    }

}
