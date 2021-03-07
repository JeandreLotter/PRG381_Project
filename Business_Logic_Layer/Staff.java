package Business_Logic_Layer;

import Data_Access_Layer.DataHandler;

public class Staff extends Person{
    private String fName, lName, number, password;

    public Staff(String fName_, String lName_, String number_, String password_){
        this.fName = fName_;
        this.lName = lName_;
        this.number = number_;
        this.password = password_;
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

    @Override
    public String NotifyUser(String orderNumber) {
            String message = "Details of the order: ["+orderNumber+"] has been changed!";
            return message;
    }

    @Override
    public void saveUser() {
        String saveUser = fName+","+lName+","+number+","+password;
        DataHandler dh = new DataHandler();
        dh.StaffDetails(saveUser);
    }
    
}
