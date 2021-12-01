package Garage;



import Garage.start;
import Garage.CalculateCost;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;


public class Main {
    
    public static Connect database(){
        Connect database = new Connect();
        database.createNewDatabase();
        database.createAccountTable();    
        database.createSpotsTable();
        database.createTakenSpotTable();
        //database.selectAllSpots();


        return database;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        

        Connect db = database();
        
        new start().setVisible(true);   
    }
}
