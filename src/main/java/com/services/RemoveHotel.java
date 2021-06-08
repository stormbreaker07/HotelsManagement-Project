package com.services;

import com.database.HotelDatabase;


/**
 * RemoveHotel unregister the hotel in hotel Database
 */
public class RemoveHotel {

    private int id;

    public RemoveHotel(int id) {
        this.id = id;

    }

    public void removeHotel() {
        HotelDatabase.removeData(id);
    }

}
