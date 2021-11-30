package GUI;

public class Customer {
    
    private String NAME;
    private int ID;
    private String PARKING_SPOT;
    private boolean PAID;
    private String CHECK_IN;
    public boolean subscriber;
    
    
    /*
    Constructor for customer, takes in the line of data to split it up and put
    said data into variables
    Param: String of the line of data
    */
    public Customer(String Data){
        System.out.println("NEW CUSTOMER");
        String[] tokens = Data.split(",");
        this.ID = Integer.parseInt(tokens[0]);
        this.NAME = tokens[1] + " " + tokens[2];
        this.PARKING_SPOT = tokens[3];
        this.CHECK_IN = tokens[4];
        this.PAID = Boolean.getBoolean(tokens[5]);
        //System.out.println(Data);
    }
    
    /*
    Constructor which doesnt take in any data and is just a empty object
    DO NOT USE AT THE MOMENT (SPRINT 1)
    */
    public Customer(){
    }
    
    /*
    Change Paid variable to the opposite of the current state
    True would then be false;
    False would then be true;
    */
    public void changePAID(){
        if(PAID){
            PAID = true;
        }
        else{
            PAID = false;
        }
    }
    
    /*
    Change the check in Time/Date
    Param: String of the Time/Date
    */
    public void changeCheckIn(String _NewDate){
        CHECK_IN = _NewDate;
    }
    
    public String getNAME(){
        return NAME;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getParkingSpot(){
        return PARKING_SPOT;
    }
    
    public boolean getPAID(){
        return PAID;
    }
    
    public String getCheckIn(){
        return CHECK_IN;
    }
    
    
    /*
    To String method
    */
    public String toString(){
        String[] NAMES = NAME.split(" ");
        return ID + "," + NAMES[0] + "," + NAMES[1] + "," + PARKING_SPOT + "," + CHECK_IN + "," + PAID;
    }
}
