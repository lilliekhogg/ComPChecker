
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lillie
 */
public class AddGPU extends javax.swing.JFrame {

    UserAccount currentUser;

    /**
     * Default constructor for addGPU.
     */
    public AddGPU() {
        initComponents();
        this.setTitle("Add RAM");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
    }

    /**
     * Constructor for AddGPU
     *
     * @param user This determines who the user is so they can be returned to
     * the correct menu with the appropriate options.
     */
    
    AddGPU(UserAccount user) {
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
        comboMake = new javax.swing.JComboBox<>();
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

        comboMake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

    /**
     * When the user saves an this part, the new data is inserted and saved into
     * the database.
     */
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

        //validation - error message if inputs are wrong 
        if (model.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, Please specify model", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (pricetest.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter price greater than 0", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (series.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter a Series", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (chipset.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter a chipset", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (memoryCheck.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter the memory size", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (coreClockTest.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter the core clock", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else { //when input boxes are not empty - Parse values
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
            if (succesful) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "GPU Component Created", "Added", JOptionPane.INFORMATION_MESSAGE);
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
