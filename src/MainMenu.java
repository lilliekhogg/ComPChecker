
import javax.swing.JOptionPane;

/**
 *
 * @author Luke
 */
public class MainMenu extends javax.swing.JFrame {

    UserAccount currentUser;

    /**
     * Creates new form AdminMenu
     */
    public MainMenu() {
        initComponents();
        this.setTitle("Main Menu");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
    }

    MainMenu(UserAccount user) {
        initComponents();
        this.setTitle("Main Menu");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        currentUser = user;     //Assigns the user variable passed to this method to a new var
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdminMenu = new javax.swing.JLabel();
        btnCreateBuild = new javax.swing.JButton();
        btnEditBuilds = new javax.swing.JButton();
        btnCompareBuilds = new javax.swing.JButton();
        btnViewComponents = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnShareBuild = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        btnEditMyAcc = new javax.swing.JButton();
        btnLogOut = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        lblAdminMenu.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        lblAdminMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminMenu.setText("Main Menu");

        btnCreateBuild.setText("Create Build");
        btnCreateBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBuildActionPerformed(evt);
            }
        });

        btnEditBuilds.setText("View/Edit My Builds");
        btnEditBuilds.setMaximumSize(new java.awt.Dimension(107, 23));
        btnEditBuilds.setMinimumSize(new java.awt.Dimension(107, 23));
        btnEditBuilds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBuildsActionPerformed(evt);
            }
        });

        btnCompareBuilds.setText("Compare Builds");
        btnCompareBuilds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompareBuildsActionPerformed(evt);
            }
        });

        btnViewComponents.setText("View Components");
        btnViewComponents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewComponentsActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        btnShareBuild.setText("Share Build");
        btnShareBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShareBuildActionPerformed(evt);
            }
        });

        btnRequest.setText("Request Component");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnEditMyAcc.setText("Edit My Account");
        btnEditMyAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMyAccActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreateBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditBuilds, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEditMyAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnCompareBuilds, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShareBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnViewComponents, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogOut))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdminMenu)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditBuilds, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateBuild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompareBuilds, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewComponents, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShareBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditMyAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditBuildsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBuildsActionPerformed
        new EditBuilds(currentUser).setVisible(true);
    }//GEN-LAST:event_btnEditBuildsActionPerformed

    private void btnCreateBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBuildActionPerformed
        this.setVisible(false);
        new CreateAccountAdmin(currentUser).setVisible(true);
    }//GEN-LAST:event_btnCreateBuildActionPerformed

    private void btnShareBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShareBuildActionPerformed
        JOptionPane.showMessageDialog(this,
                "The code for sharing builds is incomplete.",
                "Not finished!",
                JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnShareBuildActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        JOptionPane.showMessageDialog(this,
                "The code for requesting components is incomplete.",
                "Not finished!",
                JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnEditMyAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMyAccActionPerformed
        JOptionPane.showMessageDialog(this,
                "The code for editing own account is incomplete.",
                "Not finished!",
                JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnEditMyAccActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.setVisible(false);
        new LogIn().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnViewComponentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewComponentsActionPerformed
        String[] choices = {"Accessory", "CPU", "Cooler", "GPU", "Motherboard", "Case", "PSU", "RAM", "Storage"};
        String input = (String) JOptionPane.showInputDialog(null, "Which type of part is being editted?",
                "Edit Component", JOptionPane.QUESTION_MESSAGE,
                null, // Use default icon
                choices, // Array of choices
                choices[0]); // Initial choice
        String myPart;
        EditComponent frm;

        switch (input) {

            case "Accessory":
                myPart = "Accessory";
                frm = new EditComponent(myPart, 0, currentUser, null); //
                this.setVisible(false);
                frm.setVisible(true);
                break;

            case "CPU":
                myPart = "CPU";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
            case "Motherboard":
                myPart = "Motherboard";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
            case "RAM":
                myPart = "RAM";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
            case "PSU":
                myPart = "PSU";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
            case "Cooler":
                myPart = "Cooler";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
            case "GPU":
                myPart = "GPU";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
            case "Case":
                myPart = "Case";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
            case "Storage":
                myPart = "Storage";
                frm = new EditComponent(myPart, 0, currentUser, null);
                this.setVisible(false);
                frm.setVisible(true);
                break;
        }
    }//GEN-LAST:event_btnViewComponentsActionPerformed

    private void btnCompareBuildsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompareBuildsActionPerformed
        JOptionPane.showMessageDialog(this,
                "The code for comparing builds is incomplete.",
                "Not finished!",
                JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnCompareBuildsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompareBuilds;
    private javax.swing.JButton btnCreateBuild;
    private javax.swing.JButton btnEditBuilds;
    private javax.swing.JButton btnEditMyAcc;
    private javax.swing.JToggleButton btnLogOut;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnShareBuild;
    private javax.swing.JButton btnViewComponents;
    private javax.swing.JLabel lblAdminMenu;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
