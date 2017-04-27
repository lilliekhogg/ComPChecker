
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.xml.bind.DatatypeConverter.parseBoolean;
import static javax.xml.bind.DatatypeConverter.parseString;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lillie Hogg
 */
public class AddStorage extends javax.swing.JFrame {

    /**
     * Creates new form AddStora
     * @param parent parent form
     * @param modal modal 
     * @param user currentUser
     */
     public AddStorage(java.awt.Frame parent, boolean modal, UserAccount user) {
        initComponents();
        this.setTitle("Add Storage");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
        System.out.println(user);
    }
    /**
     * Creates new form addRAM
     */
    public AddStorage() {
        initComponents();
        this.setTitle("Add Storage");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
    }

    AddStorage(UserAccount currentUser) {
        initComponents();
        this.setTitle("Add Storage");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblMake = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        comboMake = new javax.swing.JComboBox();
        txtFieldModel = new javax.swing.JTextField();
        lblSeries = new javax.swing.JLabel();
        txtFieldSeries = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFieldSpeed = new javax.swing.JTextField();
        txtFieldCapacity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFieldPrice = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmBoxHHD = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Storage");

        lblMake.setText("Make:");

        lblModel.setText("Model:");

        comboMake.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSeries.setText("Series:");

        jLabel2.setText("HHD Type:");

        jLabel3.setText("Read Speed (MB/s)");

        jLabel4.setText("Capacity (GB/TB):");

        jLabel5.setText("Price (£):");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cmBoxHHD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMake)
                        .addComponent(lblModel)
                        .addComponent(lblSeries))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFieldCapacity)
                    .addComponent(comboMake, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFieldModel)
                    .addComponent(txtFieldSeries)
                    .addComponent(txtFieldSpeed)
                    .addComponent(txtFieldPrice)
                    .addComponent(cmBoxHHD, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(9, 9, 9))
                            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMake)
                    .addComponent(comboMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(txtFieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeries)
                    .addComponent(txtFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmBoxHHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFieldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // sets inputs to the form when the save button is actioned
        Storage storage = new Storage();
        String make = comboMake.getSelectedItem().toString();
        String model = txtFieldModel.getText();
        String series = txtFieldSeries.getText();
        String pricetest = txtFieldPrice.getText();
        String speedcheck = txtFieldSpeed.getText();
        String capacitytest = txtFieldCapacity.getText();
        String HHDtest = cmBoxHHD.getSelectedItem().toString();

        
        //checking for empty input fields
        if(model.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, Please specify model", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (pricetest.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter price greater than 0", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (series.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter the series", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (speedcheck.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, the speed of the storage", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (capacitytest.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter capacity in GB", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (HHDtest.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter the type of HHD", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else{ //when input boxes are not empty
            //parsing variables from strings to required values
            double price = Double.parseDouble(pricetest);
            int speed = Integer.parseInt(speedcheck);
            int capacity = Integer.parseInt(capacitytest);
            boolean HHD = Boolean.parseBoolean(HHDtest);
            
            //setting the specified fields
            storage.make = make;
            storage.model = model;
            storage.speed = speed;
            storage.capacityGB = capacity;
            storage.HHD = HHD;
            storage.series = series;
            storage.price = price;
            
            //components are added to the database if validation passes
            boolean validated = storage.saveStorage();
            if(validated){
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Component Created", "Storage Added", JOptionPane.INFORMATION_MESSAGE);
            new AdminMenu().setVisible(true);
            }
        
        
       }
        
     
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // cancels form and return to admin menu
         this.setVisible(false);
         new AdminMenu().setVisible(true);
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void populateMakes() {
        //method provides make types within combobox
        comboMake.removeAllItems();
        ResultSet rs;
        Make make = new Make();
        rs = make.getMakes();
        try {
            while (rs.next()) {
                String dbMake = rs.getString("Name");
                comboMake.addItem(dbMake);

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        cmBoxHHD.removeAllItems();
        ArrayList<String> hhd = new ArrayList<String>();
        hhd.add("SSD");
        hhd.add("Hybrid");
        hhd.add("7200RPM");

        for (int i = 0; i < hhd.size(); i++) {
            cmBoxHHD.addItem(hhd.get(i));
        }

    }
    
    
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
            java.util.logging.Logger.getLogger(AddStorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStorage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmBoxHHD;
    private javax.swing.JComboBox comboMake;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblSeries;
    private javax.swing.JTextField txtFieldCapacity;
    private javax.swing.JTextField txtFieldModel;
    private javax.swing.JTextField txtFieldPrice;
    private javax.swing.JTextField txtFieldSeries;
    private javax.swing.JTextField txtFieldSpeed;
    // End of variables declaration//GEN-END:variables
}
