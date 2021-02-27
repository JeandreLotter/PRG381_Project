package Data_Access_Layer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DataHandler {
String Mfile = "";
public void UserDetails(String fname, String lname, String phone, String IDnumber, String Uname, String pass){
    try {
        Mfile = fname;
        String Pathway = "C:\\Users\\Riaan\\Desktop\\Subects\\PRG381\\ProjectPRG381\\" + Mfile+".txt";
        FileWriter myWriter = new FileWriter(Pathway);
        myWriter.write(fname+","+lname+","+phone+","+IDnumber+","+Uname+","+pass);
        myWriter.close();
        System.out.println("Successfully registered "+ fname + " " + lname + " to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}

public void EventDetail(String eType, String Date, String Time, String Address, int amount, int aMount, int camount, String Deserts, String Decorations, String decSize, Double Total){
    try {
        
        String Pathway = "C:\\Users\\Riaan\\Desktop\\Subects\\PRG381\\ProjectPRG381\\" + Mfile+".txt";
        FileWriter myWriter = new FileWriter(Pathway);
        myWriter.write(eType+","+Date+","+Time+","+Address+","+amount+","+amount+","+camount+","+Deserts+","+Decorations+","+decSize+","+Total);
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
