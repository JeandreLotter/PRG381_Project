  
package Data_Access_Layer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.sound.midi.Patch;


public class DataHandler {
String Mfile = "";
public void UserDetails(String saveUser){
    try {
        String Pathway = "Resources\\Users.txt";
        FileWriter myWriter = new FileWriter(Pathway);
        myWriter.append(saveUser);
        myWriter.close();
        System.out.println("User successfully registered");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}

public void StaffDetails(String saveUser){
  try {
      String Pathway = "Resources\\Staff.txt";
      FileWriter myWriter = new FileWriter(Pathway);
      myWriter.append(saveUser);
      myWriter.close();
      System.out.println("Staff successfully registered");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}

public void EventDetail(String orderDetails){
    try {
        
        String Pathway = ".resources/Orders.txt";
        FileWriter myWriter = new FileWriter(Pathway);
        myWriter.append(orderDetails);
        myWriter.close();
        System.out.println("Successfully registered");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}


public void ReadFile(){
    try {
        FileReader reader = new FileReader("Resources\\Orders.txt");
        int character;

        while ((character = reader.read()) != -1) {
            System.out.print((char) character);
        }
        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

//Validation user
public Boolean Validation(String orderNum,String Pass){

  Scanner scanner = new Scanner("Resources\\Users.txt");
  String[] tokens = {};
  while(scanner.hasNext()){
      tokens = scanner.nextLine().split(",");
      String last = tokens[tokens.length - 1];
      System.out.println(last);
  }
  String test = tokens[0];
  String PassWord = tokens[4];
  if(orderNum == test && Pass == PassWord){
      return true;
  }else{
      return false;
  }
}

//Validation staff
public Boolean ValidationStaff(String Uname,String Pass){

  Scanner scanner = new Scanner("Resources\\Users.txt");
  String[] tokens = {};
  while(scanner.hasNext()){
      tokens = scanner.nextLine().split(",");
      String last = tokens[tokens.length - 1];
      System.out.println(last);
  }
  String UserName = tokens[1];
  String lName = tokens[2];
  String PassWord = tokens[4];
  String test = UserName+lName;
  if(Uname == test && Pass == PassWord){
      return true;
  }else{
      return false;
  }
}

//Display user information 
public ArrayList<String> readUser() throws IOException{
  Scanner scanner = new Scanner("Resources\\Users.txt");
  ArrayList<String> tokens = new ArrayList<String>();
  while(scanner.hasNext()){
      tokens.add(scanner.nextLine());
  }
  return tokens;
}

//Display staff information 
public ArrayList<String> readStaff() throws IOException{
  Scanner scanner = new Scanner("Resources\\Staff.txt");
  ArrayList<String> tokens = new ArrayList<String>();
  while(scanner.hasNext()){
      tokens.add(scanner.nextLine());
  }
  return tokens;
}
//Display order information 
public ArrayList<String> readOrders() throws IOException{
  Scanner scanner = new Scanner("Resources\\Orders.txt");
  ArrayList<String> tokens = new ArrayList<String>();

  while(scanner.hasNext()){
      tokens.add(scanner.nextLine());
  }
  return tokens;
}

//Display order updates information 
public ArrayList<String> readUpdates() throws IOException{
  Scanner scanner = new Scanner("Resources\\OrdersChanges.txt");
  ArrayList<String> tokens = new ArrayList<String>();

  while(scanner.hasNext()){
      tokens.add(scanner.nextLine());
  }
  return tokens;
}

//delete user
public void Writetofile(ArrayList<String>list){
  try {
    BufferedWriter writer = new BufferedWriter(new FileWriter("Resources\\Users.txt"));
    writer.write("");
    for(String x:list){
      writer.append(x);
      writer.newLine();
    }
    writer.close();
  } catch (Exception e) {
    e.getStackTrace();
  }
}

public void DeleteUser(String orderNum) throws IOException{
ArrayList<String> list = new ArrayList<>();
DataHandler dh = new DataHandler();
list = dh.readUser();
System.out.println(list.toString());
for(int i =0;i<list.size();i++){
  if(list.get(i).split(",")[0] == orderNum){
    list.remove(i);
    Writetofile(list);
  }
}
System.out.println(list.toString());
}

//delete Order
public void Writetoofile(ArrayList<String>list){
  try {
    BufferedWriter writer = new BufferedWriter(new FileWriter("Resources\\Orders.txt"));
    writer.write("");
    for(String x:list){
      writer.append(x);
      writer.newLine();
    }
    writer.close();
  } catch (Exception e) {
    e.getStackTrace();
  }
}

public void DeleteOrder(String orderNum) throws IOException{
ArrayList<String> list = new ArrayList<>();
DataHandler dh = new DataHandler();
list = dh.readUser();
System.out.println(list.toString());
for(int i =0;i<list.size();i++){
  if(list.get(i).split(",")[0] == orderNum){
    list.remove(i);
    Writetoofile(list);
  }
}
System.out.println(list.toString());
}

public void UpdateOrders(String orderdetail) throws IOException{
  String filePath = "Resources\\Orders.txt";
  Scanner sc = new Scanner(filePath);
  FileWriter writer = new FileWriter(filePath);
  StringBuffer buffer = new StringBuffer();
  while (sc.hasNextLine()) {
     buffer.append(sc.nextLine()+System.lineSeparator());
  }
  String fileContents = buffer.toString();
  System.out.println("Contents of the file: "+fileContents);
  sc.close();
  
  while(sc.hasNext()){
    String[] tokens = sc.nextLine().split(",");
    String last = tokens[tokens.length - 1];
  
  String oldLine = last;
  //add update all
  String newLine = orderdetail;
  //Replacing the old line with new line
  fileContents = fileContents.replaceAll(oldLine, newLine);
  //instantiating the FileWriter class
  
  System.out.println("");
  System.out.println("new data: "+fileContents);
  writer.append(fileContents);
  writer.flush();
  }
  writer.close();
}

 public String nextOrderNum() throws IOException{
    Path source = Paths.get("./Resources/Orders.txt");
    Scanner sc = new Scanner(source);
    String last ="";
    while (sc.hasNextLine()) {
      last = sc.nextLine();
    }
    String[] lastline = last.split(",");
    int i = Integer.parseInt(lastline[0]) + 1;
    System.out.println(i);
    return Integer.toString(i);
 }
  
}


