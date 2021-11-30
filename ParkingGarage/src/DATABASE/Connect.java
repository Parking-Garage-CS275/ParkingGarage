import java.sql.*;


public class Connect {
    /**
     * Sets up the connection to the database file to execute SQL code
     * 
     * @return SQL Connection
     */
    private Connection connect() {
        String url = "jdbc:sqlite:main.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch(SQLException e){
            System.out.println("Connection ERROR: " + e.getMessage());
        }
        return conn;
    }
    
    /**
     * Creates the database, need this to have the database to work,
     * should be the first method you call
     */
    public void createNewDatabase(){
        try(Connection conn = this.connect()){
            if(conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
                //System.out.println("A new database has been created");
            }
        } catch(SQLException e){
            System.out.println("Database: " + e.getMessage());
        }
    }
    
    /**
     * Creates the SQL code for creating the ACCOUNTS table
     * Then executes the code so the table is created
     * 
     * This table holds the FirstName, LastName, Username, Password, and if the
     * account is a subscriber or not. Denoted as a 1 when it is a subscriber
     * and 0 when it is not.
     */
    public void createAccountTable(){
        String sql = "CREATE TABLE IF NOT EXISTS ACCOUNTS (\n"
                + "     ID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                + "     FirstName TEXT NOT NULL,\n"
                + "     LastName TEXT NOT NULL,\n"
                + "     Username TEXT,\n"
                + "     Password TEXT,\n"
                + "     Subscriber INTEGER NOT NULL\n"
                + ");";
        try(Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch(SQLException e){
            System.out.println("Accounts Table: " + e.getMessage());
        }
    }
        
    /**
     * This method will insert a new account into the ACCOUNTS table using, two
     * parameters: the person's name and if they are a subscriber or not.
     * 
     * @param firstname String, the person's first name
     * @param lastname String, the person's last name
     * @param subscriber int, if they are a subscriber or not (default = 0 or not subscriber)
     */
    public void insertAccount(String firstname, String lastname, int subscriber){
        String sql = "INSERT INTO ACCOUNTS(FirstName, LastName, Subscriber) VALUES (?,?,?)";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            if (subscriber != 0){
                pstmt.setInt(3, subscriber);
            }
            else{
                pstmt.setInt(3, 0);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * This method will insert a new account into the ACCOUNTS table using, four
     * parameters: the person's name, their username, password, and if they are 
     * a subscriber or not.
     * 
     * @param firstname String, the person's first name
     * @param lastname String, the person's last name
     * @param username String, the username of the account
     * @param password String, the password of the account
     * @param subscriber int, if they are a subscriber or not (default = 0 or not subscriber)
     */
    public void insertAccount(String firstname, String lastname, String username, String password, int subscriber){
        String sql = "INSERT INTO ACCOUNTS(FirstName, LastName, Username, Password, Subscriber) VALUES (?,?,?,?,?)";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            if (subscriber != 0){
                pstmt.setInt(5, subscriber);
            }
            else{
                pstmt.setInt(5, 0);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *  Uses a Select query to print out the table contents
     */
    public void selectAllAccounts(){
        String sql = "SELECT * FROM ACCOUNTS";
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            // loop through the result set
            System.out.println("(ID, Name, Username, Password, Subscriber)");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("FirstName") + " " + rs.getString("LastName") + "\t" +
                                   rs.getString("Username") + "\t" +
                                   rs.getString("Password") + "\t" +
                                   rs.getInt("Subscriber"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Uses a select query and where statement to find the id of the account 
     * you want to look for. Input the firstname and lastname and you will return
     * the id as a string.
     * 
     * @param firstname String, account you want to find's first name
     * @param lastname String, account you want to find's last name
     * @return String that is the account's ID number
     */
    public String selectAccountID(String firstname, String lastname){
        String ID = "";
        String sql = "SELECT ID FROM ACCOUNTS WHERE FirstName = ? AND LastName = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            ResultSet rs = pstmt.executeQuery();
            ID = Integer.toString(rs.getInt("id"));
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ID;
    }
    
    /**
     * Helper method to get the data for determining whether or not the account
     * is a subscriber or not.
     * 
     * @param firstname String, the account member's first name
     * @param lastname String, the account member's last name
     * @return the subscriber value, either 0 or 1. If -1 there has been an error
     */
    public int selectAccountSubscriber(String firstname, String lastname){
        int Subscriber = -1;
        String sql = "SELECT Subscriber FROM ACCOUNTS WHERE FirstName = ? AND LastName = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            ResultSet rs = pstmt.executeQuery();
            Subscriber = rs.getInt("Subscriber");
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Subscriber;
    }
    /**
     * Helper method to get the data for determining whether or not the account
     * is a subscriber or not.
     * 
     * @param AccountID String, the account member's ID
     * @return the subscriber value, either 0 or 1. If -1 there has been an error
     */
    public int selectAccountSubscriber(String AccountID){
        int Subscriber = -1;
        String sql = "SELECT Subscriber FROM ACCOUNTS WHERE AccountID = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, AccountID);
            ResultSet rs = pstmt.executeQuery();
            Subscriber = rs.getInt("Subscriber");
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Subscriber;
    }
    
    /**
     * Returns the Username in a string form using the input of the account 
     * member's name
     * 
     * @param firstname String, the account member's first name
     * @param lastname String, the account member's last name
     * @return String of the Account Username
     */
    public String selectAccountUsername(String firstname, String lastname){
        String Username = "";
        String sql = "SELECT Username FROM ACCOUNTS WHERE FirstName = ? AND LastName = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            ResultSet rs = pstmt.executeQuery();
            Username = rs.getString("Username");
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Username;
    }
    
    /**
     * Returns the Username in a string form using the input of the account 
     * member's name
     * 
     * @param AccountID String, the account member's ID
     * @return String of the Account Username
     */
    public String selectAccountUsername(String AccountID){
        String Username = "";
        String sql = "SELECT Username FROM ACCOUNTS WHERE AccountID = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, AccountID);
            ResultSet rs = pstmt.executeQuery();
            Username = rs.getString("Username");
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Username;
    }
    
    /**
     * Returns the Password in a string form using the input of the account 
     * member's name
     * 
     * @param firstname String, the account member's first name
     * @param lastname String, the account member's last name
     * @return String of the Account Password
     */
    public String selectAccountPassword(String firstname, String lastname){
        String Password = "";
        String sql = "SELECT Password FROM ACCOUNTS WHERE FirstName = ? AND LastName = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            ResultSet rs = pstmt.executeQuery();
            Password = rs.getString("Password");
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Password;
    }
    
    /**
     * Returns the Password in a string form using the input of the account 
     * member's name
     * 
     * @param AccountID String, the account member's ID
     * @return String of the Account Password
     */
    public String selectAccountPassword(String AccountID){
        String Password = "";
        String sql = "SELECT Password FROM ACCOUNTS WHERE AccountID = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, AccountID);
            ResultSet rs = pstmt.executeQuery();
            Password = rs.getString("Password");
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Password;
    }
    
    /**
     * Updates whether the account is a subscriber or not, it will change the 
     * subscriber value from a (1 to 0) or (0 to 1).
     * 
     * @param firstname String, account member's first name
     * @param lastname  String, account member's last name
     */
    public void updateSubscriber(String firstname, String lastname){
        int Subscriber = this.selectAccountSubscriber(firstname, lastname);
        String sql = "UPDATE ACCOUNTS SET Subscriber = ? WHERE id = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            if (Subscriber == 0){
                pstmt.setInt(1, 1);
            }
            else {
                pstmt.setInt(1, 0);
            }
            pstmt.setString(2, this.selectAccountID(firstname, lastname));
            pstmt.executeUpdate(sql);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Updates whether the account is a subscriber or not, it will change the 
     * subscriber value from a (1 to 0) or (0 to 1).
     * 
     * @param AccountID String, account member's ID
     */
    public void updateSubscriber(String AccountID){
        int Subscriber = this.selectAccountSubscriber(AccountID);
        String sql = "UPDATE ACCOUNTS SET Subscriber = ? WHERE id = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            if (Subscriber == 0){
                pstmt.setInt(1, 1);
            }
            else {
                pstmt.setInt(1, 0);
            }
            pstmt.setString(2, AccountID);
            pstmt.executeUpdate(sql);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Updates the Account's username using the update SQL statement
     * 
     * @param firstname String, Account's first name
     * @param lastname String, Account's last name
     * @param Username String, New username for the account
     */
    public void updateUsername(String firstname, String lastname, String Username){
        String sql = "UPDATE ACCOUNTS SET Username = ? WHERE id = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, Username);
            pstmt.setString(2, this.selectAccountID(firstname, lastname));
            pstmt.executeUpdate(sql);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Updates the Account's username using the update SQL statement
     * 
     * @param AccountID String, Account's ID
     * @param Username String, New username for the account
     */
    public void updateUsername(String AccountID, String Username){
        String sql = "UPDATE ACCOUNTS SET Username = ? WHERE id = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, Username);
            pstmt.setString(2, AccountID);
            pstmt.executeUpdate(sql);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Updates the Account's password using the update SQL statement
     * 
     * @param firstname String, Account's first name
     * @param lastname String, Account's last name
     * @param Password String, New password for the account
     */
    public void updatePassword(String firstname, String lastname, String Password){
        String sql = "UPDATE ACCOUNTS SET Password = ? WHERE id = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, Password);
            pstmt.setString(2, this.selectAccountID(firstname, lastname));
            pstmt.executeUpdate(sql);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Updates the Account's password using the update SQL statement
     * 
     * @param AccountID String, Account's ID
     * @param Password String, New password for the account
     */
    public void updatePassword(String AccountID, String Password){
        String sql = "UPDATE ACCOUNTS SET Password = ? WHERE id = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, Password);
            pstmt.setString(2, AccountID);
            pstmt.executeUpdate(sql);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Creates the SQL code for creating the SPOTS table
     * Then executes the code so the table is created
     * 
     * This table holds the spot number and check in time if available 
     */
    public void createSpotsTable(){
        String sql = "CREATE TABLE IF NOT EXISTS SPOTS (\n"
                + "     ID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                + "     SpotNumber TEXT, \n"
                + "     CheckInTime TEXT\n"
                + ");";
        try(Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch(SQLException e){
            System.out.println("Spots Table: " + e.getMessage());
        }
    }
    
    /**
     * This will insert a new record into the SPOTS table using one parameter:
     * the spot number.
     * 
     * This method should be used to set up the parking garage one time and then
     * never used again!!
     * 
     * @param SpotNumber String, the name of the spot of the garage
     */
    public void insertSpot(String SpotNumber){
        String sql = "INSERT INTO SPOTS(SpotNumber) VALUES (?)";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, SpotNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *  Uses a Select query to print out the table contents
     */
    public void selectAllSpots(){
        String sql = "SELECT * FROM SPOTS";
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            // loop through the result set
            System.out.println("(ID, SpotNumber, CheckInTime)");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("SpotNumber") + "\t" +
                                   rs.getString("CheckInTime"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * You input the spot name you want to find and it will return the spotID as
     * a string
     * 
     * @param spotNum String, the name of the spot you want to find
     * @return String, the SpotID
     */
    public String selectSpotID(String spotNum){
        String ID = "";
        String sql = "SELECT ID FROM ACCOUNTS WHERE SpotNumber = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, spotNum);
            ResultSet rs = pstmt.executeQuery();
            ID = Integer.toString(rs.getInt("id"));
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ID;
    }
    
    /**
     * Input in the spot name and it will return the check in time for that 
     * spot in the form of a string.
     * 
     * @param spotNum String, the name of the spot
     * @return String, the CheckInTime
     */
    public String selectCheckInTime(String spotNum){
        String CheckInTime = "";
        String sql = "SELECT CheckInTime FROM ACCOUNTS WHERE SpotNumber = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, spotNum);
            ResultSet rs = pstmt.executeQuery();
            CheckInTime = rs.getString("CheckInTime");
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return CheckInTime;
    }
    
    /**
     * Updating the check in time for the spot that you specified.
     * 
     * @param spotNum String, the name of the spot
     * @param CheckInTime String, the time that the account checked in at.
     */
    public void updateCheckInTime(String spotNum, String CheckInTime){
        String sql = "UPDATE ACCOUNTS SET CheckInTime = ? WHERE spotNum = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, CheckInTime);
            pstmt.setString(2, spotNum);
            pstmt.executeUpdate(sql);
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Creates the SQL code for creating the TAKENSPOTS table
     * Then executes the code so the table is created
     * 
     * This table holds the spotID and AccountID when a spot is taken up by
     * an account
     */
    public void createTakenSpotTable(){
        String sql = "CREATE TABLE IF NOT EXISTS TAKENSPOTS (\n"
                + "     ID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                + "     SpotID TEXT NOT NULL,\n"
                + "     AccountID TEXT NOT NULL,\n"
                + "     FOREIGN KEY (SpotID) REFERENCES SPOT(ID),\n"
                + "     FOREIGN KEY (AccountID) REFERENCES ACCOUNT(ID)\n"
                + ");";
        try(Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch(SQLException e){
            System.out.println("Taken Table: " + e.getMessage());
        }
    }
    
    /**
     * This will insert in a new record into the TAKENSPOTS table, using the 
     * spotID from the SPOTS table and accountID from the ACCOUNTS table
     * 
     * @param SpotID String, SpotID found from the SPOTS table - use the selectSpotID method
     * @param AccountID String, AccountID found from the ACCOUNTS table - use the selectAccountID method
     */
    public void insertTakenSpot(String SpotID, String AccountID){
        String sql = "INSERT INTO TAKENSPOTS(SpotID,AccountID) VALUES (?,?)";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, SpotID);
            pstmt.setString(2, AccountID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *  Uses a Select query to print out the table contents
     */
    public void selectAllTakenSpots(){
        String sql = "SELECT TAKENSPOTS.id, SpotId, SpotNumber, AccountID, FirstName, LastName, Subscriber FROM TAKENSPOTS INNER JOIN SPOTS ON SPOTS.ID = TAKENSPOTS.SpotID INNER JOIN ACCOUNTS ON ACCOUNTS.ID = TAKENSPOTS.AccountID";
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            // loop through the result set
            System.out.println("(ID, SpotID, SpotNumber, AccountID, Name, Subscriber)");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("SpotID") + "\t" +
                                   rs.getString("SpotNumber") + "\t" +
                                   rs.getString("AccountID") + "\t" + 
                                   rs.getString("FirstName") + " " + rs.getString("LastName") + "\t" + 
                                   rs.getInt("Subscriber"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Inputs the spot name, returns a string of the ID you wanted from the 
     * takenSpots table
     * 
     * @param SpotNum String, the name of the spot
     * @return String, the ID from the TakenSpots table
     */
    public String selectTakenSpotID(String SpotNum){
        String TakenSpotID = "";
        String SpotID = this.selectSpotID(SpotNum);
        String sql = "SELECT id FROM TAKENSPOTS WHERE SpotID = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, SpotID);
            ResultSet rs = pstmt.executeQuery();
            TakenSpotID = Integer.toString(rs.getInt("id"));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return TakenSpotID;
    }
    
    /**
     * Inputs the spot name, return a string of the AccountID you were searching
     * for from the takenSpots table
     * 
     * @param SpotNum String, the name of the spot
     * @return String, the AccountID from the TakenSpots table
     */
    public String selectTakenSpotsAccountID(String SpotNum){
        String AccountID = "";
        String SpotID = this.selectSpotID(SpotNum);
        String sql = "SELECT AccountID FROM TAKENSPOTS WHERE SpotID = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, SpotID);
            ResultSet rs = pstmt.executeQuery();
            AccountID = Integer.toString(rs.getInt("AccountID"));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return AccountID;
    }
    
    /**
     * Inputs the spot name and then deletes that corresponding element from the
     * table. 
     * USE THIS AFTER CHECKING A SPOT OUT SO THAT IT IS FREE TO BE TAKEN AGAIN!
     * 
     * @param SpotNum the name of the spot you want to delete
     */
    public void deleteTakenSpots(String SpotNum){
        String id = selectTakenSpotID(SpotNum);
        String sql = "DELETE FROM TAKENSPOTS WHERE id = ?";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Takes in a string, makes a SQL query to drop the table you inputted if
     * it exists in the database.
     * 
     * @param tableName String, name of the table
     */
    public void dropTable(String tableName){
        String sql = "DROP TABLE IF EXISTS " + tableName;
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    public static void main(String[] args) {
        //connect();
        Connect db = new Connect();
        
        db.dropTable("ACCOUNTS");
        db.dropTable("SPOTS");
        db.dropTable("TAKENSPOTS");
        
        db.createNewDatabase();
        db.createAccountTable();
        db.createSpotsTable();
        db.createTakenSpotTable();
        
        db.insertAccount("Henry", "Wilt", 0);
        db.insertAccount("Steve", "Wilkins", 1);
        db.insertAccount("Dylan", "Simms", "username", "password", 1);
        
        db.selectAllAccounts();
        
        for(int i = 1; i <= 10; i++){
            db.insertSpot("A" + i);
        }
        db.selectAllSpots();
        
        db.insertTakenSpot("1", "2");
        db.insertTakenSpot("5", "1");
        
        db.selectAllTakenSpots();
        
        System.out.println();
        
        System.out.println(db.selectAccountID("Henry", "Wilt"));
    }
    
    
}
