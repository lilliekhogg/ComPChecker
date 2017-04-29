
import javax.swing.JOptionPane;

/**
 * <h1> Administrator Menu </h1>
 * The administrator menu displays the features admins have access to, as well
 * as some of the basic user functions (i.e. for testing). The user clicks a
 * button and is taken to a new form.
 *
 * @author Luke
 * @version 1.0
 * @since 2017-28-04
 */
public class AdminMenu extends javax.swing.JFrame {

    /**
     * Creates new form AdminMenu
     */
    UserAccount currentUser;
    //From the menu, this user var can be passed to other forms
    //This is important in checking the user and type of user

    /**
     * Default constructor for AdminMenu.
     */
    public AdminMenu() {
        initComponents();
    }

    /**
     * AdminMenu constructor taking UserAccount parameter.
     * @param user The constructor is passed the user argument which currentUser
     * is then set to which allows it to be accessed throughout the form
     */
    public AdminMenu(UserAccount user) {
        initComponents();
        this.setTitle("Admin Menu");     //Adds a title to the frame
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
        btnCreateAcc = new javax.swing.JButton();
        btnEditComp = new javax.swing.JButton();
        btnCreateBuild = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnAddMake = new javax.swing.JButton();
        btnNewComponent = new javax.swing.JButton();
        btnEditBuild = new javax.swing.JButton();
        btnLogOut = new javax.swing.JToggleButton();
        btnViewAccs = new javax.swing.JButton();
        btnStressTest = new javax.swing.JButton();
        btnCompatibility = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblAdminMenu.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        lblAdminMenu.setText("Admin Menu");

        btnCreateAcc.setText("Create Account");
        btnCreateAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccActionPerformed(evt);
            }
        });

        btnEditComp.setText("View & Edit Components");
        btnEditComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCompActionPerformed(evt);
            }
        });

        btnCreateBuild.setText("Create Build");
        btnCreateBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBuildActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        btnAddMake.setText("Add New Make");
        btnAddMake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMakeActionPerformed(evt);
            }
        });

        btnNewComponent.setText("New Component");
        btnNewComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewComponentActionPerformed(evt);
            }
        });

        btnEditBuild.setText("View & Edit Builds");
        btnEditBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBuildActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnViewAccs.setText("View & Edit Accounts");
        btnViewAccs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAccsActionPerformed(evt);
            }
        });

        btnStressTest.setText("Stress Test");
        btnStressTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStressTestActionPerformed(evt);
            }
        });

        btnCompatibility.setText("Add Incompatibility");
        btnCompatibility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompatibilityActionPerformed(evt);
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
                        .addComponent(lblLogo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogOut)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewAccs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStressTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewComponent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAdminMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddMake, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCreateBuild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditBuild, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(btnCompatibility, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdminMenu)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreateBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewAccs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditComp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddMake, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStressTest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnCompatibility, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the Edit Component Button is clicked, the user is faced with an
     * option pane where they can choose the type of component to edit, taking
     * them to the corresponding form
     */
    private void btnEditCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCompActionPerformed
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
    }//GEN-LAST:event_btnEditCompActionPerformed

    /**
     * Opens a form to create a build.
     */
    private void btnCreateBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBuildActionPerformed
        this.setVisible(false);
        new CreateBuild(currentUser).setVisible(true);
    }//GEN-LAST:event_btnCreateBuildActionPerformed

    /**
     * Opens a form to create an account (with admin options, seeing as this is
     * from the admin menu.
     */
    private void btnCreateAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccActionPerformed
        this.setVisible(false);
        new CreateAccountAdmin(currentUser).setVisible(true);
    }//GEN-LAST:event_btnCreateAccActionPerformed

    /**
     * Opens a form to add a make/brand.
     */
    private void btnAddMakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMakeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddMake(currentUser).setVisible(true);
    }//GEN-LAST:event_btnAddMakeActionPerformed

    /**
     * When the New Component Button is clicked, the user is faced with an
     * option pane where they can choose the type of component to add, taking
     * them to the corresponding form
     */
    private void btnNewComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewComponentActionPerformed
        String[] choices = {"Accessory", "CPU", "Cooler", "GPU", "Motherboard", "Case", "PSU", "RAM", "Storage"};
        String input = (String) JOptionPane.showInputDialog(null, "Which type of part is being added?",
                "New Part", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        switch (input) {

            case "Accessory":
                this.setVisible(false);
                new AddAccessory(currentUser).setVisible(true);
                break;

            case "CPU":
                AddCPU form = new AddCPU();
                form.btnEdit.hide();        //Hides button as saving new component.
                form.setVisible(true);
                this.setVisible(false);
                break;

            case "Motherboard":
                this.setVisible(false);
                new AddMotherboard(currentUser).setVisible(true);
                break;

            case "RAM":
                this.setVisible(false);
                new AddRAM(currentUser).setVisible(true);
                break;

            case "PSU":
                this.setVisible(false);
                new AddPSU(currentUser).setVisible(true);
                break;

            case "Cooler":
                this.setVisible(false);
                new AddCooler(currentUser).setVisible(true);
                break;

            case "GPU":
                this.setVisible(false);
                new AddGPU(currentUser).setVisible(true);
                break;

            case "Case":
                this.setVisible(false);
                new AddPCCase(currentUser).setVisible(true);
                break;

            case "Storage":
                this.setVisible(false);
                new AddStorage(currentUser).setVisible(true);
                break;

        }
    }//GEN-LAST:event_btnNewComponentActionPerformed

    /**
     * Opens a form to edit a build.
     */
    private void btnEditBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBuildActionPerformed
        new EditBuilds(currentUser).setVisible(true);
    }//GEN-LAST:event_btnEditBuildActionPerformed

    /**
     * Logs the user out back to the login form.
     */
    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.setVisible(false);
        new LogIn().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    /**
     * Opens a form to edit/view accounts.
     */
    private void btnViewAccsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAccsActionPerformed
        //this.setVisible(false);
        new EditAccounts(currentUser).setVisible(true);
    }//GEN-LAST:event_btnViewAccsActionPerformed

    /**
     * Stress tests the database.
     */
    private void btnStressTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStressTestActionPerformed
        // TODO add your handling code here:
        DatabaseConnection database = new DatabaseConnection();
        database.stressTest();
    }//GEN-LAST:event_btnStressTestActionPerformed

    /**
     * Opens a form to add a part incompatibility.
     */
    private void btnCompatibilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompatibilityActionPerformed
        this.setVisible(false);
        new CompatibilityIssue(currentUser).setVisible(true);
    }//GEN-LAST:event_btnCompatibilityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMake;
    private javax.swing.JButton btnCompatibility;
    private javax.swing.JButton btnCreateAcc;
    private javax.swing.JButton btnCreateBuild;
    private javax.swing.JButton btnEditBuild;
    private javax.swing.JButton btnEditComp;
    private javax.swing.JToggleButton btnLogOut;
    private javax.swing.JButton btnNewComponent;
    private javax.swing.JButton btnStressTest;
    private javax.swing.JButton btnViewAccs;
    private javax.swing.JLabel lblAdminMenu;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
