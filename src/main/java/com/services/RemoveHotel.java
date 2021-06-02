package com.services;

import com.database.HotelDatabase;

public class RemoveHotel {

    private int id;

    public RemoveHotel(int id) {
        this.id = id;

    }

    public void removeHotel() {
        HotelDatabase.removeData(id);
    }

}
