package com.main;

import com.database.HotelDatabase;
import com.database.RoomsDatabase;
import com.hotel.Hotel;
import com.hotel.HotelInterface;
import com.hotelsManager.HotelsManager;
import com.hotelsManager.HotelsManagerInterface;
import com.roomsManagement.RoomManagementInterface;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        //initializing the database

        RoomsDatabase.initiate();
        HotelDatabase.initiateDatabase();

        //create important objects
        HotelsManagerInterface hotelsManager = new HotelsManager();
        RoomManagementInterface roomManagement;
        roomManagement = null;


        System.out.println("<< HELLO USER >>");
        Scanner scan = new Scanner(System.in);
        String typeOfUser = "";


        while(!typeOfUser.equals("-1")) {

            System.out.println("type 1 if you are a Customer : " );
            System.out.println("type 0 if you are a hotelOwner : ");
            System.out.println("type -1 to exit from the app : ");

            typeOfUser = scan.nextLine();
            if (typeOfUser.equals("0")) {
            String operation = "";

                while (!operation.equals("-1")) {
                    System.out.println("type 0 for register a hotel");
                    System.out.println("type 1 for updating hotel");
                    System.out.println("type 2 for unregister the hotel");
                    System.out.println("type 3 for search a hotel");
                    System.out.println("type -1 for exiting ");

                    operation = scan.nextLine();


                    //operation == 0 means we want to register the hotel
                    if (operation.equals("0")) {
                        System.out.print("Type hotel Name : ");
                        String hotelName = scan.nextLine();
                        System.out.print("Type hotel location : ");
                        String hotelLocation = scan.nextLine();
                        System.out.print("Type hotel Rating : ");
                        String rating = scan.nextLine();
                        System.out.print("Type hotel totalRooms : ");
                        String totalRooms = scan.nextLine();
                        System.out.print("Const of oneSeater Room : ");
                        String oneSeaterRoomCost = scan.nextLine();
                        System.out.print("Const of twoSeater Room : ");
                        String twoSeaterRoomCost = scan.nextLine();
                        int hotelId = hotelsManager.registerHotel(hotelName, hotelLocation,
                                Integer.parseInt(rating), Integer.parseInt(totalRooms),Integer.parseInt(oneSeaterRoomCost),
                                Integer.parseInt(twoSeaterRoomCost));
                        System.out.println("the hotel id is :" + hotelId);
                    } else if (operation.equals("1")) {
                        System.out.print("type the hotelId : ");
                        String hotelId = scan.nextLine();

                        System.out.print("Type hotel Name : ");
                        String hotelName = scan.nextLine();
                        System.out.print("Type hotel location : ");
                        String hotelLocation = scan.nextLine();
                        System.out.print("Type hotel Rating : ");
                        String rating = scan.nextLine();
                        System.out.print("Type hotel totalRooms : ");
                        String totalRooms = scan.nextLine();
                        System.out.print("Const of oneSeater Room : ");
                        String oneSeaterRoomCost = scan.nextLine();
                        System.out.print("Const of twoSeater Room : ");
                        String twoSeaterRoomCost = scan.nextLine();


                        HotelInterface newHotelData = new Hotel(hotelName, hotelLocation, Integer.parseInt(rating)
                                , Integer.parseInt(totalRooms),Integer.parseInt(oneSeaterRoomCost),
                                Integer.parseInt(twoSeaterRoomCost));
                        hotelsManager.updateHotel(Integer.parseInt(hotelId), newHotelData);
                        System.out.println("the new hotel id is : " + hotelId);
                    } else if (operation.equals("2")) {
                        System.out.print("hotel id : ");
                        String hotelId = scan.nextLine();
                        hotelsManager.removeHotel(Integer.parseInt(hotelId));
                    } else if (operation.equals("3")) {
                        System.out.print("hotel id : ");
                        String hotelId = scan.nextLine();
                        HotelInterface getHotel = hotelsManager.getMyHotel(Integer.parseInt(hotelId));
                        if (getHotel != null) {
                            System.out.println(getHotel.getName() + " " + getHotel.getLocation() + " "
                                    + getHotel.getRating() + " " + getHotel.getTotalRooms());
                        } else {
                            System.out.println("invalid hotel id.");
                        }
                    } else if (operation.equals("-1")) {
                        System.out.println("Exiting....");
                        break;
                    } else {
                        System.out.println("invalid input try again");
                    }
                }
            } else if (typeOfUser.equals("-1")) {
                System.out.println("Exiting from the app....");
                break;
            } else {
                System.out.println("invalid input , Try again..");
            }
        }

    }
}
