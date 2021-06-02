package hotel;

public interface HotelInterface {

    public void setHotelName(String name);
    public  void setLocation(String location);
    public  void setRating(int rating);
    public void setTotalRooms(int rooms);
    public void setEmptyRooms(int rooms);
    public int getRating();
    public int getTotalRooms();
    public String getName();
    public String getLocation();
    public int getEmptyRooms();
}
