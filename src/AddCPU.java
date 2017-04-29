
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tom
 */
public class AddCPU extends javax.swing.JDialog {

    UserAccount currentUser;
    int CPUID;

    /**
     * Default constructor for AddCPU.
     */
    public AddCPU() {

        initComponents();
        this.setTitle("Add CPU");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
    }

    /**
     * Constructor for AddCPU used in editing.
     *
     * @param ID sets the CPU ID.
     */
    public AddCPU(int ID) {

        initComponents();
        this.setTitle("Add CPU");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        populateMakes();
        CPUID = ID;

    }

    /**
     * Constructor for AddCPU.
     *
     * @param user passes the current user.
     */
    AddCPU(UserAccount user) {
        initComponents();
        this.setTitle("Add CPU");     //Adds a title to the frame
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

        cmboxMake = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtboxCores = new javax.swing.JTextField();
        txtboxSpeed = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        txtboxModel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtboxPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmboxMake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Make:");

        jLabel2.setText("Speed (GHz):");

        jLabel3.setText("Cores:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel5.setText("Model:");

        jLabel6.setText("Price(£):");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add CPU");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cmboxMake, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtboxModel)
                    .addComponent(txtboxPrice)
                    .addComponent(txtboxCores)
                    .addComponent(txtboxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmboxMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtboxModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtboxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtboxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtboxCores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the user saves an this part, the new data is inserted and saved into
     * the database.
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        CPU cpu = new CPU();

        String make = cmboxMake.getSelectedItem().toString();
        String model = txtboxModel.getText();
        String pricetest = txtboxPrice.getText();
        String speedtest = txtboxSpeed.getText();
        String corecheck = txtboxCores.getText();

        if (model.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, Please specify model", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (pricetest.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter price greater than 0", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (speedtest.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, please enter the speed of CPU in GHz", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else if (corecheck.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, the number of cores", "Error!", JOptionPane.INFORMATION_MESSAGE);
        } else { //when input boxes are not empty
            //parsing variables from strings to required values
            double price = Double.parseDouble(pricetest);
            float speed = Float.parseFloat(speedtest);
            int cores = Integer.parseInt(corecheck);
            //setting the input fields
            cpu.make = make;
            cpu.model = model;
            cpu.speed = speed;
            cpu.cores = cores;
            cpu.price = price;

            //checking if validation is successful
            boolean succesful = cpu.saveCPU();
            if (succesful) {
                JOptionPane.showMessageDialog(null, "CPU added", "CPU Added", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new AdminMenu(currentUser).setVisible(true);
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
     * Returns user to the menu.
     */
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
          JOptionPane.showMessageDialog(this,
          "The code for editing components is incomplete.",
          "Not finished!",
          JOptionPane.ERROR_MESSAGE);
//        CPU cpu = new CPU();
//        String make = cmboxMake.getSelectedItem().toString();
//        String text = txtboxSpeed.getText();
//        String model = txtboxModel.getText();
//        double price = 0;
//
//        float speed = 0;
//        int cores = 0;
//
//        if (text != null && !text.isEmpty()) {
//            speed = Float.parseFloat(text);
//        }
//        text = txtboxCores.getText();
//        if (text != null && !text.isEmpty()) {
//            cores = Integer.parseInt(text);
//        }
//        text = txtboxPrice.getText();
//        if (text != null && !text.isEmpty()) {
//            price = parseDouble(text);
//        }
//        cpu.updateCPU(CPUID, make, model, price, speed, cores, true);
    }//GEN-LAST:event_btnEditActionPerformed

    /**
     * Populates the make combobox with the different makes.
     */
    private void populateMakes() {
        //adding make to the database
        cmboxMake.removeAllItems();
        ResultSet rs;
        Make make = new Make();
        rs = make.getMakes();
        try {
            while (rs.next()) {
                String dbMake = rs.getString("Name");
                cmboxMake.addItem(dbMake);

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
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnSave;
    public javax.swing.JComboBox<String> cmboxMake;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField txtboxCores;
    public javax.swing.JTextField txtboxModel;
    public javax.swing.JTextField txtboxPrice;
    public javax.swing.JTextField txtboxSpeed;
    // End of variables declaration//GEN-END:variables
}
