package Garage;

public class Main {
    
    public static void main(String[] args){
        Connect database = new Connect();
        database.dropTable("TAKENSPOT");
        new start().setVisible(true);
        database.selectAllAccounts();
        database.selectAllSpots();
        database.selectAllTakenSpots();
    }
}
