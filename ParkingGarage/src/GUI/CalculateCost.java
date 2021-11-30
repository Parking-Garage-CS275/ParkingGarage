 package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Matthew Wallace
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateCost {
    // Function to print difference in
    // time start_date and end_date
    
    
    
    
    public double calculateTotalCost(String start_date,String end_date){
        int differenceInMin = 0;
        // SimpleDateFormat converts string to date object
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm");
  
        
        try {
  
            // parse method is used to parse the text from a string to produce the date
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
  
            //difference_In_Time is calculated in milliseconds
            long difference_In_Time = d2.getTime() - d1.getTime();
            
            //convert milliseconds to minutes 
            differenceInMin = (int)(difference_In_Time/60000);
            
            
            
      
            
        }
  
        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
        }
        double totalCost = differenceInMin * 0.02;
        
        return totalCost;
    }
    
    
}
