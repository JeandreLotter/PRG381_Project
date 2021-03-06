  
package Data_Access_Layer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DataHandler {
String Mfile = "";
public void UserDetails(String saveUser){
    try {
        String Pathway = "Resources\\Users.txt";
        FileWriter myWriter = new FileWriter(Pathway);
        myWriter.write(saveUser);
        myWriter.close();
        System.out.println("User successfully registered");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}

public void EventDetail(String OrderNumber, String eType, String Date, String Time, String Address, int amount, int aMount, int camount, String Deserts, String Decorations, String decSize, Double Total){
    try {
        
        String Pathway = "resources\\Orders.txt";
        FileWriter myWriter = new FileWriter(Pathway);
        myWriter.write(OrderNumber+","+eType+","+Date+","+Time+","+Address+","+amount+","+amount+","+camount+","+Deserts+","+Decorations+","+decSize+","+Total);
        myWriter.close();
        System.out.println("Successfully registered "+ eType + " for the " + Date + " and at " + Time);
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}


public void ReadFile(String Path){
    try {
        FileReader reader = new FileReader(Path);
        int character;

        while ((character = reader.read()) != -1) {
            System.out.print((char) character);
        }
        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}