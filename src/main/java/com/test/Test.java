package com.test;

import com.database.HotelDatabase;
import com.database.RoomsDatabase;
import com.hotel.HotelInterface;
import com.hotelsManager.HotelsManager;
import com.hotelsManager.HotelsManagerInterface;
import com.roomsManagement.RoomManagement;
import com.roomsManagement.RoomManagementInterface;
import com.services.DeleteRoom;
import com.services.FindHotel;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        //initializing the database

        RoomsDatabase.initiate();
        HotelDatabase.initiateDatabase();

        //create important objects
        HotelsManagerInterface hotelsManager = new HotelsManager();
        RoomManagementInterface roomManagement = new RoomManagement();

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
                    }
                    else if (operation.equals("1")) {

                        System.out.print("type the hotelId : ");
                        String hotelId = scan.nextLine();
                        FindHotel findHotel = new FindHotel(Integer.parseInt(hotelId));
                        System.out.println(findHotel.findHotel().toString());

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

                        hotelsManager.updateHotel(Integer.parseInt(hotelId),hotelName, hotelLocation,rating
                                ,totalRooms,oneSeaterRoomCost,twoSeaterRoomCost );
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
                            System.out.println(getHotel);
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
            }
            else if(typeOfUser.equals("1")) {
                String oper = "";
                while (!oper.equals("-1")) {
                    System.out.println("type 0 to get all hotels name");
                    System.out.println("type 1 to search for a particular hotel");
                    System.out.println("type 2 to book a hotel");
                    System.out.println("type 3 to see avialable rooms in the hotel");
                    System.out.println("type 4 to checkout from the room");
                    System.out.println("type -1 to exit");

                    oper = scan.nextLine();

                    switch (oper) {
                        case "0": {
                            hotelsManager.allHotel();
                            break;
                        }
                        case "1": {
                            System.out.print("hotel Id : ");
                            String hotelId = scan.nextLine();
                            HotelInterface hotel = hotelsManager.getMyHotel(Integer.parseInt(hotelId));
                            System.out.println(hotel);
                            break;
                        }
                        case "2": {
                            System.out.print("hotel Id : ");
                            String hotelId = scan.nextLine();
                            System.out.println("1 or 2 seater room");
                            String seater = scan.nextLine();
                            roomManagement.bookARoom(Integer.parseInt(hotelId) , Integer.parseInt(seater));
                            break;
                        }
                        case "3": {
                            System.out.print("hotel Id : ");
                            String hotelId = scan.nextLine();
                            System.out.println("empty rooms : " + hotelsManager.getMyHotel(Integer.parseInt(hotelId)));
                            break;
                        }
                        case "4": {
                            System.out.print("hotel Id : ");
                            String hotelId = scan.nextLine();
                            System.out.println("1 or 2 seater room");
                            String seater = scan.nextLine();
                            DeleteRoom deleteRoom = new DeleteRoom(Integer.parseInt(hotelId), Integer.parseInt(seater));
                            Boolean result = deleteRoom.deleteRoom();
                            if(result == true) {
                                System.out.println("operation successful");
                            }
                            else
                            {
                                System.out.println("operation unsuccessful");
                            }
                            break;
                        }
                        case "-1": {
                            System.out.println("Exiting.....");
                            break;
                        }
                        default: {
                            System.out.println("invalid input");
                            break;
                        }
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
