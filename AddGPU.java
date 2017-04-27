
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.xml.bind.DatatypeConverter.parseString;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lillie
 */
public class AddGPU extends javax.swing.JFrame {
    
    UserAccount currentUser;

    /**
     * 
     * 
     * Creates new form AddGPU
     */
    public AddGPU() {
        initComponents();
        this.setTitle("Add RAM");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
    }
    
    public AddGPU(java.awt.Frame parent, boolean modal, UserAccount user) {
        initComponents();    //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
        System.out.println(user);
    }
    
    AddGPU (UserAccount user) {
        initComponents();
        this.setTitle("Add GPU");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
        currentUser = user;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblMake = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblSeries = new javax.swing.JLabel();
        lblChipset = new javax.swing.JLabel();
        lblMemory = new javax.swing.JLabel();
        lblCoreclock = new javax.swing.JLabel();
        comboMake = new javax.swing.JComboBox<String>();
        txtFieldModel = new javax.swing.JTextField();
        txtFieldSeries = new javax.swing.JTextField();
        txtFieldChipset = new javax.swing.JTextField();
        txtFieldMemory = new javax.swing.JTextField();
        txtFieldcClock = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtFieldPrice = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("GPU");

        lblMake.setText("Make:");

        lblModel.setText("Model:");

        lblSeries.setText("Series:");

        lblChipset.setText("Chipset:");

        lblMemory.setText("Memory (GB):");

        lblCoreclock.setText("Core Clock (GHz):");

        comboMake.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtFieldSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldSeriesActionPerformed(evt);
            }
        });

        lblPrice.setText("Price (£):");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblChipset)
                            .addComponent(lblSeries)
                            .addComponent(lblModel)
                            .addComponent(lblMake)
                            .addComponent(lblMemory)
                            .addComponent(lblCoreclock)
                            .addComponent(lblPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboMake, 0, 80, Short.MAX_VALUE)
                            .addComponent(txtFieldModel)
                            .addComponent(txtFieldSeries)
                            .addComponent(txtFieldChipset)
                            .addComponent(txtFieldMemory)
                            .addComponent(txtFieldcClock)
                            .addComponent(txtFieldPrice))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 131, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMake)
                    .addComponent(comboMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(txtFieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeries)
                    .addComponent(txtFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChipset)
                    .addComponent(txtFieldChipset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemory)
                    .addComponent(txtFieldMemory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoreclock)
                    .addComponent(txtFieldcClock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldSeriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldSeriesActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // sets the users inputs when the save button is actioned
        
       GPU gpu = new GPU();

        String make = comboMake.getSelectedItem().toString();
        String model = txtFieldModel.getText();
        String pricetest = txtFieldPrice.getText();
        String series = txtFieldSeries.getText();
        String chipset = txtFieldChipset.getText();
        String memoryCheck = txtFieldMemory.getText();
        String coreClockTest = txtFieldcClock.getText();
        
        
       
        
        
        //validation - error message if wrong
        if(model.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, Please specify model", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if (pricetest.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, please enter price greater than 0", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if (series.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, please enter a Minimum RPM", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if (chipset.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, please enter a Maximum RPM", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if (memoryCheck.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, please enter a Maximum RPM", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }else if (coreClockTest.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, please enter a Maximum RPM", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }else{ //when input boxes are not empty
            double price = Double.parseDouble(pricetest);
             int memory = Integer.parseInt(memoryCheck);
        float coreclock = Float.parseFloat(coreClockTest);
            
            //setting specified makes
            gpu.setMake(make);
            gpu.setModel(model);
            gpu.setPrice(price);
            gpu.setSeries(series);
            gpu.setChipset(chipset);
            gpu.setMemory(memory);
            gpu.setCoreClock(coreclock);
            
            //checking if validation is successful
            boolean succesful = gpu.saveGPU();
            if(succesful){
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Component Created", "Added", JOptionPane.INFORMATION_MESSAGE);
            new AdminMenu().setVisible(true);
            }
        } 
        
        
                         
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // cancels the form and returns to admin menu when button is actioned
        this.setVisible(false);
        new AdminMenu().setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    
    //adds make types to the form combo box
     private void populateMakes() {

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

    }
    
    private void returnToMenu() {
        this.setVisible(false);
        if (currentUser.getType() == true) {        //User is admin
            new AdminMenu(currentUser).setVisible(true);
        } else {
            new MainMenu(currentUser).setVisible(true);
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
            java.util.logging.Logger.getLogger(AddGPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGPU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboMake;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblChipset;
    private javax.swing.JLabel lblCoreclock;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblMemory;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSeries;
    private javax.swing.JTextField txtFieldChipset;
    private javax.swing.JTextField txtFieldMemory;
    private javax.swing.JTextField txtFieldModel;
    private javax.swing.JTextField txtFieldPrice;
    private javax.swing.JTextField txtFieldSeries;
    private javax.swing.JTextField txtFieldcClock;
    // End of variables declaration//GEN-END:variables
}
