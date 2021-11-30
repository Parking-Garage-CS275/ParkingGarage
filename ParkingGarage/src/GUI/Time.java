package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; 

/**
 *
 * @author davidkratz
 */
public class Time {
    //member data here
    
    private int checkInDate;
    private int checkOutDate;
    private static double rate;
    
    
    
    //method(s) for calculating time spent in parking spot and how much customer owes
    public static double Duration(int checkInDate, int checkOutDate){
        
        //change to strings
        String checkInDateS =Integer.toString(checkInDate);
        String checkOutDateS =Integer.toString(checkOutDate);
        
        
        //array of months according to how many days
        ArrayList<Integer> months = new ArrayList<Integer>(12); // Create an ArrayList object
        months.add(31);
        months.add(28);
        months.add(31);
        months.add(30);
        months.add(31);
        months.add(30);
        months.add(31);
        months.add(31);
        months.add(30);
        months.add(31);
        months.add(31);
        months.add(31);
        
                 
            String hour = checkInDateS.substring(0,2);
            String minute = checkInDateS.substring(2,4);
            String day = checkInDateS.substring(4,6);
            String month = checkInDateS.substring(6,8);
            String year = checkInDateS.substring(8,12);
            
            String hour2 = checkOutDateS.substring(0,2);
            String minute2 = checkOutDateS.substring(2,4);
            String day2 = checkOutDateS.substring(4,6);
            String month2 = checkOutDateS.substring(6,8);
            String year2 = checkOutDateS.substring(8,12);
            
            
            //change to ints
            int ihour = Integer.parseInt(hour);
            int iminute = Integer.parseInt(minute);
            int iday = Integer.parseInt(day);
            int imonth = Integer.parseInt(month);
            int iyear = Integer.parseInt(year);
            
            int ihour2 = Integer.parseInt(hour2);
            int iminute2 = Integer.parseInt(minute2);
            int iday2 = Integer.parseInt(day2);
            int imonth2 = Integer.parseInt(month2);
            int iyear2 = Integer.parseInt(year2);
            
            
            //total minutes counter for arrival and departure
            
            
            int checkinCount = (iyear*365)+iday;   //gets it to day
            
            for (int i = 0; i < imonth; i++){
                
                checkinCount += months.get(i);
                
                
            }
            checkinCount = (checkinCount*24)+ihour;    //gets to hours
            checkinCount = (checkinCount*60)+iminute; //gets to minutes
            
            
            
            
            int checkoutCount = (iyear2*365)+iday2;   //gets it to days
            
            for (int i = 0; i < imonth2; i++){
                
                checkoutCount += months.get(i);
                
                
            }
            
            checkoutCount = (checkoutCount*24)+ihour2;  //gets to hours
            checkoutCount = (checkoutCount*60)+iminute2;    //gets to minutes
            
            
            int totalStay = checkoutCount - checkinCount;
            
            //System.out.println(totalStay + " minutes");
            
            
            //double RATE = 0.02; // 2 cents per minute at the parking garage
            double minutesStayed = totalStay;
            //double chargeAmount = (minutesStayed * RATE);
            
            //System.out.println("Total Charge for CUSTOMER: $" + String.format("%.2f",chargeAmount) + "    Minutes Stayed: " + totalStay);
        
            
        return minutesStayed;
        
        
    }
    

    
    public static double Pay(double minutesStayed, Customer customer){
        
        rate = .02;
        
        double payment = 0;
        
        
        if (customer.subscriber == true){
            
            rate = rate - (rate * .25);
            
            payment = rate * minutesStayed;
            
        }
        
        else{
            
            
            payment = rate * minutesStayed;
            
            
        }
        
        
        return payment;
        
        
    }
    
    
}
   
