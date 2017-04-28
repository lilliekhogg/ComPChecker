
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author Tom
 * @author Lillie
 */
public class ChangePassword extends javax.swing.JDialog {

    UserAccount currentUser;
    /**
     * constructor determines the current user to return them to the correct screen
     * @param user
     */
    public ChangePassword(UserAccount user) {
        initComponents();
        currentUser = user;
        this.setTitle("Change Password");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
    }
    // constructor set to reference login

    /**
     * constructor to create the change password form
     */
    public ChangePassword(){
        initComponents();
        this.setTitle("Change Password");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordfield1 = new javax.swing.JPasswordField();
        passwordconfirmfield = new javax.swing.JPasswordField();
        lblConfPassword = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        passwordfield = new javax.swing.JPasswordField();
        lblLogo = new javax.swing.JLabel();
        lbloldpassword = new javax.swing.JLabel();
        oldpasswordfield = new javax.swing.JPasswordField();
        buttonChange = new javax.swing.JButton();
        txtFieldUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblConfPassword.setText("Confirm Password:");

        lblPassword.setText("Password:");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        lblLogo.setText("jLabel1");

        lbloldpassword.setText("Old Password:");

        buttonChange.setText("Change");
        buttonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeActionPerformed(evt);
            }
        });

        txtFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldUsernameActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbloldpassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblPassword)
                                        .addGap(3, 3, 3))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(lblConfPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonChange, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFieldUsername)
                                .addComponent(passwordfield)
                                .addComponent(passwordconfirmfield)
                                .addComponent(oldpasswordfield, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                        .addGap(180, 180, 180))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblLogo)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbloldpassword)
                    .addComponent(oldpasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfPassword)
                    .addComponent(passwordconfirmfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(buttonChange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * This method is used to validate the user inputs of the password change form
     */
    
    private void buttonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeActionPerformed
        // TODO add your handling code here:
        String username = String.valueOf(txtFieldUsername.getText());
        String oldPassword = String.valueOf(oldpasswordfield.getPassword());
        String password = String.valueOf(passwordfield.getPassword());
        String passwordConfirm = String.valueOf(passwordconfirmfield.getPassword());
        //if inputs are empty a error message is printed
        if (oldPassword.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please complete all fields!", "Complete All fields", JOptionPane.INFORMATION_MESSAGE);
            //netbeans connection to database vm
        } else if (password == passwordConfirm) {
            Connection con = DatabaseConnection.establishConnection();
            username = currentUser.getUsername();
            //checks if passwords entered are the same as the old pw
            boolean passwordSame = currentUser.checkPassword(username, oldPassword);
            //will change the password into the database
            if (passwordSame) {
                currentUser.changePassword(username,password);
                  JOptionPane.showMessageDialog(null, "Password Changed", "Successful", JOptionPane.INFORMATION_MESSAGE);
                
                
                
                
            } else {
                //print error
                JOptionPane.showMessageDialog(null, "The entered password does not match the password stored.", "Password Error", JOptionPane.INFORMATION_MESSAGE);

            }

        }


    }//GEN-LAST:event_buttonChangeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Returns the user to the log in page:
        this.setVisible(false);
        new LogIn().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldUsernameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChange;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblConfPassword;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lbloldpassword;
    private javax.swing.JPasswordField oldpasswordfield;
    private javax.swing.JPasswordField passwordconfirmfield;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JPasswordField passwordfield1;
    private javax.swing.JTextField txtFieldUsername;
    // End of variables declaration//GEN-END:variables
}
