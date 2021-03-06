
/**
 *
 * @author Tom
 */
public class EditAccount extends javax.swing.JFrame {

    UserAccount currentUser;
    UserAccount user;

    /**
     * Creates new form CreateAccount
     * @param thisCurrentUser object representing the current logged in user.
     * @param selectedUser object representing the user who is being eddited.
     */
    public EditAccount(UserAccount thisCurrentUser, UserAccount selectedUser) {
        initComponents();
        currentUser = thisCurrentUser;
        user = selectedUser;
        this.setTitle("Edit Account - Admin");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        txtboxUsername.setEditable(false);
        
        user.populateUser();
        
        txtboxUsername.setText(user.getUsername());
        txtboxName.setText(user.getFName());
        txtboxSurname.setText(user.getSName());
        txtboxEmail.setText(user.getEmail());
        boolean type = user.getType();

        if (type) {
            comboboxType.setSelectedItem("Admin");

        } else {
            comboboxType.setSelectedItem("General User");

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblusername = new javax.swing.JLabel();
        txtboxUsername = new javax.swing.JTextField();
        lblFname = new javax.swing.JLabel();
        lblSname = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtboxName = new javax.swing.JTextField();
        txtboxSurname = new javax.swing.JTextField();
        txtboxEmail = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblusername1 = new javax.swing.JLabel();
        comboboxType = new javax.swing.JComboBox<>();
        btnReturnToMenu = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblusername.setText("Username:");

        lblFname.setText("Forename:");

        lblSname.setText("Surname:");

        lblEmail.setText("Email:");

        txtboxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxNameActionPerformed(evt);
            }
        });

        btnSubmit.setText("Edit Account");
        btnSubmit.setActionCommand("CreateAccount");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        lblLogo.setText("jLabel1");

        lblusername1.setText("Type:");

        comboboxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General User", "Admin" }));

        btnReturnToMenu.setText("Return");
        btnReturnToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnToMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblusername)
                            .addComponent(lblusername1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtboxUsername)
                            .addComponent(comboboxType, 0, 178, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFname)
                            .addComponent(lblSname)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(txtboxName)
                            .addComponent(txtboxSurname)
                            .addComponent(txtboxEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))))
                .addGap(220, 220, 220))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReturnToMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblLogo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusername1)
                    .addComponent(comboboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusername)
                    .addComponent(txtboxUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFname)
                    .addComponent(txtboxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSname)
                    .addComponent(txtboxSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtboxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturnToMenu)
                    .addComponent(btnSubmit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtboxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboxNameActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        String fname = txtboxName.getText();
        String sname = txtboxSurname.getText();
        String email = txtboxEmail.getText();
        UserAccount newUser = new UserAccount();
        
        System.out.println(fname);
        String type = comboboxType.getSelectedItem().toString();
        
        user.setFname(fname);
        user.setSname(sname);
        user.setEmail(email);
        
        type = comboboxType.toString();
        if (type == "Admin") {
            user.setType(true);
        }else{
             user.setType(false);
        }
        
        user.editUser();
            
        if (type == "Admin") {
            newUser.setType(true);
        } else {
            newUser.setType(false);
        }
        System.out.println(fname  + sname + email + type);
        //this.setVisible(false);
        //new AdminMenu(currentUser).setVisible(true);

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnReturnToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnToMenuActionPerformed
        this.setVisible(false);
        new EditAccounts(currentUser).setVisible(true);
        //returnToMenu();
    }//GEN-LAST:event_btnReturnToMenuActionPerformed

    private void returnToMenu() {
        this.setVisible(false);
        if (currentUser.getType() == true) {        //User is admin
            new AdminMenu(currentUser).setVisible(true);
        } else {
            new MainMenu(currentUser).setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturnToMenu;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> comboboxType;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSname;
    private javax.swing.JLabel lblusername;
    private javax.swing.JLabel lblusername1;
    public javax.swing.JTextField txtboxEmail;
    public javax.swing.JTextField txtboxName;
    public javax.swing.JTextField txtboxSurname;
    public javax.swing.JTextField txtboxUsername;
    // End of variables declaration//GEN-END:variables
}
