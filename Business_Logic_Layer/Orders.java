package Business_Logic_Layer;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
public class Orders {
   
private  String  theme, venueAddress, venueNum, eventType, orderNum;
private  int numAdult, numKids;
private  double price;
private LocalDate eventDate; 

public Orders(String theme_,String venueAddress_,String venueNum_,
                                    String eventType_,String orderNum_,int numAdult_,int numKids_,double price_,LocalDate eventDate_){
                                       
         this.theme = theme_;
         this.venueAddress = venueAddress_;
         this.venueNum = venueNum_;
         this.eventType = eventType_;
         this.orderNum = orderNum_;
         this.numAdult = numAdult_;
         this.numKids = numKids_;
         this.price = price_;
         this.eventDate = eventDate_;
}


public String Gettheme(){
    return theme;
};

public String GetvenueAddress(){
    return venueAddress;
};

public String GetvenueNum(){
    return venueNum;
};

public String GeteventType(){
    return eventType;
};

public String GetorderNum(){
    return orderNum;
};

public int GetnumAdult(){
    return numAdult;
};

public int GetnumKids(){
    return numKids;
};

public double Getprice(){
    return price;
};

public LocalDate GeteventDate(){
    return eventDate;
};




public String DateCheck(){
LocalDate  currentDate = java.time.LocalDate.now();
long daysBetween = ChronoUnit.DAYS.between(currentDate,eventDate);

if (daysBetween == 15) {
    return "Please pay " + price/2 + " or the order may be canceled";
}
else{
    return "Days before payment deadline not exeeded";
}
}

public void CalculatePrice(double costAdultFood,double costKidsFood, double costDrink, double costDesserts,double costtheme){ //cost per person is sent from presentation layer 
price = (numAdult * costAdultFood) + (numKids * costKidsFood) + ((numAdult + numKids) * costDrink) + ((numAdult + numKids) * costDesserts) + ((numAdult + numKids) * costtheme);
}

public void  Discount15(double costAdultFood){
double discount = costAdultFood * 0.15; 
price  = price - discount;
}

}


