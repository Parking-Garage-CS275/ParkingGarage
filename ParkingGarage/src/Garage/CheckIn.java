package Garage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class CheckIn extends javax.swing.JFrame {
    
    public static Connect database(){
        Connect database = new Connect();
        database.createNewDatabase();
        database.createAccountTable();    
        database.createSpotsTable();
        database.createTakenSpotTable();
        database.selectAllSpots();
        return database;
    }
    
    
    // create 2D array. Rows wil be A-E, columns 1-9 (I DONT THINK WE ACTUALLY NEED THIS ANYMORE BECAUSE WE USE DATABASE)
    // if someone selects B3 then its [1][2] (i think)
    public static String [][] garage = new String[5][10];
    
    // create an arraylist for each floor that will be used for the combo box displays
    public static ArrayList<String> a = new ArrayList<String>();
    public static ArrayList<String> b = new ArrayList<String>();
    public static ArrayList<String> c = new ArrayList<String>();
    public static ArrayList<String> d = new ArrayList<String>();
    public static ArrayList<String> e = new ArrayList<String>();
    // arraylist holding the spots filled by vehicles for the combo box displays
    public static ArrayList<String> leave = new ArrayList<String>();
    
    public static String selectedValue = "";
    public static String floor;
    public static String spotNumeral;
    public static String takenSpot = "X";
    public static int counter = 0;
    // counters for each floor to display how many spots are available for each floor
    public static int counterA = 9;
    public static int counterB = 9;
    public static int counterC = 9;
    public static int counterD = 9;
    public static int counterE = 9;
    
    /**
     * Creates new form CheckIn
     */
    public CheckIn() {
        
        
        initComponents();
        // display amount of spots available for each floor
        
                
        // this fills the combo box displays, and counter is so that it only fills the arrays the first time
        if (counter == 0){
        for(int i = 0; i < 9; i++) {
            a.add("A" + String.valueOf(i + 1));
        }
        for(int i = 0; i < 9; i++) {
            b.add("B" + String.valueOf(i + 1));
        }
        for(int i = 0; i < 9; i++) {
            c.add("C" + String.valueOf(i + 1));
        }
        for(int i = 0; i < 9; i++) {
            d.add("D" + String.valueOf(i + 1));
        }
        for(int i = 0; i < 9; i++) {
            e.add("E" + String.valueOf(i + 1));
        } 
        counter++;
        }
        
        Connect db = new Connect();
        ArrayList<String> takenSpots = db.selectTakenSpots();
        //System.out.println("Size: " + takenSpots.size());
        System.out.println(takenSpots.toString());
        for(int i = 0; i < takenSpots.size(); i++){
            String floorLetter = takenSpots.get(i).substring(0, 1);
            String spotNum = takenSpots.get(i).substring(1);
            if(floorLetter.equals("A")){
                a.remove(takenSpots.get(i));
                counterA--;
            }
            else if(floorLetter.equals("B")){
                b.remove(takenSpots.get(i));
                counterB--;
            }
            else if(floorLetter.equals("C")){
                c.remove(takenSpots.get(i));
                counterC--;
            }
            else if(floorLetter.equals("D")){
                d.remove(takenSpots.get(i));
                counterD--;
            }
            else if(floorLetter.equals("E")){
                e.remove(takenSpots.get(i));
                counterE--;
            }
        }
        //TODO: UNAVIABLE SPOTS COMBO BOX
        
        
        lblFloor1Spots.setText(String.valueOf(counterA));
        lblFloor2Spots.setText(String.valueOf(counterB));
        lblFloor3Spots.setText(String.valueOf(counterC));
        lblFloor4Spots.setText(String.valueOf(counterD));
        lblFloor5Spots.setText(String.valueOf(counterE));
        
        
        // display the spots in the combo boxes
        combSpot1.setModel(new javax.swing.DefaultComboBoxModel(a.toArray()));
        combSpot2.setModel(new javax.swing.DefaultComboBoxModel(b.toArray()));
        combSpot3.setModel(new javax.swing.DefaultComboBoxModel(c.toArray()));
        combSpot5.setModel(new javax.swing.DefaultComboBoxModel(d.toArray()));
        combSpot4.setModel(new javax.swing.DefaultComboBoxModel(e.toArray()));
        
        // this is the 2d array I created that I think we won't need because the database replaces it
        for (int i = 0; i < 5; i++){
            for (int k = 0; k <9; k++){
                garage[i][k] = "-";
            }
        }
        // this is the combo box for the unavailable spots
        //combUnavailable.setModel(new javax.swing.DefaultComboBoxModel(leave.toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblSpot = new javax.swing.JLabel();
        combSpot4 = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        btnCheckIn = new javax.swing.JButton();
        combSpot1 = new javax.swing.JComboBox<>();
        combSpot2 = new javax.swing.JComboBox<>();
        combSpot3 = new javax.swing.JComboBox<>();
        combSpot5 = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblSelectedSpot = new javax.swing.JLabel();
        combUnavailable = new javax.swing.JComboBox<>();
        lblFloor1Spots = new javax.swing.JLabel();
        lblFloor2Spots = new javax.swing.JLabel();
        lblFloor3Spots = new javax.swing.JLabel();
        lblFloor4Spots = new javax.swing.JLabel();
        lblFloor5Spots = new javax.swing.JLabel();
        lblUnavailable = new javax.swing.JLabel();
        lblAvailable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDate.setText("DATE:");

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        lblSpot.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSpot.setText("SPOT:");

        combSpot4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combSpot4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combSpot4ActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBack.setText("EXIT");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCheckIn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCheckIn.setText("CHECK IN");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        combSpot1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combSpot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combSpot1ActionPerformed(evt);
            }
        });

        combSpot2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combSpot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combSpot2ActionPerformed(evt);
            }
        });

        combSpot3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combSpot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combSpot3ActionPerformed(evt);
            }
        });

        combSpot5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combSpot5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combSpot5ActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblName.setText("Name:");

        combUnavailable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combUnavailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combUnavailableActionPerformed(evt);
            }
        });

        lblUnavailable.setText("Unavailable spots:");

        lblAvailable.setText("Available spots per floor:");

        jLabel1.setText("Selected Spot:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblSpot))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDate)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSelectedSpot, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAvailable)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUnavailable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combUnavailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFloor1Spots)
                                    .addComponent(combSpot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFloor2Spots)
                                    .addComponent(combSpot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFloor3Spots)
                                    .addComponent(combSpot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFloor4Spots)
                                        .addGap(92, 92, 92)
                                        .addComponent(lblFloor5Spots))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combSpot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(combSpot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(23, 23, 23)
                        .addComponent(btnCheckIn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvailable)
                    .addComponent(lblFloor1Spots)
                    .addComponent(lblFloor2Spots)
                    .addComponent(lblFloor3Spots)
                    .addComponent(lblFloor4Spots)
                    .addComponent(lblFloor5Spots))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(combSpot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combSpot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combSpot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combSpot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combSpot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblSpot, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUnavailable)
                            .addComponent(combUnavailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelectedSpot, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(btnCheckIn))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void combSpot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combSpot4ActionPerformed
        // TODO add your handling code here:
        // set the variable selected value to whatever value the customer most recently picked from the combo boxes
        selectedValue = combSpot4.getSelectedItem().toString();
        lblSelectedSpot.setText(selectedValue);
    }//GEN-LAST:event_combSpot4ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
        //new start().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        // get the selected spot
        selectedValue = lblSelectedSpot.getText();
        // split the spot into the floor and number, then fill the spot in the 2D array
        floor = selectedValue.substring(0, 1);
        spotNumeral = selectedValue.substring(1);
        
        Connect db = database();
        
        String name = txtName.getText();
        String fname = name.substring(0, name.indexOf(' '));
        String lname = name.substring(name.indexOf(' '));
        //TODO: ACCOUNTS MULITPLYING 
        String AccountID = "";
        if(db.selectAccountID(fname, lname).equals("0")){
            db.insertAccount(fname, lname, 0);
            AccountID = db.selectAccountID(fname, lname);
        }
        else{
            db.insertAccount(fname, lname, 0);
            AccountID = db.selectAccountID(fname, lname);
        }
        String date = txtDate.getText();
        db.updateCheckInTime(selectedValue, date);
        db.insertTakenSpot(db.selectAccountID(fname, lname),db.selectSpotID(selectedValue));
        //jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(e.toArray()));
        
        // floorInt and spotInt are so that we can remove the chosen spot from the display combob box
        // basically it converts "A1" or "B3" into "01" or "13"
        int floorInt = 0;
        int spotInt = 0;
            if (null != floor) 
        switch (floor) {
            case "A":
                floorInt = 0;
                break;
            case "B":
                floorInt = 1;
                break;
            case "C":
                floorInt = 2;
                break;
            case "D":
                floorInt = 3;
                break;
            case "E":
                floorInt = 4;
                break;
            default:
                break;
        }
            if (null != spotNumeral) 
        switch (spotNumeral) {
            case "0":
                spotInt = 0;
                break;
            case "1":
                spotInt = 1;
                break;
            case "2":
                spotInt = 2;
                break;
            case "3":
                spotInt = 3;
                break;
            case "4":
                spotInt = 4;
                break;
            case "5":
                spotInt = 5;
                break;
            case "6":
                spotInt = 6;
                break;
            case "7":
                spotInt = 7;
                break;
            case "8":
                spotInt = 8;
                break;
            case "9":
                spotInt = 9;
                break;
            default:
                break;
        }
            
        // put a car into the 2d array
        //fillParkingSpot(selectedValue);
        garage[floorInt][spotInt] = takenSpot;
        // remove the spot from the array/combo box
        //switch (floorInt) {
        // if floor is A, find the spot chosen and remove it from combo box, etc for floors below
            if (floorInt == 0){
                Iterator itr = a.iterator();
                    while (itr.hasNext()) {
                        String x = (String)itr.next();
                        if (x.equals(selectedValue)){
                            itr.remove();
                            counterA--;
                            lblFloor1Spots.setText(String.valueOf(counterA));
                        }
                    }       combSpot1.setModel(new javax.swing.DefaultComboBoxModel(a.toArray()));
                }
            else if (floorInt == 1){
                Iterator itr = b.iterator();
                    while (itr.hasNext()) {
                        String x = (String)itr.next();
                        if (x.equals(selectedValue)){
                            itr.remove();
                            counterB--;
                            lblFloor2Spots.setText(String.valueOf(counterB));
                        }
                    }       combSpot2.setModel(new javax.swing.DefaultComboBoxModel(b.toArray()));
                }
            else if (floorInt == 2){
                Iterator itr = c.iterator();
                    while (itr.hasNext()) {
                        String x = (String)itr.next();
                        if (x.equals(selectedValue)){
                            itr.remove();
                            counterC--;
                            lblFloor3Spots.setText(String.valueOf(counterC));
                        }
                    }       combSpot3.setModel(new javax.swing.DefaultComboBoxModel(c.toArray()));
                }
            else if (floorInt == 3){
                Iterator itr = d.iterator();
                    while (itr.hasNext()) {
                        String x = (String)itr.next();
                        if (x.equals(selectedValue)){
                            itr.remove();
                            counterD--;
                            lblFloor4Spots.setText(String.valueOf(counterD));
                        }
                    }       combSpot5.setModel(new javax.swing.DefaultComboBoxModel(d.toArray()));
                }
            else if (floorInt == 4){
                Iterator itr = e.iterator();
                    while (itr.hasNext()) {
                        String x = (String)itr.next();
                        if (x.equals(selectedValue)){
                            itr.remove();
                            counterE--;
                            lblFloor5Spots.setText(String.valueOf(counterE));
                        }
                    }       combSpot4.setModel(new javax.swing.DefaultComboBoxModel(e.toArray()));
                }
        leave.add(selectedValue);
        Collections.sort(leave);  
        lblSelectedSpot.setText(selectedValue);
        
        combUnavailable.setModel(new javax.swing.DefaultComboBoxModel(leave.toArray()));
        //**ADD CODE FOR RECEIVING THE CHECK IN TIME/DATE**
        
        txtDate.setText("");
        JOptionPane.showMessageDialog(this, "You have been checked in, please park in spot " + lblSelectedSpot.getText() + ".");
        //new start().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void combSpot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combSpot1ActionPerformed
        // TODO add your handling code here:
        // set the variable selected value to whatever value the customer most recently picked from the combo boxes
        selectedValue = combSpot1.getSelectedItem().toString();
        lblSelectedSpot.setText(selectedValue);
    }//GEN-LAST:event_combSpot1ActionPerformed

    private void combSpot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combSpot2ActionPerformed
        // TODO add your handling code here:
        // set the variable selected value to whatever value the customer most recently picked from the combo boxes
        selectedValue = combSpot2.getSelectedItem().toString();
        lblSelectedSpot.setText(selectedValue);
    }//GEN-LAST:event_combSpot2ActionPerformed

    private void combSpot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combSpot3ActionPerformed
        // TODO add your handling code here:
        // set the variable selected value to whatever value the customer most recently picked from the combo boxes
        selectedValue = combSpot3.getSelectedItem().toString();
        lblSelectedSpot.setText(selectedValue);
    }//GEN-LAST:event_combSpot3ActionPerformed

    private void combSpot5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combSpot5ActionPerformed
        // TODO add your handling code here:
        // set the variable selected value to whatever value the customer most recently picked from the combo boxes
        selectedValue = combSpot5.getSelectedItem().toString();
        lblSelectedSpot.setText(selectedValue);
    }//GEN-LAST:event_combSpot5ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void combUnavailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combUnavailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combUnavailableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JComboBox<String> combSpot1;
    private javax.swing.JComboBox<String> combSpot2;
    private javax.swing.JComboBox<String> combSpot3;
    private javax.swing.JComboBox<String> combSpot4;
    private javax.swing.JComboBox<String> combSpot5;
    private javax.swing.JComboBox<String> combUnavailable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAvailable;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFloor1Spots;
    private javax.swing.JLabel lblFloor2Spots;
    private javax.swing.JLabel lblFloor3Spots;
    private javax.swing.JLabel lblFloor4Spots;
    private javax.swing.JLabel lblFloor5Spots;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSelectedSpot;
    private javax.swing.JLabel lblSpot;
    private javax.swing.JLabel lblUnavailable;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
