package GUI;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * What Database Data we are storing:
 * ID Number, FirstName, LastName, Parking Spot Number, Time/Date Entered, Paid?
 */


public class Database {
    private String FILENAME;
    private File DATAFILE;
    private ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();
    
    /*
    Constructor Method;
    Takes the Filename puts into private object variable, called FILENAME.
    DATA, another private object variable, makes the file object so it can be
    read and writen to.
    
    Param: String _fileName takes the name of the file
    */
    public Database(String _fileName){
        this.FILENAME = _fileName;
        
        this.DATAFILE = new File(FILENAME);
        
        readFile();
    }
    
    /*
    TODO: This should work if the CUSTOMER ARRAYLIST WORKS.
    It now works 10/5/2021
    */
    public void writeToFile(){
        try {
            FileWriter DataWriter = new FileWriter(FILENAME);
            for(int i = 0; i < CUSTOMERS.size(); i++){
                DataWriter.write(CUSTOMERS.get(i) + "\n");
                System.out.println(CUSTOMERS.get(i));
            }
            DataWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("A WRITE error has occurred.");
            e.printStackTrace();
        }
    }
    
    /*
    Read File Method, used with the constructor, to store all the customers in
    an arraylist for easy access when running the program.
    */
    private void readFile(){
        try{
            Scanner reader = new Scanner(DATAFILE);
            while(reader.hasNextLine()){
                //System.out.println(reader.nextLine());
                String data = reader.nextLine();
                CUSTOMERS.add(new Customer(data));
                
                //System.out.println(data);
            }
            for(int i = 0; i < CUSTOMERS.size(); i++){
                System.out.println(CUSTOMERS.get(i) + "\n");
            }
        } catch (FileNotFoundException e){
            System.out.println("A READ error has occured: ");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Customer> getCustomers(){
        return CUSTOMERS;
    }
    
    public String getParkingSpot(int index){
        return CUSTOMERS.get(index).getParkingSpot();
    }
}
