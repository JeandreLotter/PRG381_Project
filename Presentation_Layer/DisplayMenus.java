package Presentation_Layer;

public class DisplayMenus {
    public void displayLogon(){
        System.out.println("Welcome to Delicious-Catering!");
        System.out.println("");
        System.out.println("Would you like to:");
        System.out.println("===================================");
        System.out.println("1) Place a new order");
        System.out.println("2) Check status of your order");
        System.out.println("3) Modify or cancel your order");
        System.out.println("4) Log in as Staff member");
        System.out.println("0) Exit");
        System.out.println("===================================");
    }

    public void displayAdultFood(){
        System.out.println("What food do you want for the adults?");
        System.out.println("1) Steak and Chips");
        System.out.println("2) Burger and Chips");
        System.out.println("3) Fettuccine Alfredo");
        System.out.println("4) Pizza");
    }

    public void displayModifyCancel(){
        System.out.println("Would you like to Modify or Cancel your order?");
        System.out.println("1) Modify");
        System.out.println("2) Cancel");
    }
}
