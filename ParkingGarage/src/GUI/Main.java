package GUI;



import GUI.PGarage;
import GUI.start;
import GUI.CalculateCost;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;





public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        
        /*
        This how to read the file and get the data into a arraylist
        Database File = new Database("src/Database.txt");
        Arraylist<Customer> CustomerData = File.getCustomers();
        
        Use method writeToFile() to close out the program so all the data is written to the file
        
        */
        
        
       //PGarage parkingGarage = new PGarage();
       
       //read in file and create new customers during runtime
       //Database database = new Database("Database.txt");
       
       //fill the parking spot in the garage that the customer picks
       
       /*
       for(int i = 0 ; i < database.getCustomers().size() ; i++){
           parkingGarage.fillParkingSpot(database.getParkingSpot(i));
       }
       */
       
       

            
            String checkInTime = "05-17-2021 06:35" ; String checkOutTime = "05-17-2021 17:36";
            CalculateCost timeCalculator = new CalculateCost();
            double totalCost = (timeCalculator.calculateTotalCost(checkInTime, checkOutTime));
            
            System.out.println("total cost of stay: " + totalCost);
       
       
       new start().setVisible(true);
       
       
       
    }
}
