package Business_Logic_Layer;

import Data_Access_Layer.DataHandler;

public class Customer extends Person{
    private String orderNum, fName, lName, number, password;
    private boolean notification, accepted;

    public Customer(String orderNum_, String fName_, String lName_, String number_, String password_,boolean notification_, boolean accepted_){
        this.orderNum = orderNum_;
        this.fName = fName_;
        this.lName = lName_;
        this.number = number_;
        this.password = password_;
        this.notification = notification_;
        this.accepted = accepted_;
    }
    
    public String GetOrderNum(){
        return this.orderNum;
    }

    public String GetFname(){
        return this.fName;
    }

    public String GetLname(){
        return this.lName;
    }

    public String GetNum(){
        return this.number;
    }

    public String GetPassword(){
        return this.password;
    }

    public boolean GetNotification(){
        return this.notification;
    }

    public boolean GetAccepted(){
        return this.accepted;
    }
    
    @Override
    public String NotifyUser(String orderNumber) {
            String message = "Your order ["+orderNumber+"] has been accepted!";
            return message; 
    }

    @Override
    public void saveUser() {
        String saveUser = fName+","+lName+","+number+","+password+","+notification;
        DataHandler dh = new DataHandler();
        dh.UserDetails(saveUser);
    }
    
}
