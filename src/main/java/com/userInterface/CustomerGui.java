package com.userInterface;

import com.customerVerification.CustomerVerificationManager;
import com.hotel.Hotel;
import com.hotel.HotelInterface;
import com.hotelsManager.HotelsManager;
import com.roomsManagement.RoomManagement;

import java.util.Scanner;

public class CustomerGui {

    private Scanner scan ;
    private VerifyUserCui verify;
    private HotelsManager hotelsManager;
    private RoomManagement roomManagement;
    private PaymentUI paymentUI;
    /**
     * first check the user authentication means signup or signin page
     * after that send user to CUI for booking
     */
    public CustomerGui(Scanner scan) {
        this.scan = scan;
        hotelsManager = new HotelsManager();
        roomManagement = new RoomManagement();
        verify = new VerifyUserCui(scan);
        Boolean result = verify.verifyUser();
        if(result) {
            mainCustomerCui();
        }
        else {
            System.out.println("No verification No access to App , Exiting ... ");
        }

    }

    public void mainCustomerCui() {

        String oper = "";
        while (!oper.equals("-1")) {
                System.out.println("type 0 to get all hotels name");
                System.out.println("type 1 to search for a particular room");
                System.out.println("type 2 to book a hotel");
                System.out.println("type 3 to see avialable rooms in the hotel");
                System.out.println("type 4 to checkout from the room");
                System.out.println("type -1 to exit");

                oper = scan.nextLine();
            switch (oper) {
                case "0": {
                    geAllHotels();
                    break;
                }
                case "1": {
                    System.out.print("hotel Id : ");
                    String hotelId = scan.nextLine();
                    System.out.println(hotelsManager.getMyHotel(Integer.parseInt(hotelId)));
                    break;
                }
                case "2": {
                    bookRoom();
                    break;
                }
                case "3": {
                    System.out.print("hotel Id : ");
                    String hotelId = scan.nextLine();
                    System.out.println(availableRooms(hotelId));
                    break;
                }
                case "4": {
                    removeRoom();
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
    }

    public void geAllHotels() {
        hotelsManager.allHotel();
    }

    public void searchAHotel() {
        System.out.print("hotel Id : ");
        String hotelId = scan.nextLine();
        HotelInterface hotel = hotelsManager.getMyHotel(Integer.parseInt(hotelId));
        if(hotel!=null) {
            System.out.println(hotel);
        }
    }

    public void bookRoom() {
        System.out.print("hotel Id : ");
        String hotelId = scan.nextLine();
        System.out.println("1 or 2 seater room");
        String seater = scan.nextLine();
        if(availableRooms(hotelId) > 0 ) {
            HotelInterface hotel = hotelsManager.getMyHotel(Integer.parseInt(hotelId));
            int price = 0;
            if(seater.equals("1")) {
                price = hotel.getOneSeaterRoomPrice();
            }
            else if(seater.equals("2")) {
                price = hotel.getTwoSeaterRoomPrice();
            }
            else if(seater.equals("-1")) {
                return ;
            }
            else {
                System.out.println("wrong Input");
            }

            //payment options
           paymentUI = new PaymentUI(scan , String.valueOf(price));
            paymentUI.insertData();

            //after payment book a room
            roomManagement.bookARoom(Integer.parseInt(hotelId) , Integer.parseInt(seater));


        }
        else {
            System.out.println("no empty room available in this hotel");
        }

    }

    public int availableRooms(String hotelId) {
        HotelInterface hotel = hotelsManager.getMyHotel(Integer.parseInt(hotelId));
        if(hotel!=null) {
            return hotel.getEmptyRooms();
        }
        else {
            return 0;
        }
    }

    public void removeRoom() {
        try {
            System.out.print("hotel id : ");
            String hotelId = scan.nextLine();
            System.out.print("number of seater room : ");
            String seaterRoom = scan.nextLine();
            roomManagement.removeRoom(Integer.parseInt(hotelId), Integer.parseInt(seaterRoom));
        }catch(Exception e) {
            System.out.println("no room of that specification is booked till now");
        }
    }


}
