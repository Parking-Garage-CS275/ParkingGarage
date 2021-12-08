package Garage;


import static Garage.CheckIn.database;
import java.util.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.lang.*;


public class CheckOut extends javax.swing.JFrame {
    
    public static Connect database(){
        Connect database = new Connect();
        database.createNewDatabase();
        database.createAccountTable();    
        database.createSpotsTable();
        database.createTakenSpotTable();
        database.selectAllSpots();
        return database;
    }
    
    public double totalCost = 0;

    String date1 = "";
    String date2 = "";
    final DecimalFormat df = new DecimalFormat("0.00");
    

    /**
     * Creates new form CheckOut
     */ 
    public CheckOut() {
        initComponents();
   
        
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
        lblSubscriber = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        lblTotalCost = new javax.swing.JLabel();
        txtPayment = new javax.swing.JTextField();
        lblPay = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        radYes = new javax.swing.JRadioButton();
        radNo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lblDiscountCost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDate.setText("Date & Time:");

        lblSubscriber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSubscriber.setText("Are you a subscriber?");

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblName.setText("Name:");

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblPay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPay.setText("Pay Here:");

        btnPay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        radYes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radYes.setText("Yes");
        radYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radYesActionPerformed(evt);
            }
        });

        radNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radNo.setText("No");
        radNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("(dd-MM-yyyy HH:mm)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSubscriber)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radYes)
                            .addComponent(radNo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDate)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(btnBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDiscountCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblPay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(518, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)))
                .addGap(37, 37, 37)
                .addComponent(lblTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblSubscriber)
                        .addGap(18, 18, 18)
                        .addComponent(lblDiscountCost, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPay)
                            .addComponent(txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPay)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(radYes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radNo)))
                .addContainerGap(356, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        dispose();
        new start().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
        int D1 =  Integer.parseInt(txtDate.getText());
        
        
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        //String date1 = ""; String date2 = "";
  
        if(txtDate.getText().equals("") || txtName.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter your information to check out");
        }else{
            Connect db = database();
            String name = txtName.getText(); // HERE'S THE NAME TO CROSS CHECK WITH THE DATABASE
            String fname = name.substring(0, name.indexOf(' '));
            String lname = name.substring(name.indexOf(' '));
            String spotnum = db.selectTakenSpotsSpotNum(db.selectAccountID(fname, lname));
            System.out.println(spotnum);
            date1 = db.selectCheckInTime(spotnum);//PUT CALL FOR CHECKIN DATE HERE
            date2 = txtDate.getText();
            db.deleteTakenSpots(spotnum);
            
            CalculateCost costCalculator = new CalculateCost();
            
            totalCost = costCalculator.calculateTotalCost(date1, date2);
            
            
            lblTotalCost.setText("$" + df.format(totalCost));
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        
        
        String totalCostStr = String.valueOf(totalCost);
        
        
    
        if(txtPayment.getText().equals(totalCostStr)){
            txtPayment.setText("");
            JOptionPane.showMessageDialog(this,"Thank you for staying at our parking garage, come again soon!");
            //check in date, checkout date, rate, total charged
            JOptionPane.showMessageDialog(this, "Check In Date: " + date1 + "\n"
                                                + "Check Out Date: " + date2 + "\n" 
                                                + "Rate: $0.02 per minute \n" 
                                                + "Total Charged: $" + totalCost);
            dispose();
            new start().setVisible(true);
            
        }else{
            txtPayment.setText("");
            JOptionPane.showMessageDialog(this,"Please enter the proper amount for payment");
        }
        
    }//GEN-LAST:event_btnPayActionPerformed

    private void radYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radYesActionPerformed
        JOptionPane.showMessageDialog(this,"Please enjoy 10% off your cost for today's stay");
        totalCost *= 0.9;

        totalCost = Math.round(totalCost*100.0)/100.0;
        lblDiscountCost.setText("Discounted Price: $" + df.format(totalCost));

    }//GEN-LAST:event_radYesActionPerformed

    private void radNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNoActionPerformed
        JOptionPane.showMessageDialog(this,"Thank you for letting us know, we encourage you to subscribe during your next stay");
    }//GEN-LAST:event_radNoActionPerformed

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
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDiscountCost;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPay;
    private javax.swing.JLabel lblSubscriber;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JRadioButton radNo;
    private javax.swing.JRadioButton radYes;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPayment;
    // End of variables declaration//GEN-END:variables
}
