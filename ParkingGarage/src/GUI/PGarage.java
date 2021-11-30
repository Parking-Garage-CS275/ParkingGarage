package GUI;


import static java.lang.Integer.parseInt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Owner
 */
public class PGarage {
    

    //this array is meant to start empty
    public int[][] _parkingSpots = new int[5][10];
    
    
    public PGarage(){
        
        
    }
    
    public int[][] fillParkingSpot(String parkingSpot){
        //for every floor, if there is a car in a certain spot, then put a 1 in the filledSpots array in the same place as the car
        //add 1 to index spotNum-1 because there is no spot number 0
        if("A".equals(parkingSpot.substring(0,1))){
            int spotNum = parseInt(parkingSpot.substring(1,3));
            _parkingSpots[0][spotNum-1] = 1;
        }else if("B".equals(parkingSpot.substring(0,1))){
            int spotNum = parseInt(parkingSpot.substring(1,3));
            _parkingSpots[1][spotNum-1] = 1;
        }else if("C".equals(parkingSpot.substring(0,1))){
            int spotNum = parseInt(parkingSpot.substring(1,3));
            _parkingSpots[2][spotNum-1] = 1;
        }else if("D".equals(parkingSpot.substring(0,1))){
            int spotNum = parseInt(parkingSpot.substring(1,3));
            _parkingSpots[3][spotNum-1] = 1;
        }else if("E".equals(parkingSpot.substring(0,1))){
            int spotNum = parseInt(parkingSpot.substring(1,3));
            _parkingSpots[4][spotNum-1] = 1;
        }
        return _parkingSpots;
    }
    
    public int getCountFilledSpots(){
        int filledSpots = 0;
        
        for(int i = 0 ; i < _parkingSpots.length ; i++){
            for(int j = 0 ; j < _parkingSpots[i].length ; j++){
                if(_parkingSpots[i][j] == 1){
                    filledSpots ++;
                }
            }
        }
                    
        return filledSpots;
    }
    
    public boolean isSpotFilled(String parkingSpot){
        String floorLetter = parkingSpot.substring(0,1);
        int spotNum = parseInt(parkingSpot.substring(1,3));
        boolean isFilled = false;
        int floorIndex = -1;
        
        //convert floor letter to the proper index of the parking spot array
        if("A".equals(floorLetter)){
            floorIndex = 0;
        }else if("B".equals(floorLetter)){
            floorIndex = 1;
        }else if("C".equals(floorLetter)){
            floorIndex = 2;
        }else if("D".equals(floorLetter)){
            floorIndex = 3;
        }else if("E".equals(floorLetter)){
            floorIndex = 4;
        }
        
        if(_parkingSpots[floorIndex][spotNum -1] == 1){
            isFilled = true;
        }
        return isFilled;
    }
    
    public void showFilledSpots(){
        for(int i = 0 ; i <_parkingSpots.length ; i++){
            System.out.println("\n");
            for(int j = 0 ; j < _parkingSpots[i].length ; j++){
                System.out.print(_parkingSpots[i][j]);
            }
        }
        System.out.println("\n");
    }
    
   
}
