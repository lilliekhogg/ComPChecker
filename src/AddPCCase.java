
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lillie
 */
public class AddPCCase extends javax.swing.JFrame {
    
    UserAccount currentUser;

    /**
     * Creates new form PCCases
     * @param parent parentform 
     * @param model model
     */
     public AddPCCase(java.awt.Frame parent, boolean modal) {
        initComponents();
        this.setTitle("Add PCCase");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
    }

    public AddPCCase() {

        initComponents();
        populateMakes();
        this.setTitle("Add PCCase");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
    }

    AddPCCase(UserAccount user) {
        initComponents();
        populateMakes();
        this.setTitle("Add PCCase");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
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

        lblMotherboard1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblMake = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        lblWidth = new javax.swing.JLabel();
        lblCDepth = new javax.swing.JLabel();
        lblColour = new javax.swing.JLabel();
        lblMotherboard = new javax.swing.JLabel();
        comboMake = new javax.swing.JComboBox();
        txtFieldModel = new javax.swing.JTextField();
        txtFieldPrice = new javax.swing.JTextField();
        txtFieldHeight = new javax.swing.JTextField();
        txtFieldWidth = new javax.swing.JTextField();
        txtFieldCDepth = new javax.swing.JTextField();
        txtFieldColour = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtFieldMotherboard = new javax.swing.JTextField();
        lblMotherboard2 = new javax.swing.JLabel();

        lblMotherboard1.setText("Motherboard:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PC Case");

        lblMake.setText("Make:");

        lblModel.setText("Model:");

        lblPrice.setText("Price (£):");

        lblHeight.setText("Height (mm):");

        lblWidth.setText("Width (mm):");

        lblCDepth.setText("CDepth (mm):");

        lblColour.setText("Colour:");

        lblMotherboard.setText("Motherboard:");

        comboMake.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        lblMotherboard2.setText("E.g. ATX, MicroATX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMotherboard)
                                    .addComponent(lblColour)
                                    .addComponent(lblCDepth)
                                    .addComponent(lblHeight)
                                    .addComponent(lblPrice)
                                    .addComponent(lblModel)
                                    .addComponent(lblMake)
                                    .addComponent(lblWidth)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(lblMotherboard2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboMake, 0, 76, Short.MAX_VALUE)
                                .addComponent(txtFieldModel)
                                .addComponent(txtFieldPrice)
                                .addComponent(txtFieldHeight)
                                .addComponent(txtFieldWidth)
                                .addComponent(txtFieldColour)
                                .addComponent(txtFieldMotherboard)
                                .addComponent(txtFieldCDepth)))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
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
                    .addComponent(lblPrice)
                    .addComponent(txtFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeight)
                    .addComponent(txtFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWidth)
                    .addComponent(txtFieldWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCDepth)
                    .addComponent(txtFieldCDepth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColour)
                    .addComponent(txtFieldColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMotherboard)
                    .addComponent(txtFieldMotherboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMotherboard2)
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // saves user inputs when the save button is actioned
        PCCase pccase = new PCCase();

        String make = comboMake.getSelectedItem().toString();
        String model = txtFieldModel.getText();
        String pricetest = txtFieldPrice.getText();
        String heightcheck = txtFieldHeight.getText();
        String widthcheck = txtFieldWidth.getText();
        String CDepthcheck = txtFieldCDepth.getText();
        String colour = txtFieldColour.getText();
        String motherboard = txtFieldMotherboard.getText();

        //validation of each text box - to ensure data is entered correctly
         if(model.isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, Please specify model", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (pricetest.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter price greater than 0", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (heightcheck.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter the Height of the case", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (widthcheck.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, the width of the case", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (CDepthcheck.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter the depth of the case", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (colour.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter the colour of case", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else if (motherboard.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error, please enter the compatable motherboard types", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }else{ //when input boxes are not empty
            //parsing variables from strings to required values
            double price = Double.parseDouble(pricetest);
            int height = Integer.parseInt(heightcheck);
            int width = Integer.parseInt(widthcheck);
            int CDepth = Integer.parseInt(CDepthcheck);
            
            //setting the variables so it can be entered into database
            pccase.setMake(make);
            pccase.setModel(model);
            pccase.setPrice(price);
            pccase.setHeight(height);
            pccase.setWidth(width);
            pccase.setCDepth(CDepth);
            pccase.setColour(colour);
            pccase.setMotherboard(motherboard);
            
            //if validation is successful, print the following 
            boolean succesful = pccase.savePCCase();
            if(succesful){
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Component Created", "Added", JOptionPane.INFORMATION_MESSAGE);
            new AdminMenu().setVisible(true);
             }
        
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // cancels form and returns to admin menu when button is actioned
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

    }
    //return the user to menu
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
            java.util.logging.Logger.getLogger(PCCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PCCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PCCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PCCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPCCase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboMake;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCDepth;
    private javax.swing.JLabel lblColour;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblMotherboard;
    private javax.swing.JLabel lblMotherboard1;
    private javax.swing.JLabel lblMotherboard2;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JTextField txtFieldCDepth;
    private javax.swing.JTextField txtFieldColour;
    private javax.swing.JTextField txtFieldHeight;
    private javax.swing.JTextField txtFieldModel;
    private javax.swing.JTextField txtFieldMotherboard;
    private javax.swing.JTextField txtFieldPrice;
    private javax.swing.JTextField txtFieldWidth;
    // End of variables declaration//GEN-END:variables
}
