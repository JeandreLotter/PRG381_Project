package Business_Logic_Layer;

public class Staff extends Person{
    private String fName, lName, number, password;
    private boolean isStaff, notification;

    public Staff(String fName_, String lName_, String number_, String password_, boolean isStaff_, boolean notification_){
        this.fName = fName_;
        this.lName = lName_;
        this.number = number_;
        this.password = password_;
        this.isStaff = isStaff_;
        this.notification = notification_;
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

    @Override
    public String NotifyUser(String orderNumber, boolean updated) {
        if (updated) {
            String message = "Details of the order: ["+orderNumber+"] has been changed!";
            return message;
        }
        else{
            return "No updates";
        }
    }
    
}
