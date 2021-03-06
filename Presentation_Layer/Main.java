package Presentation_Layer;
import java.util.Scanner;

import Business_Logic_Layer.Customer;
enum Menu{
    opt0, opt1, opt2, opt3, opt4
}

public class Main {
    

    public static void main(String[] args) {
        String fName, lName, number, password;
        boolean notification = false, accepted = false;
        DisplayMenus disp = new DisplayMenus();

        disp.displayLogon();
        Scanner sc = new Scanner(System.in);
        String slct = sc.next();

        Menu choice = Menu.valueOf(slct);

        switch (choice) {
            case opt0:
            

                break;
            
            case opt1:
            //Capture user details
                System.out.println("Enter your name:");
                fName = sc.nextLine();
                System.out.println("Enter your surname:");
                lName = sc.nextLine();
                System.out.println("Enter your phone number:");
                number = sc.nextLine();
                System.out.println("Create a password for this order:");
                password = sc.nextLine();
                

            //Capture order details. Check if date is available. Generate orderNumber


            //Save user and order details
                Customer cus = new Customer(orderNumber, fName, lName, number, password, notification, accepted);
                cus.saveUser();
                break;
            
            case opt2:
                
                break;   
        
            case opt3:
                
                break;
            
            case opt4:
                
                break;
            
            default:
                break;
        }
    }


    

}
