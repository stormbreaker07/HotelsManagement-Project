package services;

import database.HotelDatabase;

public class RemoveHotel {

    private int id;

    public RemoveHotel(int id) {
        this.id = id;

    }

    public void removeHotel() {
        HotelDatabase.removeData(id);
    }

}
