package services;

import Database.HotelDatabase;

public class RemoveHotel {

    private String hash;

    public RemoveHotel(String hash) {
        this.hash = hash;

    }

    public void removeHotel() {
        HotelDatabase.removeData(hash);
    }

}
