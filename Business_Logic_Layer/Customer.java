package Business_Logic_Layer;

public class Customer extends Person{
    private String fName, lName, number, password, message;
    private boolean isStaff, notification;

    public Customer(String fName_, String lName_, String number_, String password_, boolean isStaff_, boolean notification_, String message_){
        this.fName = fName_;
        this.lName = lName_;
        this.number = number_;
        this.password = password_;
        this.isStaff = isStaff_;
        this.notification = notification_;
        this.message = message_;
    }
    
    public String GetFname(){
        return fName;
    };

    public String GetLname(){
        return lName;
    };

    public String GetNum(){
        return number;
    };

    public String GetPassword(){
        return password;
    };

    public boolean GetIsStaff(){
        return isStaff;
    };

    public boolean GetNotification(){
        return notification;
    };

    public String GetMessage(){
        return message;
    };
    @Override
    public String NotifyUser(String orderNumber, boolean accepted) {
        if (accepted) {
            String message = "Your order ["+orderNumber+"] has been accepted!";
            return message;
        }
        else{
            return "No response yet";
        }
    }
    
}
