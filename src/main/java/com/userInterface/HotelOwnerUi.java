package com.userInterface;


import com.hotelsManager.HotelsManager;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class HotelOwnerUi {

    private Scanner scan;
    private HotelsManager hotelsManager;

    public HotelOwnerUi(Scanner scan) {
        hotelsManager = new HotelsManager();
        this.scan = scan;
        UiHandler();

    }

    public void UiHandler() {
        String oper = "";

                while (!oper.equals("-1")) {
                    System.out.println("type 0 for register a hotel");
                    System.out.println("type 1 for updating hotel");
                    System.out.println("type 2 for unregister the hotel");
                    System.out.println("type 3 for search a hotel");
                    System.out.println("type -1 for exiting ");

                    oper = scan.nextLine();

                    if(oper.equals("0")) {
                        registerHotel();
                    }
                    else if(oper.equals("1")) {
                        updateHotel();
                    }
                    else if(oper.equals("2")) {
                        unregisterHotel();
                    }
                    else if(oper.equals("3")) {
                        searchHotel();
                    }
                    else if(oper.equals("-1")) {
                        System.out.println("Exiting from the Page ...");
                        break;
                    }
                    else {
                        System.out.println("invalid input try again");
                    }
                }
    }

    public void registerHotel() {
                        System.out.print("Type hotel Name : ");
                        String hotelName = scan.nextLine();
                        System.out.print("Type hotel location : ");
                        String hotelLocation = scan.nextLine();
                        System.out.print("Type hotel Rating : ");
                        String rating = scan.nextLine();
                        System.out.print("Type hotel totalRooms : ");
                        String totalRooms = scan.nextLine();
                        System.out.print("cost of oneSeaterRoom : ");
                        String oneSeaterRoomCost = scan.nextLine();
                        System.out.print("cost of twoSeateRoom : ");
                        String twoSeaterRoomCost = scan.nextLine();

                        int hotelId = hotelsManager.registerHotel(hotelName , hotelLocation , Integer.parseInt(rating) ,
                                Integer.parseInt(totalRooms) , Integer.parseInt(oneSeaterRoomCost) ,
                                Integer.parseInt(twoSeaterRoomCost) );
                        System.out.println("the hotel id is :" + hotelId);
    }

    public void updateHotel() {
        System.out.print("type the hotelId : ");
                        String hotelId = scan.nextLine();
        System.out.println(hotelsManager.getMyHotel(Integer.parseInt(hotelId)));

        System.out.print("Type hotel Name : ");
        String hotelName = scan.nextLine();
        System.out.print("Type hotel location : ");
        String hotelLocation = scan.nextLine();
        System.out.print("Type hotel Rating : ");
        String rating = scan.nextLine();
        System.out.print("Type hotel totalRooms : ");
        String totalRooms = scan.nextLine();
        System.out.print("cost of oneSeaterRoom : ");
        String oneSeaterRoomCost = scan.nextLine();
        System.out.print("cost of twoSeateRoom : ");
        String twoSeaterRoomCost = scan.nextLine();

        hotelsManager.updateHotel(Integer.parseInt(hotelId), hotelName , hotelLocation ,rating , totalRooms , oneSeaterRoomCost , twoSeaterRoomCost );
        System.out.println("updated data");
        System.out.println(hotelsManager.getMyHotel(Integer.parseInt(hotelId)));

    }

    public void unregisterHotel() {
        System.out.print("type hotelId : ");
        String hotelId = scan.nextLine();
        hotelsManager.removeHotel(Integer.parseInt(hotelId));
    }


    public void searchHotel() {
        System.out.print("type hotelId : ");
        String hotelId = scan.nextLine();
        System.out.println(hotelsManager.getMyHotel(Integer.parseInt(hotelId)));
    }

}
