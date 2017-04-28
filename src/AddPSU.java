
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luke
 */
public class AddPSU extends javax.swing.JFrame {

    UserAccount currentUser;

    /**
     * Creates new form AddPSU
     */
    public AddPSU() {
        initComponents();
        this.setTitle("Add PSU");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
    }

    /**
     * Constructor for PSU
     @param user This determines who the user is so they can be returned to
     * the correct menu with the appropriate options.
     */
    public AddPSU(UserAccount user) {
        initComponents();
        this.setTitle("Add PSU");     //Adds a title to the frame
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
        lblPrice = new javax.swing.JLabel();
        lblWattage = new javax.swing.JLabel();
        lblModular = new javax.swing.JLabel();
        comboMake = new javax.swing.JComboBox();
        txtFieldModel = new javax.swing.JTextField();
        txtFieldPrice = new javax.swing.JTextField();
        txtFieldWattage = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmboxModular = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PSU");

        lblMake.setText("Make:");

        lblModel.setText("Model:");

        lblPrice.setText("Price (£):");

        lblWattage.setText("Wattage:");

        lblModular.setText("Modular:");

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

        cmboxModular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMake)
                            .addComponent(lblWattage)
                            .addComponent(lblPrice)
                            .addComponent(lblModular)
                            .addComponent(lblModel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboMake, 0, 78, Short.MAX_VALUE)
                            .addComponent(txtFieldModel)
                            .addComponent(txtFieldPrice)
                            .addComponent(txtFieldWattage)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnSave))
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmboxModular, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
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
                    .addComponent(txtFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWattage)
                    .addComponent(txtFieldWattage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModular)
                    .addComponent(cmboxModular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the user saves an this part, the new data is inserted and saved into
     * the database.
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // sets inputs to the form when the save button is actioned

        PSU psu = new PSU();

        String make = comboMake.getSelectedItem().toString();
        String model = txtFieldModel.getText();
        String modulartest = cmboxModular.getSelectedItem().toString();
        String pricetest = txtFieldPrice.getText();
        String wattagetest = txtFieldWattage.getText();

        //adding validation to PSU for each field
        if (model.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, Please specify model", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (pricetest.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter price greater than 0", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (wattagetest.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter wattage greater than 0", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else { //when input boxes are not empty
            double price = Double.parseDouble(pricetest);
            int wattage = Integer.parseInt(wattagetest);
            boolean modular = Boolean.parseBoolean(modulartest);

            psu.setMake(make);
            psu.setModel(model);
            psu.setPrice(price);
            psu.setWattage(wattage);
            psu.setModular(modular);

            boolean successful = psu.savePSU();

            if (successful) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Component Created", "Added", JOptionPane.INFORMATION_MESSAGE);
                new AdminMenu().setVisible(true);
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Clicking calls returnToMenu() to return the user to the menu.
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        returnToMenu();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * Populates the make combobox with the different makes.
     */
    private void populateMakes() {
        ////method provides make types within combobox
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

        //making a drop down menu for modular - easier to allow user to enter
        //true or false rather than trying to enter strings
        cmboxModular.removeAllItems();
        ArrayList<String> modular = new ArrayList<String>();
        modular.add("True");
        modular.add("False");

        for (int i = 0; i < modular.size(); i++) {
            cmboxModular.addItem(modular.get(i));
        }

    }

    /**
     * Returns the user to the appropriate menu based on their user type.
     */
    private void returnToMenu() {
        this.setVisible(false);
        if (currentUser.getType() == true) {        //User is admin
            new AdminMenu(currentUser).setVisible(true);
        } else {
            new MainMenu(currentUser).setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmboxModular;
    private javax.swing.JComboBox comboMake;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblModular;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblWattage;
    private javax.swing.JTextField txtFieldModel;
    private javax.swing.JTextField txtFieldPrice;
    private javax.swing.JTextField txtFieldWattage;
    // End of variables declaration//GEN-END:variables
}
