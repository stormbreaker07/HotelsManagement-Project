package com.services;

import com.hotel.HotelInterface;
import com.database.HotelDatabase;

public class UpdateHotel {

    private  int preHotelId;
    private HotelInterface hotel;

    public UpdateHotel(int preHotelId , HotelInterface hotel)  {
        this.preHotelId = preHotelId;
        this.hotel = hotel;
    }

    public void  updateHotel() {
        HotelDatabase.updateData(preHotelId ,hotel);
        return ;
    }
}
