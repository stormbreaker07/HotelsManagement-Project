//package Main;
//
//import database.EmptyRooms;
//import database.HotelDatabase;
//import database.RoomsDatabase;
//import hotel.Hotel;
//import hotel.HotelInterface;
//import hotelsManager.HotelsManager;
//import hotelsManager.HotelsManagerInterface;
//import roomsManagement.RoomManagement;
//import roomsManagement.RoomManagementInterface;
//import services.DeleteRoom;
//
//import java.util.Scanner;
//
//public class ApplicationInterection {
//
//    public static void main(String[] args) {
//
//        //initializing the database
//        EmptyRooms.initialize();
//        RoomsDatabase.initiate();
//        HotelDatabase.initiateDatabase();
//
//        //create important objects
//        HotelsManagerInterface hotelsManager = new HotelsManager();
//        RoomManagementInterface roomManagement = null;

//
//        System.out.println("<< HELLO USER >>");
//        Scanner scan = new Scanner(System.in);
//        String typeOfUser = "";
//
//
//        while(!typeOfUser.equals("-1")) {
//
//            System.out.println("type 1 if you are a Customer : " );
//            System.out.println("type 0 if you are a hotelOwner : ");
//            System.out.println("type -1 to exit from the app : ");
//
//            typeOfUser = scan.nextLine();
//
//
//            if (typeOfUser.equals("1")) {
//                String oper = "";
//                while (!oper.equals("-1")) {
//                    System.out.println("type 0 to get all hotels name");
//                    System.out.println("type 1 to search for a particular hotel");
//                    System.out.println("type 2 to book a hotel");
//                    System.out.println("type 3 to see avialable rooms in the hotel");
//                    System.out.println("type 4 to checkout from the room");
//                    System.out.println("type -1 to exit");
//
//                    oper = scan.nextLine();
//
//                    switch (oper) {
//                        case "0": {
//                            hotelsManager.allHotel();
//                            break;
//                        }
//                        case "1": {
//                            System.out.print("hotel Id : ");
//                            String hotelId = scan.nextLine();
//                            HotelInterface hotel = hotelsManager.getMyHotel(hotelId);
//                            System.out.println(hotel.getName());
//                            break;
//                        }
//                        case "2": {
//                            System.out.print("hotel Id : ");
//                            String hotelId = scan.nextLine();
//                            System.out.println("1 or 2 seater room");
//                            String seater = scan.nextLine();
//
//                            roomManagement = new RoomManagement(hotelId , Integer.parseInt(seater));
//                            roomManagement.bookARoom(hotelId , Integer.parseInt(seater));
//                            break;
//                        }
//                        case "3": {
//                            System.out.print("hotel Id : ");
//                            String hotelId = scan.nextLine();
//                            System.out.println("empty rooms : " + EmptyRooms.emptyRoom(hotelId));
//                            break;
//                        }
//                        case "4": {
//                            System.out.print("hotel Id : ");
//                            String hotelId = scan.nextLine();
//                            System.out.println("1 or 2 seater room");
//                            String seater = scan.nextLine();
//                            DeleteRoom deleteRoom = new DeleteRoom(hotelId, Integer.parseInt(seater));
//                            deleteRoom.deleteRoom();
//                            break;
//                        }
//                        case "-1": {
//                            System.out.println("Exiting.....");
//                            break;
//                        }
//                        default: {
//                            System.out.println("invalid input");
//                            break;
//                        }
//                    }
//                }
//            } else if (typeOfUser.equals("0")) {
//
//                String operation = "";
//
//                while (!operation.equals("-1")) {
//                    System.out.println("type 0 for register a hotel");
//                    System.out.println("type 1 for updating hotel");
//                    System.out.println("type 2 for unregister the hotel");
//                    System.out.println("type 3 for search a hotel");
//                    System.out.println("type -1 for exiting ");
//
//                    operation = scan.nextLine();
//
//
//                    //operation == 0 means we want to register the hotel
//                    if (operation.equals("0")) {
//                        System.out.print("Type hotel Name : ");
//                        String hotelName = scan.nextLine();
//                        System.out.print("Type hotel location : ");
//                        String hotelLocation = scan.nextLine();
//                        System.out.print("Type hotel Rating : ");
//                        String rating = scan.nextLine();
//                        System.out.print("Type hotel totalRooms : ");
//                        String totalRooms = scan.nextLine();
//                        String hotelId = hotelsManager.registerHotel(hotelName, hotelLocation,
//                                Integer.parseInt(rating), Integer.parseInt(totalRooms));
//                        System.out.println("the hotel id is :" + hotelId);
//                    } else if (operation.equals("1")) {
//                        System.out.print("type the hotelId : ");
//                        String hotelId = scan.nextLine();
//
//                        System.out.print("Type hotel Name : ");
//                        String hotelName = scan.nextLine();
//                        System.out.print("Type hotel location : ");
//                        String hotelLocation = scan.nextLine();
//                        System.out.print("Type hotel Rating : ");
//                        String rating = scan.nextLine();
//                        System.out.print("Type hotel totalRooms : ");
//                        String totalRooms = scan.nextLine();
//
//                        HotelInterface newHotelData = new Hotel(hotelName, hotelLocation, Integer.parseInt(rating)
//                                , Integer.parseInt(totalRooms));
//                        String newHotelId = hotelsManager.updateHotel(hotelId, newHotelData);
//                        System.out.println("the new hotel id is : " + newHotelId);
//                    } else if (operation.equals("2")) {
//                        System.out.print("hotel id : ");
//                        String hotelId = scan.nextLine();
//                        hotelsManager.removeHotel(hotelId);
//                    } else if (operation.equals("3")) {
//                        System.out.print("hotel id : ");
//                        String hotelId = scan.nextLine();
//                        HotelInterface getHotel = hotelsManager.getMyHotel(hotelId);
//                        if (getHotel != null) {
//                            System.out.println(getHotel.getName() + " " + getHotel.getLocation() + " "
//                                    + getHotel.getRating() + " " + getHotel.getAllRooms());
//                        } else {
//                            System.out.println("invalid hotel id.");
//                        }
//                    } else if (operation.equals("-1")) {
//                        System.out.println("Exiting....");
//                        break;
//                    } else {
//                        System.out.println("invalid input try again");
//                    }
//                }
//            } else if (typeOfUser.equals("-1")) {
//                System.out.println("Exiting from the app....");
//                break;
//            } else {
//                System.out.println("invalid input , Try again..");
//            }
//        }
//    }
//}
