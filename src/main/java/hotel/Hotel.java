package hotel;

public class Hotel implements HotelInterface{


    private int rating;
    private int allRooms;
    private String name;
    private String location;
    private int avialbleRooms;
    private double oneSeaterRoomCost = 1000;
    private double twoSeaterRoomCost = 2000;


    //constructor
    public Hotel(String name , String location , int rating , int totalRooms) {
        hotelName(name);
        location(location);
        rating(rating);
        totalRooms(totalRooms);
    }

    @Override
    public void hotelName(String name) {
        this.name = name;
    }

    @Override
    public void location(String location) {
        this.location = location;
    }

    @Override
    public void rating(int rating) {
        this.rating = rating;
    }

    @Override
    public void totalRooms(int rooms) {
        this.allRooms = rooms;
    }


    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public int getAllRooms() {
        return allRooms;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public int getAvialbleRooms() {
        return avialbleRooms;
    }




}









//new rooms are created there
//    @Override
//    public void BookRooms(int seaterRoom) {
//
//        //using command design pattern to add or remove a room from the arraylist of rooms
//        Command command = new AddRoom(rooms , avialbleRooms , seaterRoom);
//        avialbleRooms = command.execute();
//
//    }
