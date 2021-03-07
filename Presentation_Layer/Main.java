package Presentation_Layer;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import Business_Logic_Layer.Customer;
import Business_Logic_Layer.Orders;
import Business_Logic_Layer.Staff;
import Data_Access_Layer.DataHandler;

enum Menu{
    opt0, opt1, opt2, opt3, opt4
}

public class Main {
    

    public static void main(String[] args) throws IOException {
        DataHandler dh = new DataHandler();
        String fName, lName, number, password, staffName, stafflname,
                  snumber, staffPass,theme, venueAddress, venueNum, eventType, orderNum,
                  aduldFood = "", kidsFood = "", drinks = "", desserts = "";
        double  aduldFoodPrice = 0, kidsFoodPrice = 0, drinksPrice = 0, dessertsPrice = 0, themePrice = 500.99;
        boolean notification = false, accepted = false;
        int numAdult, numKids;
        //double price;
        LocalDate eventDate;


        DisplayMenus disp = new DisplayMenus();

        disp.displayLogon();
        Scanner sc = new Scanner(System.in);
        String slct = sc.nextLine();

        Menu choice = Menu.values()[Integer.parseInt(slct)];

        switch (choice) {
            case opt0:
                System.exit(0);
                break;
            
            case opt1:
            //Capture user details
            orderNum = dh.nextOrderNum();  //Autogen order number
                System.out.println("Enter your name:");
                fName = sc.nextLine();
                System.out.println("Enter your surname:");
                lName = sc.nextLine();
                System.out.println("Enter your phone number:");
                number = sc.nextLine();
                System.out.println("Create a password for this order:");
                password = sc.nextLine();
                

            //Capture order details. Check if date is available. Generate orderNumber

            //orderNum = dh.nextOrderNum();  //Autogen order number

            System.out.println("Enter the theme:");
            theme = sc.nextLine();
            System.out.println("Enter the venue address:");
            venueAddress = sc.nextLine();
            System.out.println("Enter the venue cell number:");
            venueNum = sc.nextLine();
            System.out.println("Enter the type of event:");
            eventType = sc.nextLine();
            System.out.println("Enter number of adults joining:");
            numAdult = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number of kids joining:");
            numKids = Integer.parseInt(sc.nextLine());
            //get event date
            String year, month, day;
            System.out.println("Enter year");
            year = sc.nextLine();
            System.out.println("Enter month");
            month = sc.nextLine();
            System.out.println("Enter day");
            day = sc.nextLine();
            LocalDate date = LocalDate.parse(year+"-"+month+"-"+day);
            eventDate = date; 
            //AdultFood switch

            disp.displayAdultFood();
            slct = sc.next();
            choice = Menu.values()[Integer.parseInt(slct)];

            switch (choice) {
                case opt1:
                   aduldFood = "Steak and chips";
                   aduldFoodPrice = 45.25;
                break;
                case opt2:
                aduldFood = "Burger and Chips";
                aduldFoodPrice = 40.50;
                break;
                case opt3:
                aduldFood = "Fettuccine Alfredo";
                aduldFoodPrice = 90.50;
                break;
                case opt4:  
                aduldFood = "Pizza";
                aduldFoodPrice = 70.50;
                    break;
                default:
                    break;
            }

             //KidsFood switch

             disp.displayKidsFood();
             slct = sc.next();
             choice = Menu.values()[Integer.parseInt(slct)];
 
             switch (choice) {
                 case opt1:
                 kidsFood = "Fishfingers and Chips";
                kidsFoodPrice = 25.25;
                 break;
                 case opt2:
                 kidsFood = "Burger and Chips";
                 kidsFoodPrice = 40.50;
                 break;
                 case opt3:
                 kidsFood = "Mac and Cheese";
                 kidsFoodPrice = 35.50;
                 break;
                 case opt4:  
                 kidsFood = "Pizza";
                 kidsFoodPrice = 40.50;
                     break;
                 default:
                     break;
             }

              //Drinks switch

            disp.displayDrinks();
            slct = sc.next();
            choice = Menu.values()[Integer.parseInt(slct)];

            switch (choice) {
                case opt1:
                   drinks = "Coke";
                   drinksPrice = 19.50;
                break;
                case opt2:
                drinks = "Fanta orange";
                drinksPrice = 17.50;
                break;
                case opt3:
                drinks = "Fanta grape";
                drinksPrice = 16.50;
                break;
                case opt4:  
                drinks = "Mountain dew";
                drinksPrice = 15.50;
                    break;
                default:
                    break;
            }

             //Desserts switch

             disp.displayDessert();
             slct = sc.next();
             choice = Menu.values()[Integer.parseInt(slct)];
 
             switch (choice) {
                 case opt1:
                    desserts = "Cheese cake";
                    dessertsPrice = 35.25;
                 break;
                 case opt2:
                 desserts = "Waffle";
                 dessertsPrice = 20.50;
                 break;
                 case opt3:
                 desserts = "Ice creame";
                 dessertsPrice = 15.50;
                 break;
                 case opt4:  
                 desserts = "Chocolate cake";
                 dessertsPrice = 17.50;
                     break;
                 default:
                     break;
             }

             

            

            //Save user and order details
                Customer cus = new Customer(orderNum, fName, lName, number, password, notification, accepted);
                Orders or = new Orders(theme, venueAddress, venueNum, eventType, orderNum, numAdult, numKids, eventDate, aduldFood, kidsFood, drinks, desserts);
                or.CalculatePrice(aduldFoodPrice, kidsFoodPrice, drinksPrice, dessertsPrice, themePrice);
                cus.saveUser();
                or.saveOrder();

                break;
            
            case opt2:
                
                break;   
        
            case opt3:
            // displayModifyCancel switch

             while (true) {
                System.out.println("Enter your order number:");
                String iOrderNumber = sc.nextLine();
                System.out.println("Enter password:");
                String iUserPass = sc.nextLine();
                if (dh.Validation(iOrderNumber, iUserPass) ) {
                    disp.displayModifyCancel();
            slct = sc.next();
            choice = Menu.values()[Integer.parseInt(slct)];
            
            switch (choice) {
                case opt1:
                   //Modify 
                  dh.UpdateOrders(iOrderNumber);
                break;
                case opt2:
                 // Cancel order
                 
                 dh.DeleteOrder(iOrderNumber);
                 dh.DeleteUser(iOrderNumber);
                break;
                default:
                    break;
            }
                break;
                }
             }

            
            
            case opt4:
                while (true) {
                    System.out.println("Enter your name:");
                    staffName = sc.nextLine();
                    System.out.println("Enter your surname:");
                    stafflname = sc.nextLine();
                    System.out.println("Enter password:");
                    staffPass = sc.nextLine();
                    if (dh.ValidationStaff(staffName+stafflname, staffPass)) {
                        System.out.println("Access granted. Welcome "+ staffName);
                        System.out.println("Would you like to:");
                        System.out.println("1) Add staff member");
                        System.out.println("2) View order changes");
                        String response = sc.nextLine();
                        if (response == "1") {
                             System.out.println("Enter staff name:");
                             String sfName = sc.nextLine();
                             System.out.println("Enter staff surname:");
                             String slName = sc.nextLine();
                             System.out.println("Enter staff phone number:");
                             snumber = sc.nextLine();
                             System.out.println("Create a password for this staff member:");
                             String spassword = sc.nextLine();
                             Staff stf = new Staff(sfName, slName, snumber, spassword);
                             stf.saveUser();
                             break;
                        }else if (response=="2") {
                            dh.ReadFile();
                            break;
                        } else {
                            System.out.println("Invalid input");
                        }
                    }
                    else{
                        System.out.println("Access denied! Try again");
                    }
                }
                

                
                break;
            
            default:
                break;
        }
    }


    

}
//opt0